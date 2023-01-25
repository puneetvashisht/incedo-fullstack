package com.cts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.party.entity.PartyPeople;
import com.cts.party.service.IPartyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestPartyService {
	
	@Autowired
	IPartyService partyService;

//	@Test
//	public void testFetchCourses(){
//		List<Course> courses = service.fetchCourses();
//		assertEquals("The length should be 1", courses.size(), 1);
//	}
	
	@Test
	public void testLetsParty(){
		PartyPeople p1 = new PartyPeople("arnold", true);
		try {
			partyService.letsParty(p1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		System.out.println("Allz well!! that ends well");
	}
}
