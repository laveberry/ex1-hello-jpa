package hellojpa;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //JOIN테이블로 나누기
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일테이블 전략, 디폴트임, 성능우세
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //부모테이블(ITEM) 안만들어짐. 추상클래스(abstract)로 만들어야함
//@DiscriminatorColumn(name = "DIS_TYPE") //상속했을때 구분타입 디폴트 DTYPE, 단일테이블전략은 없어도 자동생성, JOIN에서만 의미있음
public abstract class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
