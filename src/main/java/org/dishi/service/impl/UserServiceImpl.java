package org.dishi.service.impl;

import lombok.AllArgsConstructor;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.dishi.common.response.ServerResponse;
import org.dishi.domain.User;
import org.dishi.service.UserService;
import org.dishi.utils.JwtUtil;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final JwtUtil jwtUtil;

    @Override
    public User findByName(String username) {
        User user = new User();
        user.setUsername("qqq");
        user.setPassword("www");
        return user;
    }

    @Override
    public ServerResponse<String> login(User user) {
        User user1 = findByName(user.getUsername());
        //账号不存在、密码错误
        if (user1 == null || !user.getPassword().equals(user1.getPassword())) {
            return ServerResponse.createByErrorMessage("账号或密码不正确");
        }
        return ServerResponse.createBySuccess(jwtUtil.generateToken(user1));
    }
}
