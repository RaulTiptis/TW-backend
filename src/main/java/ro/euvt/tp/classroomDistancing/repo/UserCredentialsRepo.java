package ro.euvt.tp.classroomDistancing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.euvt.tp.classroomDistancing.model.UserCredentials;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserCredentialsRepo extends JpaRepository<UserCredentials, Integer> {
    Optional<UserCredentials> findByEmail(String email);
}
