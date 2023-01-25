package com.cts.party.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cts.party.entity.PartyPeople;
import com.cts.party.exceptions.GotTooDrunkException;



/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  

public class AfterThrowingPartyAspect {  

    /**  
      * Advice to send thank You Email to all guests, irrespective of whether they were   
      * too drunk or not.  
      * @param joinPoint  
      */  
     @AfterThrowing(value="(execution(* com.cts.party.service.*.*(..)))", throwing="exception")  
     public void callCabForDrunkGuests(JoinPoint joinPoint, Exception exception) {  

          if (exception instanceof GotTooDrunkException) {  
                    // get method arguments   
                    Object[] args = joinPoint.getArgs();  

                    // getting the method argument using Joinpoint API  
                    PartyPeople partyPeople = (PartyPeople)args[0];  
                    System.out.println(partyPeople.getName()+" got too drunk. Calling cab!!");  
          }   
          // No need to handle NotOnListException as exceptions thrown by @Before advice never come to @AfterThrowing  
     }  
}  