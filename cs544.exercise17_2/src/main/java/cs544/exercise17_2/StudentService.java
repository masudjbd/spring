package cs544.exercise17_2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {

    private StudentDAO studentdao;
    private SessionFactory sf;
    //private static SessionFactory sf = HibernateUtil.getSessionFactory();

    public StudentService() {
        //studentdao = new StudentDAO();
    }

    public void setStudentdao(StudentDAO studentdao) {
        this.studentdao = studentdao;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Student getStudent(long studentid) {
        //Transaction tx = sf.getCurrentSession().beginTransaction();
        Student student = studentdao.load(studentid);;
		//Hibernate.initialize(student.getCourselist());
        //tx.commit();
        return student;
    }
    
    public void createStudent() {
        studentdao.createStudent();
    }
}
