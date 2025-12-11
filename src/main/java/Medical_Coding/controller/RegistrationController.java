package Medical_Coding.controller;

import Medical_Coding.model.User;
import Medical_Coding.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

    private final UserService userService;

    // Constructor injection (no Lombok)
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
