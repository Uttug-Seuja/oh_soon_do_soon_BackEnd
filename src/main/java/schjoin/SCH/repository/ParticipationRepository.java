package schjoin.SCH.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import schjoin.SCH.domain.Participation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipationRepository {

    private final EntityManager em;

    public void save(Participation participation){
        em.persist(participation);
    }

    public Participation findOne(Long id){
        return em.find(Participation.class,id);
    }



    public void delete(Long id){
         em.createQuery("delete from Participation p where p.id = :id ").setParameter("id",id).executeUpdate();
    }

    public List<Participation> findReserveInfo(Long id){
        return em.createQuery("select distinct p from Participation p"+
                " left join fetch p.user u"+
                " left join fetch p.reserve r"+
                " where r.id = :id ",Participation.class).setParameter("id",id).getResultList();
    }



    public Participation findParticipation(Long reserveId,Long userId){

        Participation result = em.createQuery("select p from Participation p"+
                " left join fetch p.user u"+
                " left join fetch p.reserve r"+
                " where r.id = :reserveId and u.id = :userId ", Participation.class).setParameter("reserveId", reserveId).setParameter("userId", userId).getSingleResult();

        return result;
    }


}

