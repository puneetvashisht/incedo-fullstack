package com.cts;

public class A {
	
//	This is discouraged in Springs, you are not responsible as developer to wire dependencies
//	B b = new B()
	
	//Dependency Injection, using property injection with setter
	B bObj;
	C c;
	
	
	public C getC() {
		return c;
	}


	public void setC(C c) {
		this.c = c;
	}


	public B getbObj() {
		return bObj;
	}


	public void setbObj(B bObj) {
		this.bObj = bObj;
	}


	public void execute(){
		System.out.println("Exceute in A");
		bObj.execute();
		c.execute();
	}

}
