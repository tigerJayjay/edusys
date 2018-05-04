package org.es.shiro.realm;

import java.security.acl.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.es.dao.AuthorityMapper;
import org.es.dao.LoginUserMapper;
import org.es.model.Authority;
import org.es.model.LoginUser;
import org.es.model.Role;
import org.es.service.common.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;
@Component
public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private ILoginService loginService;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// TODO Auto-generated method stub
		//获取session中的用户
		LoginUser user = (LoginUser) principal.fromRealm(this.getClass().getName()).iterator().next();
		//定义list集合用于存放当前用户的权限集合
		List<String> permissionList = new ArrayList<String>();
		List<String> rolesList = new ArrayList<String>();
		List<Role> roles = loginService.getRoles(user);
		if(roles.size() > 0){
			for (Role role : roles) {
				rolesList.add(role.getRoleName());
				List<Authority> permissions = loginService.getAuthoritys(role);
				if(permissions.size() > 0){
					for (Authority permission : permissions) {
						permissionList.add(permission.getAuthName());
					}
				}
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//将权限放入shiro中
		info.addRoles(rolesList);
		info.addStringPermissions(permissionList);
		return info;
	}
	//认证、登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		SimpleAuthenticationInfo info = null;
		
		//获取用户输入的token
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;
		LoginUser lu = new LoginUser();
		lu.setAccount(utoken.getUsername());
		lu.setPassword(new String(utoken.getPassword()));
		LoginUser user = loginService.login(lu);
		//MD5加盐
		if(user != null){
			Object principal = user.getAccount();
			Object credentials = user.getPassword();
			System.out.println(credentials);
			info = new SimpleAuthenticationInfo(user, credentials,this.getClass().getName());
		}
		
//		return new SimpleAuthenticationInfo(user, user.getUserPassword(), this.getClass().getName());
		return info;
	}

}
