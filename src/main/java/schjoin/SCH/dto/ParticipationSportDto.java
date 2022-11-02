package schjoin.SCH.dto;


import lombok.Getter;

@Getter
public class ParticipationSportDto {

    private Long userId;
    private Long reserveId;

    public ParticipationSportDto(Long memberId, Long reserveId) {
        this.userId = userId;
        this.reserveId = reserveId;
    }
    public  ParticipationSportDto(){

    }

}
