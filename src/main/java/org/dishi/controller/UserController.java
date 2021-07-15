package org.dishi.controller;


import lombok.AllArgsConstructor;
import org.dishi.common.response.ServerResponse;
import org.dishi.domain.User;
import org.dishi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    public ServerResponse<String> login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("hello")
    public ServerResponse<String> hello(){
        return ServerResponse.createBySuccessMessage("hello");
    }
}
