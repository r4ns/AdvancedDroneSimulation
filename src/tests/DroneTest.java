package tests;

import org.junit.Test;

import drones.*;

import static org.junit.Assert.*;

import space.*;

public class DroneTest {
	
	Drone drone;
	FlySpace flySpace;
	Cube cube;
	
	@Test
	public void testInitialMoveUp()
	{
		Cube outerCube = new Cube(new int[] {0,0,0}, 50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		
		drone = new Drone(outerCube, innerCube, new int [] {30,0,30});
		
		String expectedResponse = "Drone position: (" + Integer.toString(30) + ","
								  + Integer.toString(1) + ","  
								  + Integer.toString(30) + ")";
		
		assertEquals(expectedResponse, drone.moveUp());
	}
	
	@Test
	public void testInitialMoveDown()
	{
		Cube outerCube = new Cube(new int[] {0,0,0}, 50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		
		drone = new Drone(outerCube, innerCube, new int [] {30,0,30});
		
		String expectedResponse = "Drone position: (" + Integer.toString(30) + ","
								  + Integer.toString(0) + ","  
								  + Integer.toString(30) + ")";
		
		assertEquals(expectedResponse, drone.moveDown());
	}
	
	@Test 
    public void testMoveLeftHitInnerCubeRightSideBorder() 
    { 
		Cube outerCube = new Cube(new int[] {0,0,0}, 50); 
		Cube innerCube = new Cube(new int[] {10,10,10}, 30); 
 
		drone = new Drone(outerCube, innerCube, new int [] {40,25,30}); 
 
		String expectedResponse = "Drone position: (" + Integer.toString(40) + "," 
				+ Integer.toString(25) + ","   
				+ Integer.toString(30) + ")"; 
 
		assertEquals(expectedResponse, drone.moveLeft()); 
    }
}
