package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "MBR") //다른 테이블 이름 매핑
public class Member {
    @Id
    private Long id;
    @Column(name = "name", unique = true, length = 10, insertable = true, updatable = false, nullable = false)
    private String username;
    //BigDecimal : 큰 숫자일때
    private BigDecimal age;
    //enum타입 사용 원할때
    //ORDINAL : 순서 저장(위험함), STRING : 이름 저장
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    //@Temporal : 날짜 매핑, 과거버전
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    //LocalDate : 최신버전
    private LocalDate testLocalDate;//년월
    private LocalDateTime testLocalDateTime;//년월일
    //대형 컨텐츠, 문자 CLOB, 나머지 BLOB
    @Lob
    private String description;

    @Transient //db매핑 안하고 메모리에서만 사용
    private int temp;

    //기본 생성자 필요
    public Member() {
    }

    //생성자 생성
    public Member(Long id, String name) {
        this.id = id;
        this.username = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }
}
