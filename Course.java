/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.DTO;

import tutoring.BusinessObjects.Builder;

/**
 *
 * @author Carrie
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String courseDes;
    
      public String getCourseCode(){
    	return courseCode;
    }
    public void setCourseCode(String courseCode){
    	this.courseCode = courseCode;
    }
    
     public String getCourseName(){
    	return courseName;
    }
    public void setCourseName(String courseName){
    	this.courseName = courseName;
    }
    
     public String getCourseDes(){
    	return courseDes;
    }
    public void setCourseDes(String courseDes){
    	this.courseDes = courseDes;
    }
    
    @Override
    public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[")
		.append(courseCode).append(" ")
		.append(courseName).append(" ")
		.append(courseDes).append("]"); // .append(System.lineSeparator());
		return sb.toString();
	}
    
    public Course(Builder builder)
	{
		courseCode = builder.getCourseCode();
		courseName = builder.getCourseName();
		courseDes = builder.getCourseDes();
	}
    
    public Course(String courseCode, String courseName, String courseDes){
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseDes = courseDes;
	}

    	public Course(String courseCode, String courseName){ 
		this(courseCode, courseName, null);
	}

	public Course(String courseCode){ 
		this(courseCode, null, null);
	}

	public Course(){ 
		this(null, null, null);
	}
    
    
}
