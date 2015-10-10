package service;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceSec {

//	@Around("execution(* service.UserService.getAll(..))")
//	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		System.out.println("logAround() before");
//		joinPoint.proceed(); // continue on the intercepted method
//		System.out.println("logAround() after");
//	}
}
