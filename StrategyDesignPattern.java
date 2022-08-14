/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.test;
import java.util.Scanner;
import tutoring.BusinessObjects.Login;
import tutoring.BusinessObjects.SutdentLogin;
import tutoring.BusinessObjects.TutorLogin;

/**
 *
 * @author Carrie
 */
public class StrategyDesignPattern {
    public static void main(String[] args)
    {
        System.out.println("please type the login mode,student or tutor");
 Scanner scanner = new Scanner(System.in);
 String loginType = scanner.next();
 System.out.println("login type is : " + loginType);
 
 Login login;
 login = new Login();


if("Student".equalsIgnoreCase(loginType)){
login.setStrategy(new SutdentLogin());

}
else if("Tutor".equalsIgnoreCase(loginType)){
login.setStrategy(new TutorLogin());
}
System.out.println("Mode of login has : "+ 
 login.getStrategy());
 login.gotoLoginPage();
    }
}
    
