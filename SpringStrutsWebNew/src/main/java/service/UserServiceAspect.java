package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

//	@Pointcut("execution(* service.*.*(..))")
//	public void businessMethods() {
//		System.out.println("greeting from pointcut");
//	}
	
//	@Around("businessMethods()")

	// Tymczasowo wyłączono
	@Around("execution(* service.*.*(..))")

	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
    		
    	MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    	//Method method = signature.getMethod();
    		String methodName = signature.getMethod().getName();
            long start = System.currentTimeMillis();
            System.out.println("Going to call the method: " + methodName);
            Object output = joinPoint.proceed();
            System.out.println("Method execution completed: " + methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            System.out.println(methodName + " Method execution time: " + elapsedTime + " milliseconds.");
//            if ("saveOrUpdate".equalsIgnoreCase(methodName))
//            {
//            	throw new Exception("Testowy wyjątek ");
//            }	
            return output;
    }
}
