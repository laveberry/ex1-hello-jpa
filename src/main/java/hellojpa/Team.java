package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    /*
    mappedBy
    객체와 테이블간의 연관관계 맺는 차이
    객체 : 회원 단방향, 팀 = 단방향2 -> 둘중 하나로 외래키 관리를 해야함
    테이블 : 회원 <-> 팀 = 외래키로 연결된 양방향1
    - 객체의 두 관계 중 하나를 연관관계 주인으로 지정
    - 주인은 외래키 관리(등록, 수정)
    - 주인 아닌쪽은 읽기만 가능
    - 주인은 mappedBy 사용X, 주인 아닐때만 mappedBy 사용하여 주인 지정함
    - 주인은 외래키가 있는곳을 주인으로 지정, 왜냐면 PK가 있는곳 insert시 다른테이블 값이 update되어 곤란해질수 있고 성능이슈
    - 1:N -> db의 n쪽이 연관관계 주인이됨! 자동차와 바퀴 중 바퀴가 연관관계 주인
    * */
    @OneToMany(mappedBy = "team") //양방향 매핑 주인x - 읽기만 가능
    private List<Member> members = new ArrayList<>(); //NPE 예방을 위해 ArrayList 로 초기화가 관례

    //양방향 값추가 둘중 하나만 하면됨
//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    //toString 양방향 매핑 주의
}
