package me.dovias.vtech.java.ld1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import me.dovias.vtech.java.ld1.model.user.User;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

@NullMarked
public class UserRepository {
    private final EntityManager manager;

    public UserRepository(EntityManager manager) {
        this.manager = manager;
    }

    public @Nullable User findById(int id) {
        return this.manager.find(User.class, id);
    }

    public @Nullable User findByUsername(String username) {
        CriteriaBuilder builder = this.manager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        TypedQuery<User> query = this.manager.createQuery(
            criteria.select(root)
                .where(
                    builder.equal(
                        root.get("credentials").get("username"),
                        username
                    )
                )
        );

        List<User> results = query.getResultList();
        return results.isEmpty() ? null : results.getFirst();
    }

    public boolean existsById(int id) {
        return this.findById(id) != null;
    }

    public User save(User user) {
        this.manager.getTransaction().begin();
        if (!this.manager.contains(user)) {
            user = this.manager.merge(user);
        }
        this.manager.getTransaction().commit();
        return user;
    }

}
