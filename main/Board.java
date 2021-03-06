package main;

import java.util.Vector;

/**
 * @author boaz, September 2010
 * @version 1.0
 */
public class Board implements Cloneable {

	/**
	 * Board game - private array of chars
	 */
	private char[] locate;
	
	// list of empty cells
	private Vector<Integer> empty=new Vector<Integer>();
	/**
	 * Constructor for class Board - only initialize locate array
	 */
	public Board()
	{
		locate = new char[9];
		for (int i=1;i<=9;i++){
			locate[i-1]=Character.forDigit(i, 10);
			empty.add(new Integer(i-1));						
		}
	}
	
	/**
	 * This function just print the board to standard output.
	 * 
	 */
	public void PrintBoard()
	{
		System.out.println(locate[0] + "|" + locate[1] + "|" + locate[2]);
		System.out.println("-----");
		System.out.println(locate[3] + "|" + locate[4] + "|" + locate[5]);
		System.out.println("-----");
		System.out.println(locate[6] + "|" + locate[7] + "|" + locate[8]);
		System.out.println();
	}
	
	/**
	 * 
	 * @param i - The locate that we want to get.
	 * @return The value in locate i.
	 */
	public char getLocateValue(int i)
	{
		return locate[i];
	}
	
	/**
	 * 
	 * @param i - The locate that we want to change
	 * @param value - Value to set to locate i
	 */
	public void setLocateValue(int i, char value)
	{
		locate[i] = value;
		empty.remove(new Integer(i));
	}
	
	/**
	 * 
	 * @return true if have a winner in this board, false otherwise.
	 */
	public boolean isWin()
	{
		if ( (locate[0] == locate[1] && locate[1] == locate[2]) || //0-1-2 (first row)
				(locate[3] == locate[4] && locate[4] == locate[5]) || //3-4-5 (second row)
				(locate[6] == locate[7] && locate[7] == locate[8]) || //6-7-8 (third row)
				(locate[0] == locate[3] && locate[3] == locate[6]) || //0-3-6 (left column)
				(locate[1] == locate[4] && locate[4] == locate[7]) || //1-4-7 (center column)
				(locate[2] == locate[5] && locate[5] == locate[8]) || //2-5-8 (right column)
				(locate[0] == locate[4] && locate[4] == locate[8]) || //0-4-8 (left-up diagonal)
				(locate[2] == locate[4] && locate[4] == locate[6]) ) //2-4-6 (left-down diagonal)
			return true;
		else
			return false;
			
	}
	
	/**
	 * @return array of ints with indexes of empty cell in board
	 */
	public int[] getEmpty() {
		Integer[] arr=new Integer[empty.size()];
		empty.toArray(arr); //convert vector empty to array
		int[] arrInt=new int[arr.length];
		for (int i=0;i<arr.length;i++) 
			arrInt[i]=arr[i].intValue(); //convert Integer array to int array
		return arrInt;
	}
	
	/**
	 * check the status of the game.
	 * @return 0 in case the game still going, 1 for draw (teko), 2 for X win, and 3 for O win
	 */
	public int getStatus(){
		for (int i=0;i<3;i++) {
			if ((locate[i*3]==locate[i*3+1]) && (locate[i*3+1]==locate[i*3+2])) // Horizontal sequence
				return returnCode(locate[i*3]);
			else if ((locate[i]==locate[i+3]) && (locate[i+3]==locate[i+6])) // Vertical sequence
				return returnCode(locate[i]);
		} // for
		
		if ((locate[0] == locate[4] && locate[4] == locate[8]) || // 0-4-8 (left-up diagonal)
				(locate[2] == locate[4] && locate[4] == locate[6])) // 2-4-6 (left-down diagonal)
			return returnCode(locate[4]);
		
		if (getEmpty().length==0)
			return 1; // Draw case
		else
			return 0; // The game is not finished yet
	}
	
	/**
	 * 
	 * @param c the mark has wined
	 * @return Code of the winner. X=2, O=3
	 */
	private int returnCode(char c) {
		if (c=='X')
			return 2;
		else
			return 3;
	}
	
	/**
	 * @return clone of this Board class
	 */
	public Board clone(){
		Board board2=new Board();
		for (int i=0;i<locate.length;i++)
			if ((locate[i]=='X')||(locate[i]=='O')) board2.setLocateValue(i, locate[i]);
		return board2;
	}
}
