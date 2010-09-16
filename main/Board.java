/**
 * 
 */


/**
 * @author boaz
 *
 */
public class Board {

	private char[] locate;
	/**
	 * 
	 */
	public Board()
	{
		// TODO Auto-generated constructor stub
		locate = new char[9];
		locate[0]='1';
		locate[1]='2';
		locate[2]='3';
		locate[3]='4';
		locate[4]='5';
		locate[5]='6';
		locate[6]='7';
		locate[7]='8';
		locate[8]='9';
		
	}
	
	public void PrintBoard()
	{
		System.out.println(locate[0] + "|" + locate[1] + "|" + locate[2]);
		System.out.println("-----");
		System.out.println(locate[3] + "|" + locate[4] + "|" + locate[5]);
		System.out.println("-----");
		System.out.println(locate[6] + "|" + locate[7] + "|" + locate[8]);
	}
	
	public char getLocateValue(int i)
	{
		return locate[i];
	}
	
	public void setLocateValue(int i, char c)
	{
		locate[i] = c;
	}
	
	public void isWin()
	{
		//TODO - function that check if have a winner
		// Maybe the return type need change? Actual values?
		;
	}

	public int[] getEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

}
