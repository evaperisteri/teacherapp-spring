package gr.aueb.cf.teacherApp.repository;

import gr.aueb.cf.teacherApp.core.enums.Role;
import gr.aueb.cf.teacherApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
    Long countByRole(Role role);
}
