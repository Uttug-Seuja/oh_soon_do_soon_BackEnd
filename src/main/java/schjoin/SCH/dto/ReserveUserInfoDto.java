package schjoin.SCH.dto;

import lombok.Getter;
import lombok.Setter;
import schjoin.SCH.domain.Participation;

@Getter
@Setter
public class ReserveUserInfoDto {

    private Long userId;
    private String name;
    private String schoolNum;


    public ReserveUserInfoDto(Participation participation){
        userId = participation.getUser().getId();
        name = participation.getUser().getName();
        schoolNum = participation.getUser().getSchoolNum();
    }
}
