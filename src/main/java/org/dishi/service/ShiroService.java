package org.dishi.service;

import org.dishi.domain.User;

public interface ShiroService {
    boolean validateToken(String token);
    User getByToken(String token);
}
