package Medical_Coding.controller;

import Medical_Coding.model.User;
import Medical_Coding.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final UserService userService;

    // Constructor injection
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // ================= REGISTER API =================
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // ================= LOGIN API =================
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {

        User loggedInUser = userService.loginUser(
                user.getEmail(),
                user.getPassword()
        );

//        return ResponseEntity.ok(loggedInUser);
        loggedInUser.setPassword(null);
        return ResponseEntity.ok(loggedInUser);

    }


//       for all user

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        // hide passwords
        users.forEach(user -> user.setPassword(null));

        return ResponseEntity.ok(users);
    }


    // ================= GET USER BY ID =================
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
