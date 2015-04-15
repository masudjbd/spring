/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/**
 *
 * @author HabibRahman
 */
@Aspect
public class TraceAdvice {    
    @After("execution (* cs544.exercise13_1.EmailSender.sendEmail(. .))")
    public void tracemethod(JoinPoint joinpoint) {
        System.out.println("Fri Jun 05 14:09:47 GMT 2009 method= " + joinpoint.getSignature().getName());
    }
    
    @After("execution (* cs544.exercise13_1.EmailSender.sendEmail(. .)) && args(emailAddress, message)")
    public void tracemethod1(JoinPoint joinpoint, String emailAddress, String message) {
        System.out.println("address= "+emailAddress+" message= "+ message);
    }
    
    @After("execution (* cs544.exercise13_1.EmailSender.sendEmail(. .))")
    public void tracemethod2(JoinPoint joinpoint) {
       EmailSender emailsender =  (EmailSender) joinpoint.getTarget();       
        System.out.println("outgoing mail server= "+ emailsender.getOutgoingMailServer());
    }
    @Around("execution (* cs544.exercise13_1.CustomerDAO.save(. .))")
    public Object tracemethod3(ProceedingJoinPoint call) throws Throwable{
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object = call.proceed();
        clock.stop();
        System.out.println("Time to execute save = " + clock.getTotalTimeMillis() + " ms");
        
        return object;
    }
    
}
