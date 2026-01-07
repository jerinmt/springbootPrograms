package com.example.passObject2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.passObject2.models.Record;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RecordController {

    @GetMapping("/student-info")
    public String getStudentInfo(Model model) {
        Record record = new Record(101,"Anjali Sharma",(float) 92.5);
        model.addAttribute("record", record);
        return "studentInfo";
    }

    @GetMapping("/student-list")
    public String getStudentList(Model model) {
        List<Record> records = new ArrayList<>();
        records.add(new Record(101,"Anjali Sharma",(float) 92.5));
        records.add(new Record(102,"Rohit Mehta",(float) 85.0));
        records.add(new Record(103,"Sreya Iyer",(float) 78.6));
        model.addAttribute("records", records);
        return "studentList";
    }
}