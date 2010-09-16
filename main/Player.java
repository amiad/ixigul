
public abstract class Player {
	private char mark;//mark of player X or O
	private boolean markB; //mark as boolean. true is X false is O

	//get mark of player as boolean. true is X false is O
	public Player(boolean  m){
		if (m) mark='X';
		else mark='O';
		markB=m;
	}

	public char getMark() {
		return mark;
	}
	
	public boolean getMarkB(){
		return markB;
	}
	
	//get the board and return the next step of this player
	public abstract int step(Board board);
	
}
