package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //이거 지정안하면 엔티티명
public class Album extends Item{
    private String artise;
}
