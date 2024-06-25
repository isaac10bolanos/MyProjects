package com.skillstorm.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class VideoGameTest {
	
	VideoGame videoGame;
	
	@BeforeClass
	public static void startTest() {
		System.out.println("Starts VideoGameTest test");
	}
	
	@Test
	public void checkRelease() {
		videoGame = new VideoGame("Fifa 10", 2009, "PlayStation 2", 9, "Sports");
		assertTrue(videoGame.isRealeased(2023));
		assertFalse(videoGame.isRealeased(1900));
	}
	
	@Test
	public void checkGameAge() {
		videoGame = new VideoGame("Minecraft", 2011, "Nintengo Switch", 8, "Sandbox Survival");
		assertEquals(12, videoGame.getGameAge());
		assertNotEquals(14, videoGame.getGameAge());
	}
	
	@Test
	public void checkRating() {
		videoGame = new VideoGame("Halo 3", 2007, "Xbox 360", 10, "First-person shooter");
		assertTrue(videoGame.validateRating(videoGame.getRating()));
		assertFalse(videoGame.validateRating(11));
	}
	
	@AfterClass
	public static void endTest() {
		System.out.println("Ends VideoGameTest test");
	}

}
