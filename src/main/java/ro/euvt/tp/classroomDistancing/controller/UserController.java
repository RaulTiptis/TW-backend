package ro.euvt.tp.classroomDistancing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.euvt.tp.classroomDistancing.model.User;
import ro.euvt.tp.classroomDistancing.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers(){
    List<User> users = userService.findAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
    User user = userService.findUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }


  @PostMapping("/add")
  public ResponseEntity<User> addUser(@RequestBody User user){
    User newUser = userService.addUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<User> updateUser(@RequestBody User user){
    User updateUser = userService.updateUser(user);
    return new ResponseEntity<>(updateUser, HttpStatus.OK);
  }

  @Transactional
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
