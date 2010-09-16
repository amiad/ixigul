package main;
import java.io.*;

/**
 * @author boaz, September 2010
 * @version 1.0
 *
 */
public class Main {

	/**
	 * @param args - arguments from command line. in our application (right now) have not any care about command line parameters
	 */
	public static void main ( String[] args )
	{
		/* b is board that we gaming on. create new object and print the clean board */
		Board b = new Board();
		b.PrintBoard();
		int choose;
		
		
		for (int i=0;i<9;i++) { // i is turn number, and in tic-tac-toe have exactly 9 turns
			choose = 0; // choose is the locate that choosed by player
			if (i % 2 == 0)
				System.out.print("X, is your turn, ");
			else
				System.out.print("O, is your turn, ");
			
			choose = readInt(1,9);
			while (b.getLocateValue(choose - 1) == 'X' || b.getLocateValue(choose - 1) == 'O') {
				System.out.print("Choose another number: ");
				choose = readInt(1,9);
			}
			if (i % 2 == 0)
				b.setLocateValue(choose - 1, 'X');
			else
				b.setLocateValue(choose - 1, 'O');
			b.PrintBoard();
			if (b.isWin() == true) {
				System.out.println("Player " + (i%2==0?'X':'O') + " win!");
				i=9;
			}	
		}
	}
	
	/**
	 * This function read from standard input and check if this is one char and if is number<br>
	 * more information in: <a href=http://www.java2s.com/Code/Java/Development-Class/ReadanintfromStandardInput.htm>http://www.java2s.com/Code/Java/Development-Class/ReadanintfromStandardInput.htm</a>
	 * @param lowLimit - Lower limit of the integer we want to read
	 * @param highLimit - Higher limit of the integer we want to read
	 * @return integer between lowLimit and highLimit
	 */
	public static int readInt(int lowLimit, int highLimit)
	{
		/**
		 * Buffer for input string
		 */
		String line = null;
		/**
		 * The value to return
		 */
	    int val = 0;
	    /**
	     * Flag to check if need re-read from input
	     */
	    boolean flag = false;
	    
	    // Loop until right number was received
	    do {
	    	System.out.print("Please choose number between " + lowLimit + " and " + highLimit + ": ");
		    try {
		    	BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		    	line = is.readLine();
		    	val = Integer.parseInt(line);
			    flag = true;
		    }
		    catch (NumberFormatException ex) {
		    	System.err.println("Not a valid number: " + line);
		    }
		    catch (IOException e) {
		    	System.err.println("Unexpected IO ERROR: " + e);
		    }
		    
		    // Check if val is in limits
		    if (val < lowLimit || val > highLimit) {
		    	System.out.println("The number is out of limit.");
		    	flag = false;
		    }
	    } while (flag == false);
	    
	    return val;
	    
	}
}
