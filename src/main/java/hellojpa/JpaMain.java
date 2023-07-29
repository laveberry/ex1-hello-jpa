package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //실행시점 한번만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //쿼리 실행시 호출, 스레드간 공유X
        EntityManager em = emf.createEntityManager();

        //트랜젝션 안에서 항상 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //실제 코드 작성 부분

            //생성
//            Member member = new Member();
//            member.setId(2L); //L : long타입 표시
//            member.setName("HelloB");

//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);

//            System.out.println("findMember.getId()  ==>   " + findMember.getId());
//            System.out.println("findMember.getName()  ==>  " + findMember.getName());
//            //수정
//            findMember.setName("HelloJPA");

            //JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) //페이징 가능
                    .setMaxResults(8)
                    .getResultList();

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            //항상 닫아줘야함
            em.close();
        }
        emf.close();
    }
}
