package co.kr.metacoding.backendtest.users;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UsersRepository {
    private final EntityManager em;

    public Users save(Users users) {
        em.persist(users);
        return users; // 영속객체
    }

    public Optional<Users> findByName(String name) {
        try {
            Users usersPS = em.createQuery("select u from Users u where u.name = :name", Users.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.of(usersPS);
        } catch (Exception e) {
            return Optional.ofNullable(null);
        }

    }

}
