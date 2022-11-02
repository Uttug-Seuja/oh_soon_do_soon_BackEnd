package schjoin.SCH.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.dto.*;
import schjoin.SCH.response.DefaultRes;
import schjoin.SCH.response.StatusCode;
import schjoin.SCH.service.ReserveService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;



    // 경기 생성
    @PostMapping("reserves/creation")
    public ResponseEntity createReserve(@RequestBody CreateReserveDto createReserveDto){

        Long reserve = reserveService.reserve(createReserveDto);

        return reserve != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "구장 예약 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



    //경기 업데이트
    @PostMapping("reserves/edit")
    public ResponseEntity updateReserve(@RequestBody @Validated UpdateReserveDto dto){

        Long reserve = reserveService.updateReserve(dto);

        return reserve != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "구장 수정 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);    }



    // 경기 삭제
    @DeleteMapping("reserves/{reserveId}/delete")
    public ResponseEntity deleteReserve(@PathVariable Long reserveId){

        reserveService.cancelReserve(reserveId);

        return reserveId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "경기예약 삭제 완료"), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);


    }




    // 원하는 날짜,스포츠 정렬해서 경기들 보여 주기
    @GetMapping("reserves/get/sports-date")
    public ResponseEntity showSports(@RequestParam(name = "sport") String sport,@RequestParam(name = "day") String day){
        LocalDate date = LocalDate.parse(day, DateTimeFormatter.ISO_DATE);
        Sport sport1 =Sport.valueOf(sport);

        List<Reserve> reserves = reserveService.sportDate(date, sport1);
        List<SimpleReserveDto> collect = reserves.stream().map(s -> new SimpleReserveDto(s)).collect(Collectors.toList());

        return collect != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "매칭 조회 완료", collect), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);

    }




    // 오늘 날짜 경기 전체 보여주기
    @GetMapping("reserves/get/today-sport")
    public ResponseEntity showTodaySports(@RequestParam(name = "today") String today){
        LocalDate date = LocalDate.parse(today, DateTimeFormatter.ISO_DATE);
        List<Reserve> reserve = reserveService.todayMatch(date);
        List<TodaySportsDto> collect = reserve.stream().map(r -> new TodaySportsDto(r)).collect(Collectors.toList());

        return collect != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "매칭 조회 완료", collect), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);

    }

    //경기 세부 정보 보여주기
    @GetMapping("reserves/{reserveId}/reserve-info")
    public ResponseEntity reserve1(@PathVariable("reserveId") Long reserveId) {

        ReserveDto reserve = reserveService.findOne(reserveId);// 경기 정보


        return reserve != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "경기 정보 보여주기 완료", reserve), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);

    }
    
    
}
