package javaspring.springtask1.controller;

import javaspring.springtask1.db.DBManager;
import javaspring.springtask1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
   @GetMapping(value = "/")
    public String indexPage(Model model){

       ArrayList<Student> studentArrayList = DBManager.getAllStudents();
       model.addAttribute("attributeAllStudents",studentArrayList);
       return "index";
   }

   @GetMapping(value = "/addStudent")
    public String addStudentPage(){
       return "addStudent";
   }
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String studentName,
                             @RequestParam(name = "surname") String studentSurname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setExam(exam);
        DBManager.addStudent(student);
        return "redirect:/";
    }
    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id,
                          Model model){
        Student student = DBManager.getStudentById(id);
        model.addAttribute("studentAttr", student);
        return "details";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        DBManager.deleteStudent(id);
        return "redirect:/";
    }

    @PostMapping(value = "/update/{id}")
    public String updateById(@PathVariable(value = "id") Long id,
                             @RequestParam(name = "name") String studentName,
                             @RequestParam(name = "surname") String studentSurname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(studentName);
        student.setId(id);
        student.setSurname(studentSurname);
        student.setExam(exam);
        DBManager.updateStudent(id,student);
        return "redirect:/";
    }
}

