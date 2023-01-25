package cog.cts;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.service.TransferService;

//This is not going to work now.. need a new test case

public class TestTransferServicewithXml {
	
	private static ApplicationContext context;
	private static TransferService service;

	
	@BeforeClass
	public static void setup(){
		System.out.println("This would run only once");
		//Before each test case run this..
		context = new ClassPathXmlApplicationContext("beans.xml");
		service = context.getBean(TransferService.class);
	}
	
	@Before
	public void beforeEachTestCase(){
		System.out.println("Runs before each test case");
	}
	

	@Test
	public void testtransfer() {
		
		boolean result = service.transfer(1, 2, 23443.3);
		assertTrue(result);
	}
	x
	@Test
	public void testBalanceInquiry(){
		double balance = service.checkBalance(12);
		assertTrue("Balance is above minimum balance", balance>5000);
	}
	//Green indicates success
	//Red indicates failure of test case

}
