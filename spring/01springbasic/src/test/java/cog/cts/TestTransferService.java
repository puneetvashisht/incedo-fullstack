package cog.cts;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.service.TransferService;

//This is not going to work now.. need a new test case
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestTransferService {
	
//	private ApplicationContext context;

	//No longer required as Spring is going to load bean.xml using @ContextConfiguration	
//	@Before
//	public void setup(){
//		//Before each test case run this..
//		context = new ClassPathXmlApplicationContext("beans.xml");
//	}
	
	//This can be dependency injected
	@Autowired
	TransferService service;

	@Test
	public void testtransfer() {
//		TransferService service = context.getBean(TransferService.class);
		boolean result = service.transfer(1, 2, 23443.3);
		assertTrue(result);
	}
	
	@Test
	public void testBalanceInquiry(){
		double balance = service.checkBalance(12);
		assertTrue("Balance is above minimum balance", balance>5000);
	}
	//Green indicates success
	//Red indicates failure of test case

}
