/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise_12_1.aop;

import cs544.exercise12_1.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author HabibRahman
 */
@Aspect
public class TraceAdvice {    
    private ILogger logger;
    
    @Autowired
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }
    
    
    @After("execution (* cs544.exercise12_1.bank.dao.*.*(. .))")
    public void tracemethod(JoinPoint joinpoint) {
        logger.log("Logging Invoke = " + joinpoint.getSignature().getName());
    }
    
    
   
    
}
