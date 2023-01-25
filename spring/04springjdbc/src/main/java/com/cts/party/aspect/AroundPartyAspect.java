package com.cts.party.aspect;


import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cts.party.entity.PartyPeople;



/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  

public class AroundPartyAspect {  
     /**  
      * Advice to log entering and exit of guests.  
      * @param proceedingJoinPoint  
      * @throws Throwable   
      */  
     @Around(value="(execution(* com.cts.party.service.*.*(..)))")  
     public void audit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {  

          // get method arguments   
          Object[] args = proceedingJoinPoint.getArgs();  

          // getting the method argument using Joinpoint API  
          PartyPeople partyPeople = (PartyPeople)args[0];  
          
          long startTime = System.currentTimeMillis();
          //auditing entry and exit  
          System.out.println(partyPeople.getName()+" came in at "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE));  
          
          try {  
               proceedingJoinPoint.proceed();  
          } finally {  
               // exit time kept in finally block so that even if there is any exception from method  
               // the exit time still gets audited  
        	  long endTime = System.currentTimeMillis();
               System.out.println(partyPeople.getName()+" left at "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE)); 
               System.out.println("Total time spent in party: " + (endTime-startTime));
          }  
     }  
}  
