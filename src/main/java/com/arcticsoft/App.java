package com.arcticsoft;

import java.util.List;

import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(new Student("Peter", "Keerts", "peter.k@mail.com"));
        em.persist(new Student("John", "Bates", "john.bates@mail.com"));
        transaction.commit();
        List<Student> students = em.createQuery("from Student", Student.class).setFlushMode(FlushModeType.COMMIT).getResultList();
        students.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}