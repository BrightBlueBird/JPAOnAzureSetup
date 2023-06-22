package com.example.jpaonazuresetup;

import com.example.jpaonazuresetup.model.Exam;
import com.example.jpaonazuresetup.repository.ExamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaOnAzureSetupApplicationTests {

   @Autowired
  ExamRepository examRepository;

  @Test
  void contextLoads() {
  }

  @Test
  void ExamUnitTest() {
    Exam e = new Exam();
    e.setSubject("Something");
    e.setDate(LocalDate.now());
    examRepository.save(e);

    Exam e1 = new Exam();
    e1.setSubject("Something2");
    e1.setDate(LocalDate.now().minusDays(1));
    examRepository.save(e1);
    List<Exam> lst = examRepository.findAll();
    assertEquals(2, lst.size());

    examRepository.delete(e);
    lst = examRepository.findAll();
    assertEquals(1, lst.size());


  }

}
