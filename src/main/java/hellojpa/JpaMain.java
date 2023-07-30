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
//            Member member = new Member();
//            member.setId(100L); //L : long타입 표시
//            member.setName("HelloJPA");
//
//            System.out.println("=== before === ");
//            //영속
//            em.persist(member);
//            System.out.println("=== after ===");

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



            //1차 캐시 START==============================
            //조회 후 1차 캐시 저장
//            Member findMember = em.find(Member.class, 100L);
//            //조회 시 1차 캐시 조회(쿼리 실행안됨)
//            Member findMember2 = em.find(Member.class, 100L);
//
//            System.out.println("find id => "+ findMember2.getId());
//            System.out.println("find name => " + findMember2.getName());
//            //영속 엔티티 동일성 보장됨
//            System.out.println("result => " + (findMember == findMember2)); //true
            //1차 캐시 END==============================


            //영속성 컨텍스트, 커밋 시점 확인 START=================================
            //영속성 컨텍스트에 저장
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("==========인서트쿼리 실행시점 확인===========");
////
//            em.find(Member.class, 150L);
//            //자동 변경 감지 기능(자바 컬렉션 처럼)
//            findMember.setName("ZZZZ");
//            System.out.println("==========업데이트 쿼리 실행시점 확인===========");
            //영속성 컨텍스트, 커밋 시점 확인 END=================================


//            Member member3 = new Member(200L, "member200");
//            em.persist(member3);
//            /*
//            플러시
//            - 영속성 컨텍스트 비우지 않음
//            - 영속성 컨텍스트 변경내용을 db에 동기화
//           //커밋 반영전에 미리 실행하고 싶을때 플러시 사용
//            * */
//            em.flush();
//            System.out.println("==========플러시 시점 확인===========");

            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("AAAAA");
            //detach 준영속 : 특정 엔티티만 준영속 상태로
            em.detach(findMember);
            //clear : 엔티티 매니저안의 영속성 컨텍스트 초기화
            em.clear();
            // close : 영속성 컨텍스트 종료
            em.close();

            //이순간 db에 insert sql 작동됨
            //플러시 자동 호출
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
