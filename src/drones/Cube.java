package drones;

public class Cube {
	
	private int [] minCoordinates;
	private int cubeSideLength;
	private int [] maxCoordinates;
	
	public Cube(int [] cubeStartCoordinates, int side)
	{
		minCoordinates = new int[] {cubeStartCoordinates[0], cubeStartCoordinates[1], cubeStartCoordinates[2]};
		cubeSideLength = side;
		maxCoordinates = new int [] {cubeStartCoordinates[0] + side, cubeStartCoordinates[1] + side, cubeStartCoordinates[2] + side};
	}
	
	public Cube(Cube cube)
	{
		setMinCoordinates(cube.getMinCoordinates());
		setCubeSideLength(cube.getCubeSideLength());		
		setMaxCoordinates(cube.getMaxCoordinates());
	}
	
	public Cube()
	{
		
	}
	
	/**
	 * Checks if passed coordinates are inside the defined cube
	 * @param coordinates point coordinates to check
	 */
	public boolean checkCoordinates(int [] coordinates)
	{
		if (coordinates[0] < maxCoordinates[0] && coordinates[0] > minCoordinates[0] &&
			coordinates[1] < maxCoordinates[1] && coordinates[1] > minCoordinates[1] &&
			coordinates[2] < maxCoordinates[2] && coordinates[2] > minCoordinates[2])
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	/**
	 * Checks if the passed cube is in some part contained inside the instantiated cube
	 */
	public boolean checkCubeIntersection(Cube cube)
	{
		if (checkCoordinates(cube.minCoordinates) || checkCoordinates(cube.maxCoordinates)) 
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	public boolean checkIfCubesAreTouching(Cube cube)
	{
		if ((cube.minCoordinates[0] == maxCoordinates[0] || cube.minCoordinates[0] == minCoordinates[0] ||
			cube.maxCoordinates[0] == minCoordinates[0] ||	cube.maxCoordinates[0] == maxCoordinates[0]) ||
			(cube.minCoordinates[1] == maxCoordinates[1] || cube.minCoordinates[1] == minCoordinates[1] ||
			cube.maxCoordinates[1] == minCoordinates[1] ||	cube.maxCoordinates[1] == maxCoordinates[1]) ||
			(cube.minCoordinates[2] == maxCoordinates[2] || cube.minCoordinates[2] == minCoordinates[2] ||
			cube.maxCoordinates[2] == minCoordinates[2] ||	cube.maxCoordinates[2] == maxCoordinates[2]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		return "Drone position: (" + Integer.toString(minCoordinates[0]) + ","
				+ Integer.toString(minCoordinates[1]) + ","  
				+ Integer.toString(minCoordinates[2]) + "), ("
				+ Integer.toString(maxCoordinates[0]) + ","
				+ Integer.toString(maxCoordinates[1]) + ","  
				+ Integer.toString(maxCoordinates[2]) + ")";	
	}
	
	public boolean checkIfCubesAreTouchingFromInside(Cube cube)
	{
		return checkIfCubesAreTouching(cube) && checkCubeIntersection(cube);
	}
	
	public boolean checkIfCubesAreTouchingFromOutside(Cube cube)
	{
		return checkIfCubesAreTouching(cube) && !checkCubeIntersection(cube);
	}
	
	public void increaseX(int x)
	{
		minCoordinates[0] += x;
		maxCoordinates[0] += x;
	}
	
	public void increaseY(int y)
	{
		minCoordinates[1] += y;
		maxCoordinates[1] += y;
	}
	
	public void increaseZ(int z)
	{
		minCoordinates[2] += z;
		maxCoordinates[2] += z;
	}
	
	public void decreaseX(int x)
	{
		minCoordinates[0] -= x;
		maxCoordinates[0] -= x;
	}
	
	public void decreaseY(int y)
	{
		minCoordinates[1] -= y;
		maxCoordinates[1] -= y;
	}
	
	public void decreaseZ(int z)
	{
		minCoordinates[2] -= z;
		maxCoordinates[2] -= z;
	}

	public int[] getMinCoordinates() {
		return minCoordinates;
	}

	public void setMinCoordinates(int[] minCoordinates) {
		this.minCoordinates = minCoordinates;
	}

	public int getCubeSideLength() {
		return cubeSideLength;
	}

	public void setCubeSideLength(int cubeSideLength) {
		this.cubeSideLength = cubeSideLength;
	}

	public int[] getMaxCoordinates() {
		return maxCoordinates;
	}

	public void setMaxCoordinates(int[] maxCoordinates) {
		this.maxCoordinates = maxCoordinates;
	}
}
