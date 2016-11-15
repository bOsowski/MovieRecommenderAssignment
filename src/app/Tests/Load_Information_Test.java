package app.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Load;

public class Load_Information_Test {
	public Load loadinfo;
	
	@Before
	private void setUp(){
		loadinfo = new Load();
	}

	@Test
	public void readFileTest() {
		assertEquals("",1);
	}

}
