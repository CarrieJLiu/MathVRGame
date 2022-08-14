/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoring.test;

import tutoring.BusinessObjects.Singleton;

/**
 *
 * @author Carrie
 */
public class SingleTest {
    public static void main(String[] args){
        Singleton object =Singleton.getInstance();
        object.showMessage();
    }
}
