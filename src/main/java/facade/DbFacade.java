/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Semester;
import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author craci
 */
public class DbFacade {

    EntityManagerFactory emf;

    public DbFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Student> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Student.findAll").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<Student> findAllByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Student.findByFirstname").setParameter("firstname", name).getResultList();
        }catch (Exception e){
            return null;
        } finally{
            em.close();
        }
    }
    
    public List<Student> findAllByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Student.findByLastname").setParameter("lastname", lastName).getResultList();
        }catch (Exception e){
            return null;
        } finally{
            em.close();
        }
    }
    
    public boolean addStudent(Student s){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        } finally{
            em.close();
        }
    }
    
    public boolean assignToSemesterById(Long id, Long semesterId){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Student s = em.find(Student.class, id);
            Semester sem = em.find(Semester.class, semesterId);
            s.setSemester(sem);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        } finally{
            em.close();
        }
    }
    
    public List<Student> totalOfPeopleInSemester(String semesterName){
        EntityManager em = emf.createEntityManager();
        try{
            List<Semester> sl = em.createNamedQuery("Semester.findByName").setParameter("name", semesterName).getResultList();
            List<Student> sli = em.createQuery("SELECT s FROM Student s WHERE s.semester = :semid").setParameter("semid", sl.get(0)).getResultList();
            return sli;
        }catch (Exception e){
            return null;
        } finally{
            em.close();
        }
    }
    
    
}
