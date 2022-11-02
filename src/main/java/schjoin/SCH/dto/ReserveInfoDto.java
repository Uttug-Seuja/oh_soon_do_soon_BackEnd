package schjoin.SCH.dto;


import lombok.Getter;
import lombok.Setter;
import schjoin.SCH.domain.Gender;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Sport;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ReserveInfoDto {

    private Long id;

    private Sport sport;

    private LocalDate reserveDate;
    private LocalTime startT;
    private LocalTime endT;

    private String title;
    private String explanation;
    private Integer currentNum;
    private Integer recruitmentNum;

    private String name;
    private String schoolNum;

    private String place;

    private Gender gender;

    public ReserveInfoDto(Participation participation){

        id = participation.getReserve().getId();
        sport = participation.getReserve().getSport();
        reserveDate = participation.getReserve().getReserveDate();
        startT = participation.getReserve().getStartT();
        endT = participation.getReserve().getEndT();
        title = participation.getReserve().getTitle();
        explanation = participation.getReserve().getExplanation();
        currentNum = participation.getReserve().getCurrentNum();
        recruitmentNum = participation.getReserve().getRecruitmentNum();

        name = participation.getUser().getName();
        schoolNum = participation.getUser().getSchoolNum();

        place = participation.getReserve().getPlace();
        gender = participation.getReserve().getGender();
    }
}
