package springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ibm on 2016/2/25.
 */
@Aspect
public class PerformanceLoggingAspect {
    private ThreadLocal<Long> timePoints = new ThreadLocal<Long>();

    @Pointcut("execution(* springframework.beans..*.*(..))")
    public void methodInvocation(){}

    @Around("methodInvocation()")
    public Object performanceTracing(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long currentTime = System.currentTimeMillis();
        System.out.println(methodName + " start at " + currentTime);

        timePoints.set(currentTime);
        Object retObj =  pjp.proceed();

        long startTime = timePoints.get();
        currentTime = System.currentTimeMillis();

        System.out.println("time last:"+(currentTime - startTime));
        return retObj;
    }
}
