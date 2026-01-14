package com.example.crudProject1.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.repository.query.Param;
import com.example.crudProject1.Models.RecordModel;
import com.example.crudProject1.Repository.RecordRepository;

@Controller
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter the Student Details");
        return "createRecord";
    }

    @PostMapping("/create")
    public String createActionProcess(RecordModel recordData, Model model) {
        recordRepository.save(recordData);
        model.addAttribute("message", "The Product " + recordData.getName() + " has been created successfully");
        return "createRecord";
    }

    @GetMapping("/all")
    public String getAllRecords(Model model, @Param("keyword") String keyword) {
        List<RecordModel> records;
        if (keyword != null && !keyword.isEmpty()) {
            records = recordRepository.findAllByKeyword(keyword);
        } else {
            records = recordRepository.findAll();
        }
        model.addAttribute("records", records);
        return "recordList";
    }

    @GetMapping("/update/{id}")
    public String updateRecord(@PathVariable Integer id, Model model) {
        Optional<RecordModel> optionalRecordDetails = recordRepository.findById(id);
        if (optionalRecordDetails.isPresent()) {
            model.addAttribute("recordDetails", optionalRecordDetails.get());
            return "updateRecord";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/update/{id}")
    public String updateProductProcess(@PathVariable Integer id, RecordModel recordData) {
        Optional<RecordModel> optionalRecordDetails = recordRepository.findById(id);
        if (optionalRecordDetails.isPresent()) {
            RecordModel recordDetails = optionalRecordDetails.get();
            recordDetails.setName(recordData.getName());
            recordDetails.setClassGrade(recordData.getClassGrade());
            recordDetails.setAge(recordData.getAge());
            recordRepository.save(recordDetails);
        }
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable Integer id, Model model) {
        Optional<RecordModel> optionalRecordDetails = recordRepository.findById(id);
        if (optionalRecordDetails.isPresent()) {
            model.addAttribute("recordDetails", optionalRecordDetails.get());
            return "deleteRecord";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/delete/{id}")
    public String deleteRecordProcess(@PathVariable Integer id) {
        recordRepository.deleteById(id);
        return "redirect:/all";
    }
}