package test.controller;

import junit.framework.Assert;
import main.controller.TempController;

import org.junit.Before;
import org.junit.Test;

public class TempControllerTest {
	
	private TempController controller;
	
	@Before
	public void setUp(){
		controller = new TempController();
	}
	
	@Test
	public void testValue(){
		Assert.assertEquals(10, controller.getValue());
	}

}
