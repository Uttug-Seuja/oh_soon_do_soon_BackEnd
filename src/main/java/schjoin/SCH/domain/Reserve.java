package schjoin.SCH.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Reserve {

    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //orphanRemoval = true를 사용하면 부모의 엔티티가 사라지면 자식들도 다 사라진다 participations인 컬렉션은 다 날라간다
    @OneToMany(mappedBy = "reserve", orphanRemoval = true)
    private List<Participation> participations = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Sport sport;

    private LocalDate reserveDate;
    private LocalTime startT;
    private LocalTime endT;
    private LocalDateTime nowReserveT;

    private String title;
    private String explanation;
    private String place;
    private Integer currentNum;
    private Integer recruitmentNum;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;

    //==연관관계 메서드==//
    public void addParticipation(Participation participation){

        participations.add(participation);
        participation.setReserve(this);
    }

    public void subParticipation(Participation participation){
        participations.remove(participation);
        participation.setReserve(this);
    }

    //==생성 메서드==//
    public static Reserve createReserve(User user, String title, String explanation,
                                        Integer recruitmentNum, Sport sport, LocalTime endT, LocalTime startT, LocalDate reserveDate, String place, Gender gender){
        Reserve reserve = new Reserve();
        reserve.setUser(user);
        reserve.setExplanation(explanation);
        reserve.setReserveDate(reserveDate);
        reserve.setStartT(startT);
        reserve.setEndT(endT);
        reserve.setRecruitmentNum(recruitmentNum);
        reserve.setTitle(title);
        reserve.setSport(sport);
        reserve.setNowReserveT(LocalDateTime.now());
        reserve.setCurrentNum(1);
        reserve.setPlace(place);
        reserve.setGender(gender);
        reserve.setReserveStatus(ReserveStatus.POSSIBLE);

        return reserve;
    }

    //비즈니스 로직//

    //현재원 늘리기
    public void addCurrentNum(){
        this.currentNum++;
    }

    //현재원 줄이기
    public void subtractCurrentNum(){
        this.currentNum--;
    }


    // 참석한 인원에 따라 예약 상태 변경 비지니스로직
    public void roomStatus(){
        if(this.recruitmentNum*0.8 <= this.currentNum && this.currentNum < this.recruitmentNum )  {
            this.setReserveStatus(ReserveStatus.IMMINENT);
        }
        else if(this.currentNum==this.recruitmentNum){
            this.setReserveStatus(ReserveStatus.DEADLINE);
        }
    }


}