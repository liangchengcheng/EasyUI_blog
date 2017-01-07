package com.lcc.realm;

import javax.annotation.Resource;

import com.lcc.entity.Blogger;
import com.lcc.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by lcc on 2017/1/7.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Blogger blogger = bloggerService.getByUsername(username);

        if (blogger != null){
            //设置 currentUser
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);

            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    blogger.getUsername(), blogger.getPassword(), "MyRealm");
            return authcInfo;
        }
        return null;
    }
}
