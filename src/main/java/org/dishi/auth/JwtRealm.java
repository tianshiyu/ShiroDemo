package org.dishi.auth;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.dishi.domain.User;
import org.dishi.service.ShiroService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JwtRealm extends AuthorizingRealm {

    private final ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwtToken = (String) token.getPrincipal();
        if(!shiroService.validateToken(jwtToken)){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        User user = shiroService.getByToken(jwtToken);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, jwtToken, getName());
        return info;
    }
}
