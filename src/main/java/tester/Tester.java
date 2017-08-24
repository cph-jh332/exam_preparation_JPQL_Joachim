/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Student;
import facade.DbFacade;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author craci
 */
public class Tester {
    public static void main(String[] args) {
        DbFacade dbf = new DbFacade(Persistence.createEntityManagerFactory("JPAPu1"));
        
        System.out.println("\r\n Find All Students: ");
        List<Student> sl = dbf.findAllStudents();
        for (Student student : sl) {
            System.out.println(student.getFirstname());
        }
        
        System.out.println("\r\n Find All Students Named Anders");
        sl = dbf.findAllByName("Anders");
        for (Student student : sl) {
            System.out.println(student.getFirstname());
        }
        
        System.out.println("\r\n Iserting Person");
        Student s = new Student();
        s.setFirstname("Lalili");
        s.setLastname("Babi");
        if(dbf.addStudent(s)){
            System.out.println("Succesfully added " + s.getFirstname());
        }else{
            System.out.println("Couldn't add" + s.getFirstname());
        }
        
        System.out.println("\r\n Find All Students With And As Lastname");
        sl = dbf.findAllByLastName("And");
        for (Student student : sl) {
            System.out.println(student.getFirstname() + " " + student.getLastname());
        }
        
        System.out.println("\r\n Assign Student To A Semester");
        if(dbf.assignToSemesterById(7l, 2l)){
            System.out.println("Succesfull");
        }else{
            System.out.println("Couldn't Assign That Person To That Semester");
        }
        
        System.out.println("\r\n Find Total Students By Semester Name");
        sl = dbf.totalOfPeopleInSemester("CLdat-a14e");
        int i;
        for (i = 0; i < sl.size(); i++) {
            System.out.println(sl.get(i).getFirstname());            
        }
        System.out.println("In total: " + i);
        
        System.out.println("\r\n Fin Total Students Of All Semesters");
    }
}
