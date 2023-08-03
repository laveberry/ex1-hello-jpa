package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /*
    양방향 매핑시
    1. cascade
    -연관관계 매핑과 전혀 상관없음
    -ALL, PERSIST(저장시만 적용)
    -단일엔티티 종속일때만(단일소유자) 사용하고, child가 다른데서도 연관되어있으면 사용하지 말것

    2.orphanRemoval
    -부모와 연관관계 끊기면 삭제
    -OneToOne, OneToMany만 사용
    * */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
