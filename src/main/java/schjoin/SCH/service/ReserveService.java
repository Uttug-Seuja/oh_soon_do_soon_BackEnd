package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.User;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.dto.CreateReserveDto;
import schjoin.SCH.dto.ReserveDto;
import schjoin.SCH.dto.UpdateReserveDto;
import schjoin.SCH.repository.UserRepository;
import schjoin.SCH.repository.ParticipationRepository;
import schjoin.SCH.repository.ReserveRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReserveService {

    private final UserRepository userRepository;
    private final ReserveRepository reserveRepository;

    private final ParticipationRepository participationRepository;


    //구장 생성
    @Transactional
    public Long reserve(CreateReserveDto createReserveDto){

        //엔티티 조회
        User user = userRepository.findOne(createReserveDto.getUserId());

        // 경기 생성
        Reserve reserve = Reserve.createReserve(user, createReserveDto.getTitle(),
                createReserveDto.getExplanation(),
                createReserveDto.getRecruitmentNum(),
                createReserveDto.getSport(),
                createReserveDto.getEndT(),
                createReserveDto.getStartT(),
                createReserveDto.getReserveDate(),
                createReserveDto.getPlace(),
                createReserveDto.getGender());

        //경기 저장
        reserveRepository.save(reserve);
        return reserve.getId();
    }


    // 구장 삭제
    @Transactional
    public void cancelReserve(Long reserveId){

        // 경기 엔티티 조회
        Reserve reserve = reserveRepository.findOne(reserveId);


        // or
        reserveRepository.delete(reserve);


        // 경기 예약 취소

    }


    // 구장 업데이트
   @Transactional
    public Long updateReserve(UpdateReserveDto reserveDto){

        Reserve reserve = reserveRepository.findOne(reserveDto.getReserveId());

        reserve.setReserveDate(reserveDto.getReserveDate());
        reserve.setEndT(reserveDto.getEndT());
        reserve.setStartT(reserveDto.getStartT());

        reserve.setSport(reserveDto.getSport());

        reserve.setTitle(reserveDto.getTitle());
        reserve.setExplanation(reserveDto.getExplanation());
        reserve.setPlace(reserveDto.getPlace());

       return reserve.getId();
   }


   // 오늘 날짜 모든 경기 보여주기

    @Transactional
    public List<Reserve> todayMatch(LocalDate todayDate){
        List<Reserve> byToday = reserveRepository.findByToday(todayDate);
        for (Reserve reserve : byToday) {
            reserve.roomStatus();
        }
        return  byToday;
    }




    // 원하는 날짜,스포츠 정렬해서 경기들 보여 주기
    @Transactional
    public List<Reserve> sportDate(LocalDate day ,Sport sport){
        List<Reserve> bySportDate = reserveRepository.findBySportDate(day, sport);
        for(Reserve reserve : bySportDate){
            reserve.roomStatus();
        }
        return bySportDate;

    }


    //구장에 관련된 정보 보여주기
    @Transactional
    public ReserveDto findOne(Long reserveId){

        Reserve reserve = reserveRepository.findOne(reserveId);
        ReserveDto reserveDto = new ReserveDto(reserve.getUser().getName(),reserve.getUser().getSchoolNum(),reserve.getUser().getId(),reserve.getId(),reserve.getSport(),reserve.getReserveDate(),
                reserve.getStartT(),reserve.getEndT(),reserve.getTitle(),reserve.getExplanation(),reserve.getCurrentNum(),reserve.getRecruitmentNum(),
                reserve.getPlace(),reserve.getGender(),reserve.getReserveStatus());

        return reserveDto;

    }



}