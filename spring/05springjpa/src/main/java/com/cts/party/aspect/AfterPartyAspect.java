package com.cts.party.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cts.party.entity.PartyPeople;


/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  

public class AfterPartyAspect {  
     /**  
      * Advice to send thank You Email to all guests, irrespective of whether they were   
      * too drunk or not.  
      * @param joinPoint  
      */  
     @After(value="(execution(* com.cts.party.service.*.*(..)))")  
     public void sendThankYouEmail(JoinPoint joinPoint) {  

         // get method arguments   
         Object[] args = joinPoint.getArgs();  

         // getting the method argument using Joinpoint API  
         PartyPeople partyPeople = (PartyPeople)args[0];  
         
         System.out.println("Sent thank you email to "+partyPeople.getName()+". Thank you "+partyPeople.getName()+" for coming to "+joinPoint.getSignature().getName());  
     }  
}  

