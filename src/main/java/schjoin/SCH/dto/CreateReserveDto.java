package schjoin.SCH.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import schjoin.SCH.domain.Gender;
import schjoin.SCH.domain.Sport;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class CreateReserveDto {

    private Long userId;

    private String title;

    private String explanation;

    private Integer recruitmentNum;
    private Sport sport;

    private LocalTime endT;

    private LocalTime startT;

    private LocalDate reserveDate;

    private String place;

    private Gender gender;

    public CreateReserveDto(Long userId, String title, String explanation, Integer recruitmentNum, Sport sport, LocalTime endT, LocalTime startT, LocalDate reserveDate,String place,Gender gender) {
        this.userId = userId;
        this.title = title;
        this.explanation = explanation;
        this.recruitmentNum = recruitmentNum;
        this.sport = sport;
        this.endT = endT;
        this.startT = startT;
        this.reserveDate = reserveDate;
        this.place = place;
        this.gender = gender;
    }
    public CreateReserveDto(){

    }
}
