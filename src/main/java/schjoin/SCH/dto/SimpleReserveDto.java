package schjoin.SCH.dto;


import lombok.Getter;
import schjoin.SCH.domain.Gender;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.ReserveStatus;
import schjoin.SCH.domain.Sport;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class SimpleReserveDto {


    private Long userId;
    private Long reserveId;
    private Sport sport;

    private LocalDate reserveDate;

    private LocalTime startT;

    private LocalTime endT;


    private String title;
    private String explanation;

    private Integer currentNum;

    private Integer recruitmentNum;

    private Gender gender;

    private ReserveStatus reserveStatus;

    public SimpleReserveDto(Reserve reserve){
        userId = reserve.getUser().getId();
        reserveId = reserve.getId();
        sport=reserve.getSport();
        reserveDate =reserve.getReserveDate();
        startT = reserve.getStartT();
        endT = reserve.getEndT();
        title = reserve.getTitle();
        explanation = reserve.getExplanation();
        currentNum = reserve.getCurrentNum();
        recruitmentNum = reserve.getRecruitmentNum();
        gender = reserve.getGender();
        reserveStatus = reserve.getReserveStatus();

    }

}
