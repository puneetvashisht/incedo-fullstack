package com.cts.party.entity;
import java.io.Serializable;

public class PartyPeople implements Serializable {  
    public PartyPeople(){};  
    
    public PartyPeople(String name){this.name = name;};  
    
    public PartyPeople(String name, boolean isDrunk) {
      this.name = name; 
      this.drunk = isDrunk;
    };  
    public String name;  
    public boolean drunk;  
    
   /**  
     * @return the drunk  
     */  
    public boolean isDrunk() {  
         return drunk;  
    }  
    /**  
     * @param drunk the drunk to set  
     */  
    public void setDrunk(boolean drunk) {  
         this.drunk = drunk;  
    }  
    /**  
     * @return the name  
     */  
    public String getName() {  
         return name;  
    }  
    /**  
     * @param name the name to set  
     */  
    public void setName(String name) {  
         this.name = name;  
    }  
}  
