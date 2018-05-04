package org.es.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.es.shiro.realm.AuthRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringShiroConfig {
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(manager);
		// 配置登录的url和登录成功的url
		bean.setLoginUrl("redirect:/login.jsp");
		bean.setSuccessUrl("/Home.jsp");
		// 配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//配置不会被拦截的链接
		/*filterChainDefinitionMap.put("/**", "anon");
		filterChainDefinitionMap.put("/resources/**", "anon");//放开静态资源
*/		filterChainDefinitionMap.put("/image*", "anon");
		filterChainDefinitionMap.put("/login*", "anon"); // 表示可以匿名访问
		filterChainDefinitionMap.put("/user/dologin", "anon");//执行登录操作，RequestMapping中对应的路径
		filterChainDefinitionMap.put("/resources/**", "anon");//放开静态资源
		filterChainDefinitionMap.put("/logout*", "anon");//退出登录操作
		//剩余请求需要身份验证登录
		filterChainDefinitionMap.put("/*", "authc");// 表示需要认证才可以访问
		filterChainDefinitionMap.put("/**", "authc");// 表示需要认证才可以访问
		filterChainDefinitionMap.put("/*.*", "authc");
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}

	// 配置核心安全事务管理器
	@Bean(name = "securityManager")
	public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
		System.err.println("--------------shiro已经加载----------------");
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(authRealm);
		manager.setCacheManager(ehCacheManager());
		return manager;
	}

	// 配置自定义的权限登录器
	@Bean(name = "authRealm")
	public AuthRealm authRealm() {
		AuthRealm authRealm = new AuthRealm();
		authRealm.setCacheManager(ehCacheManager());
		return authRealm;
	}
	
	 @Bean(value="ehCacheManager")
     public EhCacheManager ehCacheManager() {
             EhCacheManager cacheManager = new EhCacheManager();                
             return cacheManager;
     }

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
		@Qualifier("securityManager") SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}
	
	
}
