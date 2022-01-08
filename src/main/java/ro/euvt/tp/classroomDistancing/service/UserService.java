package ro.euvt.tp.classroomDistancing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.exception.UserNotFoundException;
import ro.euvt.tp.classroomDistancing.model.User;
import ro.euvt.tp.classroomDistancing.repo.UserRepo;


import java.util.List;

@Service
public class UserService implements UserDetailsService {

  private final UserRepo userRepo;

  @Autowired
  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public User addUser(User user) {
    return userRepo.save(user);
  }

  public List<User> findAllUsers() {
    return userRepo.findAll();
  }

  public User updateUser(User user){
    return userRepo.save(user);
  }

  public User findUserById(Integer id){
    return userRepo.findUserById(id)
      .orElseThrow(() -> new UserNotFoundException("User with id :" + id + " was not found"));
  }

  public void deleteUser(Integer id){
    userRepo.deleteUserById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String email)
          throws UsernameNotFoundException {
    return userRepo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
  }

  public String signUpUser(UserService userService){
    return "xd";
  }
}
