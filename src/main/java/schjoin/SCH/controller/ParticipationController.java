package schjoin.SCH.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.dto.CancelParticipationDto;
import schjoin.SCH.dto.ParticipationSportDto;
import schjoin.SCH.dto.ReserveUserInfoDto;
import schjoin.SCH.response.DefaultRes;
import schjoin.SCH.response.StatusCode;
import schjoin.SCH.service.ParticipationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ParticipationController {

    private final ParticipationService participationService;


    //참여 하기

    @PostMapping("participants/participation")
    public ResponseEntity participateSport(@RequestBody @Validated ParticipationSportDto participationSportDto){
        Long participation = participationService.participation(participationSportDto);

        return participation != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "경기 참여 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



    // 참여 취소
    @DeleteMapping("participants/delete")
    public ResponseEntity cancelParticipation(@RequestBody @Validated CancelParticipationDto cancelParticipationDto){

        Long participationId = participationService.cancelParticipation(cancelParticipationDto);

        return participationId != null ?

        new ResponseEntity(DefaultRes.res(StatusCode.OK, "경기 참여 취소"), HttpStatus.OK):
        new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



    // 경기 참가자 이름 학번 보여주기

    @GetMapping("participants/{reserveId}/users-info")
    public ResponseEntity reserve2(@PathVariable("reserveId") Long reserveId) {

        List<Participation> participations = participationService.reserveInfo(reserveId); // 경기 정보


        List<ReserveUserInfoDto> collect = participations.stream().map(p -> new ReserveUserInfoDto(p)).collect(Collectors.toList());

        return collect != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "경기 정보 보여주기 완료", collect), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);

    }



}
