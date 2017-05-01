package drones;

import java.util.List;

import space.FlySpace;

public class CubeDrone extends Drone{

	Cube drone = null;
	Cube newCube = null;
	private boolean obstacleHit = false;
	private int moveCounter;

	public CubeDrone(Cube outerBoundaries, Cube innerBoundaries, int [] droneStartCoordinates, int dronSide)
	{
		super(outerBoundaries, innerBoundaries);
		this.drone = new Cube(droneStartCoordinates, dronSide);


	}

	public CubeDrone(Cube outerBoundaries, Cube innerBoundaries, int [] droneStartCoordinates, int dronSide, List<Cube> obstacles)
	{
		super(outerBoundaries, innerBoundaries, obstacles);
		this.drone = new Cube(droneStartCoordinates, dronSide);

	}

	@Override
	protected boolean validateDronePositionAfter(String command)
	{
		int[] minCoordinates = drone.getMinCoordinates();
		int droneSide = drone.getCubeSideLength();
		newCube = new Cube(minCoordinates, droneSide);

		switch (command) {
		case "up":
			getAroundObstacle("up");
			if(obstacleHit==true){
				
				moveLeft();
				newCube.increaseY(1);
				break;
			} else {

				newCube.increaseY(1);
				break;	
			}

		case "down":
			getAroundObstacle("down");
			if(obstacleHit==true){

				moveRight();
				newCube.decreaseY(1);
				break;
			} else {

				newCube.decreaseY(1);
				break;	
			}
		case "left":

			getAroundObstacle("left");
			if(obstacleHit==true){

				moveUp();
				newCube.decreaseX(1);
				break;
			} else {

				newCube.decreaseX(1);
				break;	
			}
				
		case "right":
			getAroundObstacle("right");
			if(obstacleHit==true){

				moveUp();
				newCube.increaseX(1);
				break;
			} else {

				newCube.increaseX(1);
				break;	
			}
			
		case "back":
			
			getAroundObstacle("back");
			if(obstacleHit==true){

				moveRight();
				newCube.increaseZ(1);
				break;
			} else {

				newCube.increaseZ(1);
				break;	
			}
			
		case "forth":
			getAroundObstacle("forth");
			if(obstacleHit==true){

				moveRight();
				newCube.decreaseZ(1);
				break;
			} else {

				newCube.decreaseZ(1);
				break;	
			}
			
		}
		return !super.flySpace.getInnerBoundaries().checkCubeIntersection(newCube) ||
				!super.flySpace.getOuterBoundaries().checkCubeIntersection(newCube);
	}


	private boolean getAroundObstacle(String initialCommand)
	{		
		if(initialCommand == "up"){


			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0],drone.getMinCoordinates()[1]+drone.getCubeSideLength(),drone.getMinCoordinates()[2]},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					}
				}
				
				obstacleHit=false;
				return false;
			} 
				 
			

		} else if(initialCommand == "down"){

			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0],drone.getMinCoordinates()[1]-drone.getCubeSideLength(),drone.getMinCoordinates()[2]},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					}
				}
				
				obstacleHit=false;
				return false; 
			} 
				
			

		} else if(initialCommand == "left"){

			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0]-drone.getCubeSideLength(),drone.getMinCoordinates()[1],drone.getMinCoordinates()[2]},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					} 
				}
				
				obstacleHit=false;
				return true;
					
			}


		}  else if(initialCommand == "right"){

			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0]+drone.getCubeSideLength(),drone.getMinCoordinates()[1],drone.getMinCoordinates()[2]},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					} 
				}
				
				obstacleHit=false;
				return true;
					
			}


		} else if(initialCommand == "back"){

			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0],drone.getMinCoordinates()[1],drone.getMinCoordinates()[2]+drone.getCubeSideLength()},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					} 
				}
				
				obstacleHit=false;
				return true;
					
			}


		} else if(initialCommand == "forth"){

			if(flySpace.getObstacles()!=null){
				Cube cubeForSearching = new Cube(new int[] {drone.getMinCoordinates()[0],drone.getMinCoordinates()[1],drone.getMinCoordinates()[2]-drone.getCubeSideLength()},drone.getCubeSideLength());

				for (Cube temp : super.flySpace.getObstacles()){

					if(equals(temp,cubeForSearching) == true){

						obstacleHit=true;
						return true;
					} 
				}
				
				obstacleHit=false;
				return true;
					
			}


		} else {
			
			return false;
		}
		
		return false;
			
			
		
			
	}

	public boolean equals(Cube cubeFirst, Cube cubeSecond){

		if(cubeFirst.getMinCoordinates()[0] ==cubeSecond.getMinCoordinates()[0] &&
				cubeFirst.getMinCoordinates()[1] ==cubeSecond.getMinCoordinates()[1] &&
				cubeFirst.getMinCoordinates()[2] ==cubeSecond.getMinCoordinates()[2]){



			return true;
		} else {

			return false;
		}





	}


	@Override
	public String moveUp() {
		if(validateDronePositionAfter("up"))
		{
			drone.getMinCoordinates()[1] += 1;
			drone.getMaxCoordinates()[1] += 1;
		}
		return drone.toString();
	}

	@Override
	public String moveDown() {
		if(validateDronePositionAfter("down"))
		{
			drone.getMinCoordinates()[1] -= 1;
			drone.getMaxCoordinates()[1] -= 1;
		}
		return drone.toString();
	}

	@Override
	public String moveLeft() {
		if(validateDronePositionAfter("left"))
		{
			drone.getMinCoordinates()[0] -= 1;
			drone.getMaxCoordinates()[0] -= 1;
		}
		return drone.toString();
	}

	@Override
	public String moveRight() {
		if(validateDronePositionAfter("right"))
		{
			drone.getMinCoordinates()[0] += 1;
			drone.getMaxCoordinates()[0] += 1;
		}
		return drone.toString();
	}

	@Override
	public String moveBack() {
		if(validateDronePositionAfter("back"))
		{
			drone.getMinCoordinates()[2] += 1;
			drone.getMaxCoordinates()[2] += 1;
		}
		return drone.toString();
	}

	@Override
	public String moveForth() {
		if(validateDronePositionAfter("forth"))
		{
			drone.getMinCoordinates()[2] -= 1;
			drone.getMaxCoordinates()[2] -= 1;
		}
		return drone.toString();
	}

}
