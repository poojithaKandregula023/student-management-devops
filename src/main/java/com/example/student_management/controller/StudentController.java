
package com.example.student_management.controller;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Display all students
    @GetMapping
    public String getAllStudents(Model model) {

        List<Student> students = studentService.getAllStudents();

        model.addAttribute("students", students);

        return "students";
    }

    // Display add student form
    @GetMapping("/new")
    public String showAddStudentForm(Model model) {

        model.addAttribute("student", new Student());

        return "add-student";
    }

    // Save new student
    @PostMapping
    public String addStudent(@ModelAttribute Student student) {

        studentService.addStudent(student);

        return "redirect:/students";
    }

    // Display edit student form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {

        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "edit-student";
    }

    // Update student
    @PostMapping("/update/{id}")
    public String updateStudent(
            @PathVariable Integer id,
            @ModelAttribute Student student) {

        studentService.updateStudent(id, student);

        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return "redirect:/students";
    }
}

