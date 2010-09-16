
public class CompPlayer extends Player{
	@SuppressWarnings("unused")
	private int level;//the level of computer player. probability to do best step (level/4)
	
	//get mark of player and the level of computer
	public CompPlayer(boolean m, int l) {
		super(m);
		level=l;
	}
	
	//get the board and return the next step of this player. the step is best step or random step by level
	public int step(Board board){
		int step = 0;
		int correct=(int) Math.random()*(4-level);
		if (correct==0) step=correct(board);
		else step=rndStep(board);
		return step;
	}
	private int rndStep(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	//return the best step
	private int correct(Board board) {
		return correct(board,0)[0];
	}

	public int[] correct(Board board, int lastStep) {
		int[] answer=new int[2];
		if (/*I win*/) {answer={lastStep,2}; return answer;}
		else if (/*teko*/) {answer={lastStep,1}; return answer;}
		else if (/*I lost*/) {answer={lastStep,0}; return answer;}
		else{
			CompPlayer other=new CompPlayer(!markB, 4)
			for (int i=0;i<board.getEmpty().length;i++){
				Board board2=new Board(board);
				int nextStep=board.getEmpty(i);
				board2.getLocateValue(nextStep);
				int myStep=lastStep;
				if (lastStep==0) myStep=nextStep;
				other.correct(board2,myStep);
			}
		}
	}
}
