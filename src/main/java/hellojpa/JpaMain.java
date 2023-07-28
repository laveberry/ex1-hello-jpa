package hellojpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        System.out.println("실행 잘됨!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    }
}
