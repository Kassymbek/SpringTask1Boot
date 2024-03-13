package javaspring.springtask1.db;

import javaspring.springtask1.model.Student;

import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 4L;
    static {
        students.add(new Student(1L,"Zhaksylyk","Kassymbek",95,"A"));
        students.add(new Student(2L,"Assem","Tursyn",85,"B"));
        students.add(new Student(3L,"Syrlybay","Bauyrzhan",49,"F"));
    }

    public static ArrayList<Student> getAllStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
        DBManager.getMarkByExamPoints(student);
    }

    public static void updateStudent(Long id,Student student){
      for(Student student1: students){
          if(student1.getId().equals(id)){
              students.set(Integer.parseInt(String.valueOf(id-1)),student);
          }
      }
        DBManager.getMarkByExamPoints(student);
    }

    public static void deleteStudent(Long id){
        Student s = new Student();
        for (Student student : students){
            if (student.getId()==id){
                s = student;
            }
        }
        students.remove(s);
    }
    public static void getMarkByExamPoints(Student student){
        if (student.getExam()>=60 && student.getExam()<=74){
            student.setMark("C");
        }else if (student.getExam()>=90){
            student.setMark("A");
        }
        else if (student.getExam()>=75 && student.getExam()<=89) {
            student.setMark("B");
        }
        else if (student.getExam()>=50 && student.getExam()<=59) {
            student.setMark("C");
        }else {
            student.setMark("F");
        }
    }
    public static Student getStudentById(Long id){
        for(Student stud : students) {
            if (stud.getId() == id) {
                return stud;
            }
        }
        return null;
    }
}
