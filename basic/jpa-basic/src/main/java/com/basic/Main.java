package com.basic;

import com.basic.jpa.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //DB관련 코드 실행부
        //아래처럼 하면 실행 안됌 JPA는 무족건 TX 작업 단위로 실행되기 때문이지
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("김성현");
//            em.persist(member); //영속성 저장

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member member = new Member();
        member.setId(1L);
        member.setName("김성현");
        em.persist(member); //영속성 저장
        tx.commit();

//        tx.rollback();

        //DB관련 코드 실행부
        em.clear();
        emf.close();
    }
}