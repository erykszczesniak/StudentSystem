package com.erykszczesniak.studentsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

     @Autowired
    StudentService  studentService;


    @RequestMapping("/student")
    String viewHomePage(Model model){
        List<Student>studentList = studentService.listAll();
        model.addAttribute("studentList", studentList);
        return "index";
    }

    @RequestMapping("/new")
    String showNewStudentList(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String saveProduct(@ModelAttribute("student")Student student){
        studentService.save(student);
        return "redirect:/student";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView editStudent(@PathVariable(name = "id")int id){
        ModelAndView modelAndView = new ModelAndView("edit_student");
        Student student = studentService.get(id);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "redirect:/student";
    }



}
