package org.dishi.service;

import org.dishi.domain.User;

public interface UserService {
    User findByName(String username);
}
