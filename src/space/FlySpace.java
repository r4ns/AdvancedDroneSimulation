package space;

import java.util.ArrayList;
import java.util.List;

import drones.Cube;

public class FlySpace {
	
	protected Cube outerBoundaries;
	protected Cube innerBoundaries;
	protected List<Cube> obstacles;
	
	public FlySpace(Cube outerCube, Cube innerCube)
	{
		outerBoundaries = outerCube;
		innerBoundaries = innerCube;
	}
	
	public FlySpace(Cube outerCube, Cube innerCube, List<Cube> obstacles)
	{
		outerBoundaries = outerCube;
		innerBoundaries = innerCube;
		this.obstacles = obstacles;
	}

	public Cube getOuterBoundaries() {
		return outerBoundaries;
	}

	public void setOuterBoundaries(Cube outerBoundaries) {
		this.outerBoundaries = outerBoundaries;
	}

	public Cube getInnerBoundaries() {
		return innerBoundaries;
	}

	public void setInnerBoundaries(Cube innerBoundaries) {
		this.innerBoundaries = innerBoundaries;
	}

	public List<Cube> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<Cube> obstacles) {
		this.obstacles = obstacles;
	}
}
