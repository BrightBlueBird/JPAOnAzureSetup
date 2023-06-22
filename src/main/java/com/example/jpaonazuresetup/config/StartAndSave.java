package com.example.jpaonazuresetup.config;

import com.example.jpaonazuresetup.model.Exam;
import com.example.jpaonazuresetup.repository.ExamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class StartAndSave implements CommandLineRunner {
//hej
  ExamRepository examRepo;

  public StartAndSave(ExamRepository examRepo) {this.examRepo = examRepo;}



  @Override
  public void run(String... args) {
    Exam e1 = new Exam();
    e1.setDate(LocalDate.now());
    e1.setSubject("Teknologi");
    e1.setTime(LocalTime.now());
    examRepo.save(e1);

    Exam e2 = new Exam();
    e1.setDate(LocalDate.now().minusDays(10));
    e1.setSubject("Programmering");
    examRepo.save(e2);
  }
}
