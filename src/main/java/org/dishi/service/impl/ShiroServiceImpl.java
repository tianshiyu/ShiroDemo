package org.dishi.service.impl;

import lombok.AllArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.dishi.domain.User;
import org.dishi.service.ShiroService;
import org.dishi.service.UserService;
import org.dishi.utils.JwtUtil;
import org.dishi.utils.ShiroUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class ShiroServiceImpl implements ShiroService {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Override
    public boolean validateToken(String token) {
        String username = jwtUtil.getUserNameFromToken(token);
        User user = userService.findByName(username);
        if(user==null){
            return false;
        }
        return jwtUtil.validateToken(token, user);
    }

    @Override
    public User getByToken(String token) {
        String username = jwtUtil.getUserNameFromToken(token);
        return userService.findByName(username);
    }

    @Override
    public Set<String> getUserPermissions(User user) {
        Set<String> s = new HashSet<>();
        s.add("admin");
        return s;
    }
}
