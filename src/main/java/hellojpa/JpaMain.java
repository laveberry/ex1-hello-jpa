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

//            Member findMember = em.find(Member.class, 150L);
////            findMember.setName("AAAAA");
//            //detach 준영속 : 특정 엔티티만 준영속 상태로
//            em.detach(findMember);
//            //clear : 엔티티 매니저안의 영속성 컨텍스트 초기화
//            em.clear();
//            // close : 영속성 컨텍스트 종료
//            em.close();
//
//            //이순간 db에 insert sql 작동됨
//            //플러시 자동 호출
//            tx.commit();

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//
//            em.persist(member);
//
//            //이거 해줘야 db에서 값을 깔끔하게 가져옴
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
            ////단방향 연관관계 /////
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam => " + findTeam.getName());
//
//            //팀 바꾸고 싶을때
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);
            ////단방향 연관관계 끝/////


            ////양방향 연관관계 //////
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members) {
//                System.out.println("m = " + m.getName());
//            }
            ////양방향 연관관계 끝//////

//            Team team = new Team();
//            team.setName("TeamA");
//            //역방향(주인아닌)만 연관관계 설정시 teamId 값이 null이 됨
////            team.getMembers().add(member);
//            em.persist(team);//**1
//
//            Member member = new Member();
//            member.setName("member1");
//            //연관관계 주인에  값 넣기
////            member.setTeam(team);
//            member.changeTeam(team);//이 안에서 양방향 세팅 진행
//            em.persist(member);

            /*순수 객체 상태 생각해 항상 양쪽 값 세팅 해줄것
            양방향 연관관계는 값을 두개 다 세팅 해 주는게 좋음! 아니면 flush clear 선 진행 해줘야함!
            주인 set할때 적용이 좋은방법! Memeber team setter(changeTeam) 확인할것 */
//            team.getMembers().add(member);//**2

            //양방향 세팅 요렇게 해도됨 둘중 하나만 하면됨
//            team.addMember(member);

//            em.flush();
//            em.clear();

            //flush, clear 하지 않고 두개다 넣지 않으면 조회가 정상작동 안함. 그러니 두개 다 할당해주어야함
//            Team findTeam = em.find(Team.class, team.getId()); //1차 캐시
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("=====================");
//            for(Member m : members){
//                System.out.println("m = " + m.getName());
//            }
            ///[N:1] 다대일 끝////


            //[1:N] 일대다 시작////
//            Member member = new Member();
//            member.setName("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            //이부분 애매함. 업데이트 쿼리 한번 더 나가야함
//            team.getMembers().add(member);
//
//            em.persist(team);
            ////일대다 끝////

            ///상속 조인전략 시작////
            Movie movie = new Movie();
            movie.setDirector("이준익");
            movie.setActor("안효섭");
            movie.setName("스타트업");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            //부모타입으로 조회시 TABLE_PER_CLASS일때 유니온올로 다 연결되서 비효율
            Item findIem = em.find(Item.class, movie.getId());

            System.out.println("findMove => " + findMovie);
            System.out.println("findItem => " + findIem);

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
