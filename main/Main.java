/**
 * 
 */
package main;

/**
 * @author boaz
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Board b = new Board();
		b.PrintBoard();
		int choose;
		
		for (int i=0;i<9;i++)
		{
			choose = 0;
			// TODO - print "X turn" or "O turn" by i%2
			System.out.print("Please choose number between 1-9: ");
			while (choose == 0 || choose == 10 /* choose = 10 since have 'enter' in buffer after each step - TODO clean code (how?) */)
			{
				try
				{
					choose = System.in.read();
				}
				catch (Exception e)
				{
					System.err.println("Error in reading.");
				}
			}
			choose = choose - '0';
			while (b.getLocateValue(choose - 1) == 'X' || b.getLocateValue(choose - 1) == 'O')
			{
				System.out.print("Choose another number: ");
				try
				{
					System.in.read(); // buffer have 'enter' - TODO clean code
					choose = System.in.read();
				}
				catch (Exception e)
				{
					System.err.println("Error in reading.");
				}
				choose = choose - '0';
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
	

}
