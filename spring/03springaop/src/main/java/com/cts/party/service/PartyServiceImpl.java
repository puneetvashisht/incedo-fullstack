package com.cts.party.service;


import org.springframework.stereotype.Service;

import com.cts.party.entity.PartyPeople;
import com.cts.party.exceptions.GotTooDrunkException;


 
@Service
public class PartyServiceImpl implements IPartyService {  
     /**  
      * guests wait for some time in party then leave.  
      * If a guest gets too drunk then they are taken out.  
      */  
	
	public PartyServiceImpl(){
		
	}
	
     public void letsParty(PartyPeople people) throws Exception {  
               Thread.sleep(2000);  
               System.out.println("Partying.....");
               if (people.isDrunk()) {  
                    throw new GotTooDrunkException();  
               }  
     }  
}  
