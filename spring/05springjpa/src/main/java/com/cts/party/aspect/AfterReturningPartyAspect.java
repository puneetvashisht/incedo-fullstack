package com.cts.party.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.cts.party.entity.PartyPeople;


/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  
public class AfterReturningPartyAspect {  
     /**  
      * Advice to give party gift to guests who came out without getting too drunk.  
      * @param joinPoint  
      */  
     @AfterReturning(value="(execution(* com.cts.party.service.*.*(..)))")  
     public void givePartyGift(JoinPoint joinPoint) {  
          // get method arguments   
          Object[] args = joinPoint.getArgs();  
         
          // getting the method argument using Joinpoint API  
          PartyPeople partyPeople = (PartyPeople)args[0];  
         
          System.out.println(partyPeople.getName()+" got party gift.");  
     }  
}  
