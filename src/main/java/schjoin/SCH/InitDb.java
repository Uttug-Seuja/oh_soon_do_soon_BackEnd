//package schjoin.SCH;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import schjoin.SCH.domain.*;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//@Component
//@RequiredArgsConstructor
//public class InitDb {
//
//    private final InitService initService;
//
//
//    @PostConstruct
//    public void init() {
//        initService.dbInit1();
//    }
//
//
//    @Component
//    @Transactional
//    @RequiredArgsConstructor
//    static class InitService {
//
//        private final EntityManager em;
//
//
//        public void dbInit1() {
//
//            User user = new User();
//            User user1 = new User();
//            User user2 = new User();
//            User user3 = new User();
//            User user4 = new User();
//            User user5 = new User();
//            User user6 = new User();
//            User user7 = new User();
//            User user8 = new User();
//            User user9 = new User();
//
//
//
//            user.setName("김찬우");
//            user1.setName("이훈일");
//            user2.setName("조준장");
//            user3.setName("이건희");
//            user4.setName("김세준");
//            user5.setName("김은지");
//            user6.setName("하재은");
//            user7.setName("이은혜");
//            user8.setName("홍지우");
//            user9.setName("최혜정");
//
//
//            user.setLoginId("qwer0");
//            user1.setLoginId("qwer1");
//            user2.setLoginId("qwer2");
//            user3.setLoginId("qwer3");
//            user4.setLoginId("qwer4");
//            user5.setLoginId("qwer5");
//            user6.setLoginId("qwer6");
//            user7.setLoginId("qwer7");
//            user8.setLoginId("qwer8");
//            user9.setLoginId("qwer9");
//
//
//            user.setPassword("0000");
//            user1.setPassword("1111");
//            user2.setPassword("2222");
//            user3.setPassword("3333");
//            user4.setPassword("4444");
//            user5.setPassword("5555");
//            user6.setPassword("6666");
//            user7.setPassword("7777");
//            user8.setPassword("8888");
//            user9.setPassword("9999");
//
//
//            user.setPhoneNum("01082527933");
//            user1.setPhoneNum("01049973751");
//            user2.setPhoneNum("01033032391");
//            user3.setPhoneNum("01022479135");
//            user4.setPhoneNum("01058774485");
//            user5.setPhoneNum("01058778285");
//            user6.setPhoneNum("01078945123");
//            user7.setPhoneNum("01045987154");
//            user8.setPhoneNum("01079541546");
//            user9.setPhoneNum("01048793546");
//
//            user.setSchoolNum("20181543");
//            user1.setSchoolNum("20181566");
//            user2.setSchoolNum("20181549");
//            user3.setSchoolNum("20181563");
//            user4.setSchoolNum("20181547");
//            user5.setSchoolNum("20211475");
//            user6.setSchoolNum("20211487");
//            user7.setSchoolNum("20211415");
//            user8.setSchoolNum("20227895");
//            user9.setSchoolNum("20224876");
//
//
//            user.setGender("MAN");
//            user1.setGender("MAN");
//            user2.setGender("MAN");
//            user3.setGender("MAN");
//            user4.setGender("WOMAN");
//            user5.setGender("WOMAN");
//            user6.setGender("WOMAN");
//            user7.setGender("WOMAN");
//            user8.setGender("WOMAN");
//            user9.setGender("MAN");
//
//            em.persist(user);
//            em.persist(user1);
//            em.persist(user2);
//            em.persist(user3);
//            em.persist(user4);
//            em.persist(user5);
//            em.persist(user6);
//            em.persist(user7);
//            em.persist(user8);
//            em.persist(user9);
//
//
//            Reserve reserve = new Reserve();
//            reserve.setUser(user);
//            reserve.setSport(Sport.SOCCER);
//            reserve.setReserveDate(LocalDate.of(2022, 10, 19));
//            reserve.setStartT( LocalTime.of(10, 30));
//            reserve.setEndT( LocalTime.of( 12, 30));
//            reserve.setNowReserveT(LocalDateTime.now());
//            reserve.setTitle("같이 재미있게 축구하실분들~");
//            reserve.setExplanation("안전하게 매너있게!");
//            reserve.setCurrentNum(1);
//            reserve.setRecruitmentNum(14);
//            reserve.setGender(Gender.MAN);
//            reserve.setPlace("대운동장");
//            reserve.setReserveStatus(ReserveStatus.POSSIBLE);
//
//            Reserve reserve1 = new Reserve();
//            reserve1.setUser(user1);
//            reserve1.setSport(Sport.SOCCER);
//            reserve1.setReserveDate(LocalDate.of(2022, 10, 19));
//            reserve1.setStartT( LocalTime.of(13, 00));
//            reserve1.setEndT( LocalTime.of( 15, 00));
//            reserve1.setNowReserveT(LocalDateTime.now());
//            reserve1.setTitle("못하시는 분들 모두 환영");
//            reserve1.setExplanation("축구가 좋아");
//            reserve1.setCurrentNum(1);
//            reserve1.setRecruitmentNum(12);
//            reserve1.setGender(Gender.MAN);
//            reserve1.setPlace("대운동장");
//            reserve1.setReserveStatus(ReserveStatus.POSSIBLE);
//
//            Reserve reserve2 = new Reserve();
//            reserve2.setUser(user2);
//            reserve2.setSport(Sport.SOCCER);
//            reserve2.setReserveDate(LocalDate.of(2022, 10, 19));
//            reserve2.setStartT( LocalTime.of(15, 00));
//            reserve2.setEndT( LocalTime.of( 17, 00));
//            reserve2.setNowReserveT(LocalDateTime.now());
//            reserve2.setTitle("아무나 오세요");
//            reserve2.setExplanation("안전하게 합시다");
//            reserve2.setCurrentNum(1);
//            reserve2.setRecruitmentNum(22);
//            reserve2.setGender(Gender.ALL);
//            reserve2.setPlace("대운동장");
//            reserve2.setReserveStatus(ReserveStatus.POSSIBLE);
//
//            Reserve reserve3 = new Reserve();
//            reserve3.setUser(user4);
//            reserve3.setSport(Sport.SOCCER);
//            reserve3.setReserveDate(LocalDate.of(2022, 10, 19));
//            reserve3.setStartT( LocalTime.of(18, 00));
//            reserve3.setEndT( LocalTime.of( 19, 30));
//            reserve3.setNowReserveT(LocalDateTime.now());
//            reserve3.setTitle("축구 좋아하는 여성분들");
//            reserve3.setExplanation("안전하게 해봐요!");
//            reserve3.setCurrentNum(1);
//            reserve3.setRecruitmentNum(12);
//            reserve3.setGender(Gender.WOMAN);
//            reserve3.setPlace("대운동장");
//            reserve3.setReserveStatus(ReserveStatus.POSSIBLE);
//
////            Reserve reserve4 = new Reserve();
////            reserve4.setUser(user3);
////            reserve4.setSport(Sport.SOCCER);
////            reserve4.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve4.setStartT( LocalTime.of(9, 30));
////            reserve4.setEndT( LocalTime.of( 11, 30));
////            reserve4.setNowReserveT(LocalDateTime.now());
////            reserve4.setTitle("농구");
////            reserve4.setExplanation("농구");
////            reserve4.setCurrentNum(3);
////            reserve4.setRecruitmentNum(12);
////            reserve4.setGender(Gender.ALL);
////            reserve4.setPlace("대운동장");
////            reserve4.setReserveStatus(ReserveStatus.POSSIBLE);
////
////            Reserve reserve5 = new Reserve();
////            reserve5.setUser(user1);
////            reserve5.setSport(Sport.BASKETBALL);
////            reserve5.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve5.setStartT( LocalTime.of(9, 30));
////            reserve5.setEndT( LocalTime.of( 11, 30));
////            reserve5.setNowReserveT(LocalDateTime.now());
////            reserve5.setTitle("농구");
////            reserve5.setExplanation("농구");
////            reserve5.setCurrentNum(3);
////            reserve5.setRecruitmentNum(12);
////            reserve5.setGender(Gender.ALL);
////            reserve5.setPlace("대운동장");
////            reserve5.setReserveStatus(ReserveStatus.POSSIBLE);
////
////            Reserve reserve6 = new Reserve();
////            reserve6.setUser(user1);
////            reserve6.setSport(Sport.BASKETBALL);
////            reserve6.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve6.setStartT( LocalTime.of(9, 30));
////            reserve6.setEndT( LocalTime.of( 11, 30));
////            reserve6.setNowReserveT(LocalDateTime.now());
////            reserve6.setTitle("농구");
////            reserve6.setExplanation("농구");
////            reserve6.setCurrentNum(3);
////            reserve6.setRecruitmentNum(12);
////            reserve6.setGender(Gender.ALL);
////            reserve6.setPlace("대운동장");
////            reserve6.setReserveStatus(ReserveStatus.POSSIBLE);
////
////
////
////            Reserve reserve7 = new Reserve();
////            reserve7.setUser(user1);
////            reserve7.setSport(Sport.BASKETBALL);
////            reserve7.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve7.setStartT( LocalTime.of(9, 30));
////            reserve7.setEndT( LocalTime.of( 11, 30));
////            reserve7.setNowReserveT(LocalDateTime.now());
////            reserve7.setTitle("농구");
////            reserve7.setExplanation("농구");
////            reserve7.setCurrentNum(3);
////            reserve7.setRecruitmentNum(12);
////            reserve7.setGender(Gender.ALL);
////            reserve7.setPlace("대운동장");
////            reserve7.setReserveStatus(ReserveStatus.POSSIBLE);
////
////            Reserve reserve8 = new Reserve();
////            reserve8.setUser(user1);
////            reserve8.setSport(Sport.BASKETBALL);
////            reserve8.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve8.setStartT( LocalTime.of(9, 30));
////            reserve8.setEndT( LocalTime.of( 11, 30));
////            reserve8.setNowReserveT(LocalDateTime.now());
////            reserve8.setTitle("농구");
////            reserve8.setExplanation("농구");
////            reserve8.setCurrentNum(3);
////            reserve8.setRecruitmentNum(12);
////            reserve8.setGender(Gender.ALL);
////            reserve8.setPlace("대운동장");
////            reserve8.setReserveStatus(ReserveStatus.POSSIBLE);
////
////            Reserve reserve9 = new Reserve();
////            reserve9.setUser(user1);
////            reserve9.setSport(Sport.BASKETBALL);
////            reserve9.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve9.setStartT( LocalTime.of(9, 30));
////            reserve9.setEndT( LocalTime.of( 11, 30));
////            reserve9.setNowReserveT(LocalDateTime.now());
////            reserve9.setTitle("농구");
////            reserve9.setExplanation("농구");
////            reserve9.setCurrentNum(3);
////            reserve9.setRecruitmentNum(12);
////            reserve9.setGender(Gender.ALL);
////            reserve9.setPlace("대운동장");
////            reserve9.setReserveStatus(ReserveStatus.POSSIBLE);
////
////            Reserve reserve10 = new Reserve();
////            reserve10.setUser(user1);
////            reserve10.setSport(Sport.BASKETBALL);
////            reserve10.setReserveDate(LocalDate.of(2000, 1, 3));
////            reserve10.setStartT( LocalTime.of(9, 30));
////            reserve10.setEndT( LocalTime.of( 11, 30));
////            reserve10.setNowReserveT(LocalDateTime.now());
////            reserve10.setTitle("농구");
////            reserve10.setExplanation("농구");
////            reserve10.setCurrentNum(3);
////            reserve10.setRecruitmentNum(12);
////            reserve10.setGender(Gender.ALL);
////            reserve10.setPlace("대운동장");
////            reserve10.setReserveStatus(ReserveStatus.POSSIBLE);
//
//            em.persist(reserve);
//            em.persist(reserve1);
//            em.persist(reserve2);
//            em.persist(reserve3);
//
////            Participation participation = new Participation();
////            participation.setReserve(reserve);
////            participation.setUser(user2);
////
////            Participation participation1 = new Participation();
////            participation1.setReserve(reserve);
////            participation1.setUser(user3);
////
////            em.persist(participation);
////            em.persist(participation1);
//
//
//
//
//        }
//
//
//
//    }
//
//
//}
//
//
//
//
//
//
//
//
