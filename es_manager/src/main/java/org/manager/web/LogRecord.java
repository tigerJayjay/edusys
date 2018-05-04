package org.manager.web;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.es.model.LoginUser;
import org.es.model.OperatorRecord;
import org.es.service.manager.logger.IOperatorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.swagger.annotations.ApiOperation;

@Component
@Aspect
public class LogRecord {
	@Autowired
	private IOperatorRecordService operatorService;
	@Pointcut("execution(public * org.manager.web.*.*Controller.*(..))")  
    public void webLog(){}  
  
    @Before("webLog()")  
    public void deBefore(JoinPoint joinPoint) throws Throwable {  
        // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        
        HttpServletRequest request = attributes.getRequest();  
        LoginUser login = (LoginUser) request.getSession().getAttribute("login");
        String account = login.getAccount();
        // 记录下请求内容  
        System.out.println("URL : " + request.getRequestURL().toString());  
        System.out.println("HTTP_METHOD : " + request.getMethod());  
        System.out.println("IP : " + request.getRemoteAddr());  
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        Class clazz = Class.forName(joinPoint.getSignature().getDeclaringTypeName());
        Method[] methods = clazz.getMethods();
        Method me = null;
        for(Method method:methods){
        	String methodName = method.getName();
        	if(joinPoint.getSignature().getName().equals(methodName)){
        		me = method;
        	}
        }
        ApiOperation[] annotationsByType = me.getAnnotationsByType(ApiOperation.class);
        if(annotationsByType.length>0){
	        System.out.println(annotationsByType[0].value());
	        if(annotationsByType[0].value().contains("添加")||annotationsByType[0].value().contains("删除")||annotationsByType[0].value().contains("更新")){
	        	OperatorRecord record = new OperatorRecord();
	        	record.setContent(annotationsByType[0].value());
	        	record.setOprtime(new Date());
	        	record.setOprno(account);
	        	operatorService.insertLogger(record);
	        }
        }
        
    }  
}
