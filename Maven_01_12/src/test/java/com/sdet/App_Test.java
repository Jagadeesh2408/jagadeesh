package com.sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdetde.App;

public class App_Test {
		
	    @Test
		public void testlogin01() {
			App myapp=new App();
			Assert.assertEquals(0, myapp.userLogin("abc", "abc123"));
		}
	    @Test
	    public void test2() {
	    	App myapp=new App();
			Assert.assertEquals(1, myapp.userLogin("abc", "abc@123"));
	    }

}
