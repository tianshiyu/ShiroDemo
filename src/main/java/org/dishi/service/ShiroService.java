package org.dishi.service;

import org.dishi.domain.User;

import java.util.Set;

public interface ShiroService {
    boolean validateToken(String token);
    User getByToken(String token);
    Set<String> getUserPermissions(User user);
}
