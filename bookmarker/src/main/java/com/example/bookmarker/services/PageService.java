package com.example.bookmarker.services;

import com.example.bookmarker.models.Bookmarks;
import com.example.bookmarker.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Page<Bookmarks> findPaginated(int pageNo, int pageSize, String username) {
        // Converting 1-based UI page to 0-based Spring page
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return bookmarkRepository.findByUsername(username, pageable);
    }
}