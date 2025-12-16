package Medical_Coding.service;

import Medical_Coding.model.User;
import Medical_Coding.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Manual constructor (since no Lombok)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================= REGISTER =================
//    public User registerUser(User user) {
//        return userRepository.save(user);
//    }



    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }




    // ================= LOGIN =================
//    public User loginUser(String email, String password) {
//
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!user.getPassword().equals(password)) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        return user;
//    }


    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        user.setPassword(null); // hide password
        return user;
    }

}
