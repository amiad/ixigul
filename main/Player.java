package main;

public abstract class Player {
	protected boolean mark;//mark as boolean. true is X false is O 

	//get mark of player as boolean. true is X false is O
	public Player(boolean  m){
		mark=m;
	}

	public boolean getMark() {
		return mark;
	}
	
	//return graphic mark of this player
	public char getGMark(){
		if (mark) return 'X';
		else return 'O';
	}
		
	//get the board and do the next step of this player
	public abstract void step(Board board);
	
}
