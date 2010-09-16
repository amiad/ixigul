package main;
import java.io.*;

/**
 * @author boaz
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		/* b is board that we gaming on. create new object and print the clean board */
		Board b = new Board();
		b.PrintBoard();
		int choose;
		
		
		
		for (int i=0;i<9;i++) // i is turn number, and in tic-tac-toe have exactly 9 turns
		{
			choose = 0; // choose is the locate that choosed by player
			if (i % 2 == 0)
				System.out.print("X, is your turn, ");
			else
				System.out.print("O, is your turn, ");
			
			choose = readInt(1,9);
			while (b.getLocateValue(choose - 1) == 'X' || b.getLocateValue(choose - 1) == 'O')
			{
				System.out.print("Choose another number: ");
				choose = readInt(1,9);
			}
			if (i % 2 == 0)
			{
				b.setLocateValue(choose - 1, 'X');
			}
			else
			{
				b.setLocateValue(choose - 1, 'O');
			}
			b.PrintBoard();
			b.isWin();
		}
	}
	
	/*
	 * This function read from standard input and check if this is one char and if is number
	 * more information in: http://www.java2s.com/Code/Java/Development-Class/ReadanintfromStandardInput.htm
	 */
	public static int readInt(int lowLimit, int highLimit)
	{
		String line = null;
	    int val = 0;
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
