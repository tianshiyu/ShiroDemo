package org.dishi.service;

import org.dishi.common.response.ServerResponse;
import org.dishi.domain.User;

public interface UserService {
    User findByName(String username);
    ServerResponse<String> login(User user);
}
