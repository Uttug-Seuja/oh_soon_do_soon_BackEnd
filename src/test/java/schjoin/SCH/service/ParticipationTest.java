//package schjoin.SCH.service;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import schjoin.SCH.domain.User;
//import schjoin.SCH.domain.Reserve;
//import schjoin.SCH.domain.Sport;
//import schjoin.SCH.repository.ReserveRepository;
//
//import javax.persistence.EntityManager;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Transactional
//@Rollback(value = false)
//public class ParticipationTest {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired ParticipationService participationService;
//
//    @Autowired ReserveService reserveService;
//
//    @Autowired EntityManager em;
//
//    @Autowired
//    ReserveRepository reserveRepository;
//
//
//    @Test
//    public void 경기생성_참여() throws Exception{
//
//    //given
//
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        User user6 = new User();
//        User user7 = new User();
//
//
//        user.setName("김찬우");
//        user1.setName("이훈일");
//        user2.setName("이건희");
//        user3.setName("조준장");
//        user4.setName("왕세준");
//        user5.setName("이기범");
//        user6.setName("하재은");
//        user7.setName("은혜");
//
//
//        user.setPhoneNum("01082527933");
//        user1.setPhoneNum("01082567865");
//        user2.setPhoneNum("0108252678");
//        user3.setPhoneNum("01025279678");
//        user4.setPhoneNum("0108259787");
//        user5.setPhoneNum("01082597871");
//        user6.setPhoneNum("01082597873");
//        user7.setPhoneNum("01082597875");
//
//        user.setSchoolNum("12");
//        user1.setSchoolNum("123");
//        user2.setSchoolNum("1234");
//        user3.setSchoolNum("123456");
//        user4.setSchoolNum("1212345");
//        user5.setSchoolNum("11235");
//        user6.setSchoolNum("54664");
//        user7.setSchoolNum("5657");
//
//        em.persist(user);
//        em.persist(user1);
//        em.persist(user2);
//        em.persist(user3);
//        em.persist(user4);
//        em.persist(user5);
//        em.persist(user6);
//        em.persist(user7);
//
//
//        Long reserve = reserveService.reserve(user.getId(), "축구", "나와",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        participationService.participation(user2.getId(),reserve);
//        participationService.participation(user3.getId(),reserve);
//        participationService.participation(user4.getId(),reserve);
//        participationService.participation(user5.getId(),reserve);
//
//        em.flush();
//        em.clear();
//
//
//
//
//
//    }
//
//    @Test
//    public void 참여_취소() throws Exception{
//
//        //given
//
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        User user6 = new User();
//        User user7 = new User();
//
//
//        user.setName("김찬우");
//        user1.setName("이훈일");
//        user2.setName("이건희");
//        user3.setName("조준장");
//        user4.setName("왕세준");
//        user5.setName("이기범");
//        user6.setName("하재은");
//        user7.setName("은혜");
//
//
//        user.setPhoneNum("01082527933");
//        user1.setPhoneNum("01082567865");
//        user2.setPhoneNum("0108252678");
//        user3.setPhoneNum("01025279678");
//        user4.setPhoneNum("0108259787");
//        user5.setPhoneNum("01082597871");
//        user6.setPhoneNum("01082597873");
//        user7.setPhoneNum("01082597875");
//
//        user.setSchoolNum("12");
//        user1.setSchoolNum("123");
//        user2.setSchoolNum("1234");
//        user3.setSchoolNum("123456");
//        user4.setSchoolNum("1212345");
//        user5.setSchoolNum("11235");
//        user6.setSchoolNum("54664");
//        user7.setSchoolNum("5657");
//
//        em.persist(user);
//        em.persist(user1);
//        em.persist(user2);
//        em.persist(user3);
//        em.persist(user4);
//        em.persist(user5);
//        em.persist(user6);
//        em.persist(user7);
//
//
//        Long reserve = reserveService.reserve(user.getId(), "축구", "나와",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        Long participation = participationService.participation(user2.getId(), reserve);
//        Long participation1 = participationService.participation(user3.getId(), reserve);
//        Long participation2 = participationService.participation(user4.getId(), reserve);
//        Long participation3 = participationService.participation(user5.getId(), reserve);
//
//
//
//        participationService.cancelParticipation(participation1);
//        participationService.cancelParticipation(participation2);
//
//
//        em.flush();
//        em.clear();
//
//    }
//
//    @Test
//    public void 예약_취소() throws Exception{
//
//
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        User user6 = new User();
//        User user7 = new User();
//
//
//        user.setName("김찬우");
//        user1.setName("이훈일");
//        user2.setName("이건희");
//        user3.setName("조준장");
//        user4.setName("왕세준");
//        user5.setName("이기범");
//        user6.setName("하재은");
//        user7.setName("이종환");
//
//
//        user.setPhoneNum("01082527933");
//        user1.setPhoneNum("01082567865");
//        user2.setPhoneNum("0108252678");
//        user3.setPhoneNum("01025279678");
//        user4.setPhoneNum("0108259787");
//        user5.setPhoneNum("01082597871");
//        user6.setPhoneNum("01082597873");
//        user7.setPhoneNum("01082597875");
//
//        user.setSchoolNum("12");
//        user1.setSchoolNum("123");
//        user2.setSchoolNum("1234");
//        user3.setSchoolNum("123456");
//        user4.setSchoolNum("1212345");
//        user5.setSchoolNum("11235");
//        user6.setSchoolNum("54664");
//        user7.setSchoolNum("5657");
//
//        em.persist(user);
//        em.persist(user1);
//        em.persist(user2);
//        em.persist(user3);
//        em.persist(user4);
//        em.persist(user5);
//        em.persist(user6);
//        em.persist(user7);
//
//
//        // 김찬우의 축구 방 만들기
//        Long reserve = reserveService.reserve(user.getId(), "축구", "나와",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        // 이종환 농구 방 만듫기
//        Long reserve1 = reserveService.reserve(user7.getId(), "농구", "나와",8,Sport.BASKETBALL,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        //축구 참가
//        participationService.participation(user2.getId(),reserve);
//        participationService.participation(user3.getId(),reserve);
//        participationService.participation(user4.getId(),reserve);
//
//
//        // 농구 참가
//        participationService.participation(user5.getId(),reserve1);
//        participationService.participation(user6.getId(),reserve1);
//
//
//        // 축구방 제거
//        reserveService.cancelReserve(reserve);
//
//        //농구 방 제거
//        reserveService.cancelReserve(reserve1);
//
//
//    }
//
////    @Test
////    public void 예약업데이트() throws Exception{
////
////        Member member = new Member();
////        Member member1 = new Member();
////        Member member2 = new Member();
////        Member member3 = new Member();
////        Member member4 = new Member();
////        Member member5 = new Member();
////        Member member6 = new Member();
////        Member member7 = new Member();
////
////
////        member.setName("김찬우");
////        member1.setName("이훈일");
////        member2.setName("이건희");
////        member3.setName("조준장");
////        member4.setName("왕세준");
////        member5.setName("이기범");
////        member6.setName("하재은");
////        member7.setName("은혜");
////
////
////        member.setPhoneNum("01082527933");
////        member1.setPhoneNum("01082567865");
////        member2.setPhoneNum("0108252678");
////        member3.setPhoneNum("01025279678");
////        member4.setPhoneNum("0108259787");
////        member5.setPhoneNum("01082597871");
////        member6.setPhoneNum("01082597873");
////        member7.setPhoneNum("01082597875");
////
////        member.setSchoolNum("12");
////        member1.setSchoolNum("123");
////        member2.setSchoolNum("1234");
////        member3.setSchoolNum("123456");
////        member4.setSchoolNum("1212345");
////        member5.setSchoolNum("11235");
////        member6.setSchoolNum("54664");
////        member7.setSchoolNum("5657");
////
////        em.persist(member);
////        em.persist(member1);
////        em.persist(member2);
////        em.persist(member3);
////        em.persist(member4);
////        em.persist(member5);
////        em.persist(member6);
////        em.persist(member7);
////
////
////        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
////                LocalTime.of(20,30),
////                LocalTime.of(22, 30),
////                LocalDate.of(2000, 1, 3));
////
////
////        Long participation = participationService.participation(member2.getId(), reserve);
////        Long participation1 = participationService.participation(member3.getId(), reserve);
////        Long participation2 = participationService.participation(member4.getId(), reserve);
////        Long participation3 = participationService.participation(member5.getId(), reserve);
////
////
////        UpdateReserveDto updateReserveDto = new UpdateReserveDto(Sport.SOCCER, LocalDate.of(2000, 1, 3),
////                LocalTime.of(20,30),
////                LocalTime.of(22, 30),
////                "ㅅㅂ","하기싫다");
////
////        reserveService.updateReserve(reserve,updateReserveDto);
////
////
////
////    }
//
//    @Test
//    public void 오늘_운동예약_보여주기 () throws Exception{
//
//        //given
//
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        User user6 = new User();
//        User user7 = new User();
//
//
//        user.setName("김찬우");
//        user1.setName("이훈일");
//        user2.setName("이건희");
//        user3.setName("조준장");
//        user4.setName("왕세준");
//        user5.setName("이기범");
//        user6.setName("하재은");
//        user7.setName("이종환");
//
//
//        user.setPhoneNum("01082527933");
//        user1.setPhoneNum("01082567865");
//        user2.setPhoneNum("0108252678");
//        user3.setPhoneNum("01025279678");
//        user4.setPhoneNum("0108259787");
//        user5.setPhoneNum("01082597871");
//        user6.setPhoneNum("01082597873");
//        user7.setPhoneNum("01082597875");
//
//        user.setSchoolNum("12");
//        user1.setSchoolNum("123");
//        user2.setSchoolNum("1234");
//        user3.setSchoolNum("123456");
//        user4.setSchoolNum("1212345");
//        user5.setSchoolNum("11235");
//        user6.setSchoolNum("54664");
//        user7.setSchoolNum("5657");
//
//        em.persist(user);
//        em.persist(user1);
//        em.persist(user2);
//        em.persist(user3);
//        em.persist(user4);
//        em.persist(user5);
//        em.persist(user6);
//        em.persist(user7);
//
//
//        Long reserve = reserveService.reserve(user.getId(), "축구", "나와",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//        Long reserve1 = reserveService.reserve(user1.getId(), "농구", "나와1",12,Sport.BASKETBALL,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 4));
//
//        Long reserve2 = reserveService.reserve(user2.getId(), "농구", "나와2",12,Sport.BASKETBALL,                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 5));
//
//        Long reserve3 = reserveService.reserve(user1.getId(), "축구", "나와3",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        participationService.participation(user3.getId(),reserve);
//        participationService.participation(user6.getId(),reserve1);
//        participationService.participation(user4.getId(),reserve2);
//        participationService.participation(user5.getId(),reserve3);
//
//
//        List<Reserve> reserves = reserveService.todayMatch(LocalDate.of(2000, 1, 3));
//
//        System.out.println(" ======================================================================= " );
//
//
//
//        for (Reserve result : reserves) {
//            System.out.println(" ======================================================================= " );
//            System.out.println("result = " + result.getTitle());
//        }
//
//        String day = "2000-01-03";
//        String sport = "SOCCER";
//        LocalDate date = LocalDate.parse(day, DateTimeFormatter.ISO_DATE);
//        Sport sport1 =Sport.valueOf(sport);
//
//        System.out.println("sport1 = " + sport1);
//        System.out.println("date = " + date);
//
//        System.out.println("sport1.getClass() = " + sport1.getClass().getName());
//        System.out.println("date.getClass().getName() = " + date.getClass().getName());
//
//
//    }
//
//    @Test
//    public void 날짜_스포츠_입력하면_경기보여주기() throws Exception{
//
//        //given
//
//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        User user4 = new User();
//        User user5 = new User();
//        User user6 = new User();
//        User user7 = new User();
//
//
//        user.setName("김찬우");
//        user1.setName("이훈일");
//        user2.setName("이건희");
//        user3.setName("조준장");
//        user4.setName("왕세준");
//        user5.setName("이기범");
//        user6.setName("하재은");
//        user7.setName("이종환");
//
//
//        user.setPhoneNum("01082527933");
//        user1.setPhoneNum("01082567865");
//        user2.setPhoneNum("0108252678");
//        user3.setPhoneNum("01025279678");
//        user4.setPhoneNum("0108259787");
//        user5.setPhoneNum("01082597871");
//        user6.setPhoneNum("01082597873");
//        user7.setPhoneNum("01082597875");
//
//        user.setSchoolNum("12");
//        user1.setSchoolNum("123");
//        user2.setSchoolNum("1234");
//        user3.setSchoolNum("123456");
//        user4.setSchoolNum("1212345");
//        user5.setSchoolNum("11235");
//        user6.setSchoolNum("54664");
//        user7.setSchoolNum("5657");
//
//        em.persist(user);
//        em.persist(user1);
//        em.persist(user2);
//        em.persist(user3);
//        em.persist(user4);
//        em.persist(user5);
//        em.persist(user6);
//        em.persist(user7);
//
//
//        Long reserve = reserveService.reserve(user.getId(), "1", "나와",12,Sport.SOCCER,
//                LocalTime.of(22,30),
//                LocalTime.of(20, 30),
//                LocalDate.of(2000, 1, 3));
//
//        Long reserve1 = reserveService.reserve(user1.getId(), "2", "나와1",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(18, 30),
//                LocalDate.of(2000, 1, 3));
//
//        Long reserve2 = reserveService.reserve(user2.getId(), "3", "나와2",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(18, 29),
//                LocalDate.of(2000, 1, 5));
//
//        Long reserve3 = reserveService.reserve(user1.getId(), "4", "나와3",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(18, 29),
//                LocalDate.of(2000, 1, 3));
//
//
//        participationService.participation(user3.getId(),reserve);
//        participationService.participation(user6.getId(),reserve1);
//        participationService.participation(user4.getId(),reserve2);
//        participationService.participation(user5.getId(),reserve3);
//
//
//        List<Reserve> reserves = reserveService.sportDate(LocalDate.of(2000, 1, 3), Sport.SOCCER);
//
//        for (Reserve result : reserves) {
//            System.out.println("==================================== ");
//            System.out.println("result = " + result.getTitle());
//
//        }
//
//
//    }
//
//
//
//}