package com.example.jpaonazuresetup.repository;

import com.example.jpaonazuresetup.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamRepository extends JpaRepository <Exam, Integer>{

  Optional<Exam> findBySubject(String subject);
}
