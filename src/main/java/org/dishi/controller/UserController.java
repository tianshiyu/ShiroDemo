package org.dishi.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.dishi.common.response.ServerResponse;
import org.dishi.domain.User;
import org.dishi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("user")
@Api("用户相关接口")
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    @ApiOperation("登录接口")
    public ServerResponse<String> login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("hello")
    @ApiOperation("登录测试接口")
    public ServerResponse<String> hello(){
        return ServerResponse.createBySuccessMessage("hello");
    }
}
