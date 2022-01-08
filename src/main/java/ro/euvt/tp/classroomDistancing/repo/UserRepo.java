package ro.euvt.tp.classroomDistancing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.euvt.tp.classroomDistancing.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

  void deleteUserById(Integer id);

  Optional<User> findUserById(Integer id);

  Optional<User> findByEmail(String email);
}
