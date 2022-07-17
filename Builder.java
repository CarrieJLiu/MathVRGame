/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.BusinessObjects;

import tutoring.DTO.Course;

/**
 *
 * @author Carrie
 */
public class Builder {
    private String courseCode;
    private String courseName;
    private String courseDes;


    public String getCourseCode(){ return courseCode; }
	public String getCourseName(){ return courseName; }
	public String getCourseDes(){ return courseDes; }
     
    private Builder() { }

    public static Builder create() { return new Builder(); }
    
    public Builder courseCode (String courseCode)     { this.courseCode = courseCode;   return this; }
	public Builder courseName(String courseName) { this.courseName = courseName; return this; }
	public Builder courseDes (String courseDes)  { this.courseDes = courseDes;   return this; }
    
    public Course build() { return new Course(this); }
    
}
