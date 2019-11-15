import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * @author Rohit Gangurde
 * includes methods needed to create the walk
 */
public class RandomWalk implements RandomWalkInterface {
	int gridSize;
	long seed;
	boolean done;
	int xcoor;
	int ycoor;
	ArrayList<Point> path = new ArrayList<Point>();
	Random rand;

	Point start = new Point();
/**
 * constructor to initialize the variables
 */
	public RandomWalk(int gr) {

		gridSize = gr;
		rand = new Random();
		done = false;
		xcoor = 0;
		ycoor = gridSize - 1;
		start = new Point(0, gridSize - 1);
		path.add(start);
	}
/**
 * constructor to initialize the variables and the random generator with a seed value
 */
	/**public RandomWalk(int gr, long se) {
		gridSize = gr;
		seed = se;
		xcoor = 0;
		ycoor = gridSize - 1;
		done = false;
		rand = new Random(seed);
		start = new Point(0, gridSize - 1);
		path.add(start);
	}**/
/**
 * takes a step 
 */
	public void step() {

		// Random rand = new Random();
		if (xcoor == 0 && ycoor == gridSize - 1) {
			int rando = rand.nextInt(2);
			if (rando == 0) {
				xcoor++;
			}
			if (rando == 1) {
				ycoor--;
			}

		}
		/**
		 * when x is 0 and y has increased
		 */
		else if (xcoor == 0 && ycoor != gridSize - 1 && ycoor != 0) {
			
				xcoor++;
		}

		else if (xcoor != 0 && ycoor == gridSize - 1 && xcoor != gridSize - 1) {
			
				ycoor --;
			
		}

		else if (xcoor != gridSize - 1 && ycoor != 0 && xcoor != 0 && ycoor != gridSize - 1) {
			int rando = rand.nextInt(2);
			if (rando == 0 ) {
				xcoor++;
			}
			if (rando == 1) {
				ycoor--;
			}
			
		}

		else if (xcoor != gridSize - 1 && ycoor == 0) {
				xcoor++;
			

		} else if (xcoor == gridSize - 1 && ycoor != 0) {
			
				ycoor--;
		}
		 
		
		

		start = new Point(xcoor, ycoor);
		path.add(start);

		if (xcoor == gridSize - 1 && ycoor == 0) {
			done = true;
		}
	}

	@Override
	public void stepEC() {
	}
/**
 * implements step method internally
 */
	@Override
	public void createWalk() {
		step();

	}

	@Override
	public void createWalkEC() {

	}
/**
 * returns the done variable
 */
	@Override
	public boolean isDone() {

		return done;
	}
/**
 * returns the gridsize
 */
	@Override
	public int getGridSize() {
		return gridSize;
	}
/**
 * returns the starting point
 */
	@Override
	public Point getStartPoint() {

		Point pt = new Point(0, gridSize - 1);
		return pt;
	}
/**
 * returns the end point
 */
	@Override
	public Point getEndPoint() {

		Point pt = new Point(gridSize - 1, 0);
		return pt;
	}
/**
 * returns the current point
 */
	@Override
	public Point getCurrentPoint() {

		int i = path.size();
		Point p = path.get(i - 1);
		return p;
	}
/**
 * returns the path
 */
	@Override
	public ArrayList<Point> getPath() {

		return path;
	}
/**
 * returns the path in String format
 */
	public String toString() {
		String str = "";
		ArrayList<Point> path_cop = getPath();
		for (Point members : path_cop) {
			str = str + "[" + members.x + "," + members.y + "]";
		}
		return str;

	}

	
}
