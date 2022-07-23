/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.DTO;

/**
 *
 * @author Carrie
 */
public class Student {
    private Integer studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
  
    
       public Integer getStudentID(){
    	return studentID;
    }
    public void setStudentID(Integer studentID){
    	this.studentID = studentID;
    }
    
      public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    
     public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    
    
      public String getEmail(){
    	return email;
    }
    public void setEmail(String email){
    	this.email = email;
    }
    
    
    
    public String getPhoneNumber(){
    	return phoneNumber;
    }
       
    public void setPhoneNumber(String phoneNumber){
    	this.phoneNumber = phoneNumber;
    }
    
    
//      public String tryToApply(){
//
//        return applyType.apply();
//
//   }
//
//   
////
//    public void setApplyRe(Applys newApplyType){
//
//        applyType = newApplyType;
//
//    }

    
}
