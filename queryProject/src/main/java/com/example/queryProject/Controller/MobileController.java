package com.example.queryProject.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.queryProject.Model.Mobile;
import com.example.queryProject.Repository.MobileRepository;

@Controller
public class MobileController {

    @Autowired
    private MobileRepository mobileRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Product Details");
        return "create";
    }

    @PostMapping("/create")
    public String createActionProcess(Mobile mobileData, Model model) {
        mobileRepository.save(mobileData);
        model.addAttribute("message", "The Product " + mobileData.getName() + " has been added successfully");
        return "create";
    }
    
    @GetMapping("/products")
    public String productdetails(Model model) {
        List<Mobile> products = mobileRepository.findAllModels();
        List<Mobile> filteredProducts = mobileRepository.findBudgetModels();
        List<Mobile> androidProducts = mobileRepository.findAndroid();
        List<Mobile> iphoneProducts = mobileRepository.findiPhone();
        model.addAttribute("products", products);
        model.addAttribute("filteredProducts", filteredProducts);
        model.addAttribute("androidProducts", androidProducts);
        model.addAttribute("iphoneProducts", iphoneProducts);
        return "list";
    }
}