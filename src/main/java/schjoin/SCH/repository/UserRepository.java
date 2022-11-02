package schjoin.SCH.repository;

import org.springframework.stereotype.Repository;
import schjoin.SCH.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }

    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User findByLoginId(String LoginId,String password){
        try{
            return em.createQuery("select u from User u where u.loginId = :loginId and u.password = :password", User.class)
                    .setParameter("loginId", LoginId).setParameter("password", password)
                    .getSingleResult();
        } catch(Exception e){
            return null;
        }
    }

}