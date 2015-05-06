package com.prakhar.EPL.Football;

import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

public class FootballTest extends TestCase {

	@Test
	public void testteamName() throws IOException{
		
		assertEquals("Aston_Villa", Football.readfile("football.dat"));
	}
	
}
