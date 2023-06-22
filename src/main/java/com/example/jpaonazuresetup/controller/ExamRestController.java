package com.example.jpaonazuresetup.controller;

import com.example.jpaonazuresetup.model.Exam;
import com.example.jpaonazuresetup.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ExamRestController {

  @Autowired
  ExamRepository examRepository;

  @GetMapping("/exams")
  public List<Exam> exams() {
    List<Exam> ex = examRepository.findAll();
    return ex;
  }

  @GetMapping("/addstudent")
  public List<Exam> addExam() {
    Exam e = new Exam();
    e.setDate(LocalDate.now());
    e.setTime(LocalTime.now());
    List<Exam> lst = examRepository.findAll();
    e.setSubject("Systemudvikling");
    examRepository.save(e);
    System.out.println("Saved Exam: " + e.getSubject());
    return lst;
  }
}
