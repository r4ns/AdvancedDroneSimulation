package tests;

import org.junit.Test;

import drones.Cube;

import static org.junit.Assert.*;

public class CubeTest {

	Cube cube;
	
	@Test
	public void testIfCoordinatesAreInCube()
	{
		cube = new Cube(new int [] {10,10,10}, 2);
		int [] coordinatesToTest = new int [] {11,11,11};
		assertTrue("Coordinates ("+ Integer.toString(coordinatesToTest[0]) + ","+ Integer.toString(coordinatesToTest[1]) + "," + Integer.toString(coordinatesToTest[2])  
		+") do not belong to cube", cube.checkCoordinates(coordinatesToTest));
	}
	
	@Test
	public void testIfCubeIsInSomePartContainedInOtherCube()
	{
		cube = new Cube(new int [] {10,10,10}, 2);
		Cube cube2 = new Cube(new int [] {11,11,11}, 3);
		assertTrue(cube2.checkCubeIntersection(cube));
	}
	
	@Test
	public void testIfCubesAreTouchingFromInsideInOnePoint()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {10,10,10}, 2);
		assertTrue(cube.checkIfCubesAreTouching(cube2));
	}
	
	@Test
	public void testIfCubesAreTouchingFromInsideAlongOneCubeSide()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {10,12,12}, 2);
		assertTrue(cube.checkIfCubesAreTouching(cube2));
	}
	
	@Test
	public void testIfCubesAreTouchingFromOutsideInOnePoint()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {15,15,15}, 2);
		assertTrue(cube.checkIfCubesAreTouching(cube2));
	}
	
	@Test
	public void testIfCubesAreTouchingFromOutsideAlongOneCubeSide()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {15,13,11}, 2);
		assertTrue(cube.checkIfCubesAreTouching(cube2));
	}
	
	@Test
	public void testIfCubesAreTouchingFromOutside()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {15,13,11}, 2);
		assertTrue(cube.checkIfCubesAreTouchingFromOutside(cube2));
	}
	
	@Test
	public void testIfCubesAreTouchingFromInside()
	{
		cube = new Cube(new int [] {10,10,10}, 5);
		Cube cube2 = new Cube(new int [] {10,12,12}, 2);
		assertTrue(cube.checkIfCubesAreTouchingFromInside(cube2));
	}
}
