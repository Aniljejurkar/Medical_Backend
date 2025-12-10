package Medical_Coding.Medical.controller;

import Medical_Coding.Medical.model.User;
import Medical_Coding.Medical.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
