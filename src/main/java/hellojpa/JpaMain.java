package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
//            Movie movie = new Movie();
//            movie.setDirector("이준익");
//            movie.setActor("안효섭");
//            movie.setName("스타트업");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            //부모타입으로 조회시 TABLE_PER_CLASS일때 유니온올로 다 연결되서 비효율
//            Item findIem = em.find(Item.class, movie.getId());
//
//            System.out.println("findMove => " + findMovie);
//            System.out.println("findItem => " + findIem);
//
//            Member member = new Member();
//            member.setName("user1");
//            member.setCreateBy("kim");
//            member.setCreatedDate(LocalDateTime.now());


            ///프록시 시작
//            Member member1 = em.find(Member.class, 1L);
////            printMember(member1);
//            printMemberAndTeam(member1);

//            Member member = new Member();
//            member.setName("member1");
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member.getId());
////            Member m2 = em.find(Member.class, member2.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            //타입비교 : find이용시 true, getReference와 비교시 ture
//            System.out.println("m1 == m2" + (m1.getClass() == m2.getClass()));

            //타입체크 예시 메소드
//            logic(m1, m2);
//
//            //둘다 값 같음
//            System.out.println("m1 = " + m1.getClass());
//            Member reference = em.getReference(Member.class, member.getId());
//            System.out.println("reference = " + reference.getClass());
//            //pk가 같으면 jpa는 항상 트루?
//            System.out.println("a == a : " + (m1 == reference)); //true

            //영속성컨텍스트 제거하여, ref 초기화시 에러남.
//            em.detach(m2);
//            em.close();

//            System.out.println("프록시 초기화 -> " + m2.getName());

            //프록시 초기화여부 확인
//            System.out.println("isLoaded => " + emf.getPersistenceUnitUtil().isLoaded(m2));
//
//            Hibernate.initialize(m2);//강제 초기화

            /*
            getReference 실제 사용시점에서 호출됨.
            가짜(프록시)엔티티 객체 조회
            * */
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("beford findMember  =>  " + findMember.getClass());
//            System.out.println("findMember.id   " + findMember.getId());
//            System.out.println("findMember.username   " + findMember.getName());
//            System.out.println("after findMember  =>  " + findMember.getClass());

            //
/*
            ///즉시로딩과 지연로딩
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            //1. LAZY
            Member m = em.find(Member.class, member.getId()); //pk찍어서 가져와서 jpa가 최적화 가능

            System.out.println("엠" + m.getId());

            //m.getTeam()은 프록시 가져오는거라 초기화아님
            System.out.println("m = " + m.getTeam().getClass());

            System.out.println("==================");
            //지연로딩 세팅시 프록시로 가져옴. 이 시점에서 팀 초기화 됨
            System.out.println("팀명 ==> " + m.getTeam().getName());;
            System.out.println("==================");

            //2. EAGER - JPQL 사용시 쿼리 여러번 호출됨
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                            .getResultList();

            //LAZY 적용후 패치조인으로 해결. 값이 채워져 있어서 루프 돌려도 계속 쿼리 나오지않음
            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();



            ///////#### 영속성전이와 고아객체 #####
            Child child1 = new Child();
            Child child2 = new Child();
            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);


            em.persist(parent);
            //cascade = CascadeType.ALL 로 세팅하면 parent연관된 child도 진행되니 안해줘도됨
//            em.persist(child1);
//            em.persist(child2);
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);
*/

            ///임베디드 타입 시작
            Member member = new Member();
            member.setName("임베디드");
            member.setAddress(new Address("city", "street", "zipcode"));
            member.setPeriod(new Period());

            em.persist(member);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            //항상 닫아줘야함
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        //m1, m2 가 실제일지 프록시로 넘어올지 알수 없으니 타입비교 절대 ==로 하면안됨!
        System.out.println("logic m1 == m2" + (m1.getClass() == m2.getClass()));//x
        System.out.println("m1 instanceof  =>  " + (m1 instanceof Member));
        System.out.println("m2 instanceof  =>  " + (m2 instanceof Member));

    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
