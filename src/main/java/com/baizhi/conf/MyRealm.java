package com.baizhi.conf;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        if (primaryPrincipal.equals("zhangsan")) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("super");
            simpleAuthorizationInfo.addStringPermission("user:add:*");
            simpleAuthorizationInfo.addStringPermission("user:update:*");
            simpleAuthorizationInfo.addStringPermission("user:query:*");
            return simpleAuthorizationInfo;

        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        if (principal.equals("zhangsan")) {
            AuthenticationInfo info = new SimpleAuthenticationInfo("zhangsan", "68609b8b64988c0f4def093eaa025e05", ByteSource.Util.bytes("abcd"), this.getName());
            return info;
        }
        return null;
    }
}
