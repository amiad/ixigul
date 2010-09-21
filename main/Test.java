package main;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board b=new Board();
		CompPlayer p1=new CompPlayer(true, 4);
		CompPlayer p2=new CompPlayer(false, 4);
		p1.step(b);
		b.PrintBoard();
		p2.step(b);
		b.PrintBoard();
		p1.step(b);
		b.PrintBoard();
		p2.step(b);
		b.PrintBoard();
		p1.step(b);
		b.PrintBoard();
		p2.step(b);
		b.PrintBoard();
	}

}
