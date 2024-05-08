package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("Hello++++++qweqwe");

//            System.out.println("--------"+findMember.getId());
//            System.out.println("--------"+findMember.getName());
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();
    }
}
