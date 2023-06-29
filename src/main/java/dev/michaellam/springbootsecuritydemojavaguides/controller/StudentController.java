/*
 * @Author: Michael Lam 
 * @Date: 2023-06-29 15:02:53
 * @LastEditTime: 2023-06-29 15:49:14
 * @Description: 
 */
package dev.michaellam.springbootsecuritydemojavaguides.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.michaellam.springbootsecuritydemojavaguides.model.Student;

@RestController
public class StudentController {

  private List<Student> students = new ArrayList<>();

  @GetMapping("/students")
  public List<Student> students() {


    return students;

  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/students")
  public Student creatStudent(@RequestBody Student student){
    students.add(student);
    return student;
  }

}
