package com.example.bookmarker.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.bookmarker.models.Bookmarks;
import com.example.bookmarker.repository.BookmarkRepository;
import org.springframework.data.repository.query.Param;
import com.example.bookmarker.services.PageService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;


@Controller
public class BookmarkController {

    @Autowired
    private BookmarkRepository bookmarkRepository;
    
    @Autowired
    private PageService pageService;

    @GetMapping("/")
    public String handleRedirect(@AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return "redirect:/profile";
        }
        return "index";
    }
    
    @PostMapping("/create")
    public String createActionProcess(Bookmarks bookmarkData, Model model, @AuthenticationPrincipal UserDetails user) {
    	Page<Bookmarks> bookmarkPage = pageService.findPaginated(1, 3, user.getUsername());
    	long count = bookmarkPage.getTotalElements();
    	if(count<5) {
    		bookmarkData.setUsername(user.getUsername());
        	bookmarkRepository.save(bookmarkData);
            model.addAttribute("message", "The bookmark " + bookmarkData.getTitle() + " has been added"); 
    	} else {
    		model.addAttribute("message", "Cannot save more than 5 bookmarks");
    	}

        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String getAllBookmarks(Model model, @RequestParam(defaultValue = "1") int page, @AuthenticationPrincipal UserDetails user) {
    	int pageSize = 3;
    	Page<Bookmarks> bookmarkPage = pageService.findPaginated(page, pageSize, user.getUsername());
    	List<Bookmarks> bookmarks = bookmarkPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookmarkPage.getTotalPages());
        model.addAttribute("count", bookmarkPage.getTotalElements());
        model.addAttribute("bookmarks", bookmarks);
        model.addAttribute("welcome", "Hi "+user.getUsername());
        return "profile";
    }
    
    @GetMapping("/search")
    public String getSearchBookmarks(Model model, @Param("keyword") String keyword, @AuthenticationPrincipal UserDetails user) {
    	List<Bookmarks> bookmarks;
        if (keyword != null && !keyword.isEmpty()) {
            bookmarks = bookmarkRepository.findAllByKeyword(keyword, user.getUsername());
        } else {
        	model.addAttribute("message", "No matching entries");
        	return "redirect:/profile";
        }    	    	                           
        model.addAttribute("bookmarks", bookmarks);
        return "search";
    }

    @GetMapping("/update/{id}")
    public String updateBookmark(@PathVariable Integer id, Model model, @AuthenticationPrincipal UserDetails user) {
        Optional<Bookmarks> optionalBookmarkDetails = bookmarkRepository.findBy(user.getUsername(), id);
        if (optionalBookmarkDetails.isPresent()) {
            model.addAttribute("bookmark", optionalBookmarkDetails.get());
            return "update";
        }
        return "redirect:/profile"; // Handle not found case
    }

    @PostMapping("/update/{id}")
    public String updateBookmarkProcess(@PathVariable Integer id, Bookmarks bookmarkData, @AuthenticationPrincipal UserDetails user) {
        Optional<Bookmarks> optionalBookmarkDetails = bookmarkRepository.findBy(user.getUsername(), id);
        if (optionalBookmarkDetails.isPresent()) {
            Bookmarks bookmarkDetails = optionalBookmarkDetails.get();
            bookmarkDetails.setTitle(bookmarkData.getTitle());
            bookmarkDetails.setSavedURL(bookmarkData.getSavedURL());
            bookmarkDetails.setSavedDate(bookmarkData.getSavedDate());
            bookmarkRepository.save(bookmarkDetails);
        }
        return "redirect:/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookmark(@PathVariable Integer id, Model model, @AuthenticationPrincipal UserDetails user) {
        Optional<Bookmarks> optionalBookmarkDetails = bookmarkRepository.findBy(user.getUsername(), id);
        if (optionalBookmarkDetails.isPresent()) {
            model.addAttribute("bookmark", optionalBookmarkDetails.get());
            return "delete";
        }
        return "redirect:/profile"; // Handle not found case
    }

    @PostMapping("/delete/{id}")
    public String deleteBookmarkProcess(@PathVariable Integer id, @AuthenticationPrincipal UserDetails user) {
        bookmarkRepository.deleteById(id);
        return "redirect:/profile";
    }
}