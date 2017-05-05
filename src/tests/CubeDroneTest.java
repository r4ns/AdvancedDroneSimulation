package tests;
import org.junit.Test;

import drones.Cube;
import drones.CubeDrone;
import drones.Drone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import space.FlySpace;

public class CubeDroneTest {
 
	CubeDrone drone;
	FlySpace flySpace;
	Cube cube;
	List<Cube> obstacles;
	
	@Test
	public void testInitialMoveUp(){
		Cube outerCube = new Cube(new int[] {0,0,0}, 50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube testDrone = new Cube(new int[] {30,1,30}, 1);
		Cube expectedDronePosition = new Cube(new int[] {30,2,30}, 1);
		drone = new CubeDrone(outerCube, innerCube, new int[] {30,1,30}, 1);
		String expectedResponse = expectedDronePosition.toString();
		
		assertEquals(expectedResponse, drone.moveUp());
	}

	@Test
	public void testDroneMoveUpHitsObstacleTryToGetAround(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0}, 50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {29,2,30}, 1);
		obstacles.add(new Cube(new int[] {30,2,30}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {30,1,30}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveUp());
	}
	
	@Test
	public void testDroneMoveDownHitsObstacleTryToGetAround(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {29,49,30}, 1);
		obstacles.add(new Cube(new int[] {30,49,30}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {30,50,30}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveDown());
		}
	
	@Test
	public void testDroneMoveRightHitsObstacleTryToGetAround(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {36,8,35}, 1);
		obstacles.add(new Cube(new int[] {36,9,35}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {35,9,35}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveRight());
		}
	
	@Test
	public void testDroneMoveLeftHitsObstacleTryToGetAround(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {9,9,10}, 1);
		obstacles.add(new Cube(new int[] {9,10,10}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {10,10,10}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveLeft());
		}
	@Test
	public void testDroneMoveBackHitsObstacleTryToGetAround(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {39,5,31}, 1);
		obstacles.add(new Cube(new int[] {40,5,31}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {40,5,30}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveBack());
		}
	
	@Test
	public void testDroneMoveForthHitsObstacleTryToGetAroundButForbidenUpRightDown(){
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {19,40,19}, 1);
		obstacles.add(new Cube(new int[] {20,40,19}, 5));
		drone = new CubeDrone(outerCube, innerCube, new int[] {20,40,20}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveForth());
		}
	@Test 	//ovde Vam (ili meni) puca kod, pomeri dron izvan granica i pomeri ga gore kao sto je zadato (bude {-1,1,0})
	public void testDroneMoveUpHitsObstacleTryToGetAroundButForbidenAll(){ 
		obstacles = new ArrayList<>();
		Cube outerCube = new Cube(new int[] {0,0,0},50);
		Cube innerCube = new Cube(new int[] {10,10,10}, 30);
		Cube expectedDronePosition = new Cube(new int[] {0,0,0}, 1);
		obstacles.add(new Cube(new int[] {0,1,0}, 5));
		//obstacles.add(new Cube(new int[] {1,0,0}, 1));
		//obstacles.add(new Cube(new int[] {0,0,1}, 1));
		drone = new CubeDrone(outerCube, innerCube, new int[] {0,0,0}, 1, obstacles);
		String expectedResponse = expectedDronePosition.toString();
		assertEquals(expectedResponse, drone.moveUp());
	}
		
}
