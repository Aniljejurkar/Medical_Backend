package Medical_Coding.Medical.service;

import Medical_Coding.Medical.model.User;
import Medical_Coding.Medical.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
