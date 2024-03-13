package javaspring.springtask1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
   private Long id;
   private String name;
   private  String surname;
   private int exam;
   private String mark;
}
