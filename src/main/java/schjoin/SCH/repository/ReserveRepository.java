package schjoin.SCH.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReserveRepository {

    private final EntityManager em;

    public void
    save(Reserve reserve){
        em.persist(reserve);
    }

    public Reserve findOne(Long id){
        return em.find(Reserve.class,id);
    }



    // 삭제
    public void delete(Reserve reserve){
        em.remove(reserve);
    }



    //Sport 와 날짜를 누르면  시간으로 경기 정렬해서 보여주기
    public List<Reserve> findBySportDate(LocalDate day,Sport sport){
        return em.createQuery("select r from Reserve r where r.reserveDate = :day and r.sport = :sport order by r.startT", Reserve.class)
                .setParameter("day",day).setParameter("sport",sport).getResultList();
    }

    //날짜로 조회하면 시간별로 정렬
    public List<Reserve> findByDate(String matchDate){
        return em.createQuery("select r from Reserve r where r.matchDate = :matchDate", Reserve.class)
                .setParameter("matchDate",matchDate)
                .getResultList();
    }


    // 오늘 날짜 모든 경기
    public List<Reserve> findByToday(LocalDate todayDate){

        return em.createQuery("select r from Reserve r where r.reserveDate = :todayDate order by r.startT",Reserve.class)
                .setParameter("todayDate",todayDate).getResultList();
    }


}