package ro.euvt.tp.classroomDistancing.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.euvt.tp.classroomDistancing.repo.UserCredentialsRepo;

@Service
@AllArgsConstructor
public class UserCredentialsService implements UserDetailsService {

    private final UserCredentialsRepo userCredentialsRepo;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userCredentialsRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }
}
