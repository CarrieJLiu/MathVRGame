/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.test;

import tutoring.BusinessObjects.Builder;
import tutoring.DTO.Course;

/**
 *
 * @author Carrie
 */
public class BuilderTest {
    public static void main(String[] args){
        
        Course a = Builder.create().courseCode("A01").courseName("Java").courseDes("good").build();
         Course b = Builder.create().courseCode("A02").courseName("Networking").courseDes("good").build();
         
          System.out.println(a);
           System.out.println(b);
    }    
}
