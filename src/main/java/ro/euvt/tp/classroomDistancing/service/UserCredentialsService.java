package ro.euvt.tp.classroomDistancing.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.model.UserCredentials;
import ro.euvt.tp.classroomDistancing.registration.token.ConfirmationToken;
import ro.euvt.tp.classroomDistancing.registration.token.ConfirmationTokenService;
import ro.euvt.tp.classroomDistancing.repo.UserCredentialsRepo;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserCredentialsService implements UserDetailsService {

    private final UserCredentialsRepo userCredentialsRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userCredentialsRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }

    public String signUpUser(UserCredentials userCredentials) {
        boolean userExists = userCredentialsRepo.findByEmail(userCredentials.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("Email already exists");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(userCredentials.getPassword());
        userCredentials.setPassword(encodedPassword);

        userCredentialsRepo.save(userCredentials);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), userCredentials
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public int enableUserCredentials(String email) {
        return userCredentialsRepo.enableUserCredentials(email);
    }
}
