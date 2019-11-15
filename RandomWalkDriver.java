import java.awt.Point;
import java.util.Scanner;
/**
 * @author Rohit Gangurde
 * implements a main method to create the walk
 */
public class RandomWalkDriver
{
	public static void main(String[] args) {
				int g= -1;
		int s = -1;
	
	
		Scanner sc = new Scanner (System.in);
		int gr=0; long se=0;
		while (g < 0)
		{
			System.out.println("Enter the grid size: ");
			   gr = sc.nextInt();
			if (gr > 0)
			{
				g = 2;
			
			}
			if(g<0)
			{
				System.out.println("Error : grid size must be positive.");
			}
			
		}
		
		while( s < 0 )
		{
			System.out.println("Enter random seed (0 for no seed):");
			 se= sc.nextLong();
			if (se >=0)
			{
				s = 2;
				
			}
			if(s<0)
			{
				System.out.println("Error: random seed must be >= 0!");
			}
		}
		
		
		
RandomWalk rand = null;
		if(se == 0) {
			rand = new RandomWalk(gr);}
			
		/**else
		{
			 rand = new RandomWalk(gr, se);}*/
		
		while(rand.isDone()==false) {
			rand.createWalk();}
		
		System.out.println(rand.toString());
		
		
	
		sc.close();
	}
}
