package cog.cts;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.A;

public class TestSpringSetup {

	@Test
	public void test() {
		System.out.println("First test case");
		assertTrue(true);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		A a = context.getBean("a", A.class);
		a.execute();
	}

}
