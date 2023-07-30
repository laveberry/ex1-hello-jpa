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

            //비영속
            Member member = new Member();
            member.setId(100L); //L : long타입 표시
            member.setName("HelloJPA");

            System.out.println("=== before === ");
            //영속
            em.persist(member);
            System.out.println("=== after ===");

            //준영속 : 회원 엔티티를 영속성 컨텍스트에서 분리
//            em.detach(member);
            //삭제 : 객체 삭제
//            em.remove(member);

//            Member findMember = em.find(Member.class, 1L);

//            System.out.println("findMember.getId()  ==>   " + findMember.getId());
//            System.out.println("findMember.getName()  ==>  " + findMember.getName());
//            //수정
//            findMember.setName("HelloJPA");

            //JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) //페이징 가능
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }

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
