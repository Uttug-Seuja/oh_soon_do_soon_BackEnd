package schjoin.SCH.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Participation{

    @Id @GeneratedValue
    @Column(name = "participation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;

    //==생성 메서드==//
    public static Participation createParticipation(User user, Reserve reserve){
        Participation participation = new Participation();
        participation.setUser(user);
        //reserve.addParticipation(participation);
        //participation.setReserve(reserve); // 연관 관계 메서드 사용?
        return participation;
    }

    //==비즈니스 로직==//
}