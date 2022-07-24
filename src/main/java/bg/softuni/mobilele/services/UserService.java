package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.dto.user.UserRegisterDTO;
import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.models.mapper.UserMapper;
import bg.softuni.mobilele.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private UserDetailsService userDetailsService;
    private EmailService emailService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserDetailsService userDetailsService, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
        this.emailService = emailService;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO, Locale preferredLocale) {
        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);
        emailService.sendRegistrationEmail(newUser.getEmail(), newUser.getFirstName() + " " + newUser.getLastName(), preferredLocale);
    }

    private void login(UserEntity userEntity) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
