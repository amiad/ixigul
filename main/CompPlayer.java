package main;

public class CompPlayer extends Player{
	/**
	 * The level of computer player. probability to do best step (level*25%)
	 * In level 0, the computer player will play with only randomize possible step
	 * In level 4, the computer player will play with only best possible step calculated
	 */
	private int level;
	
	//get mark of player and the level of computer
	public CompPlayer(boolean m, int l) {
		super(m);
		level=l;
	}
	
	//get the board and do the next step of this player. the step is best step or random step by level
	public void step(Board board){
		int step = 0;
		int correct=(int) Math.random()*(4-level);
		if (correct==0) step=correct(board);
		else step=rndStep(board);
		board.setLocateValue(step, getGMark());
	}
	
	//return random step from the possible steps
	private int rndStep(Board board) {
		return board.getEmpty()[(int)(Math.random()*board.getEmpty().length)];
	}

	//return the best step
	private int correct(Board board) {
		int[]ans=correct(board,0,mark);
		System.out.println("answer="+ans[1]+"\n");
		return ans[0];
		//return correct(board,0,mark)[0];
	}

	/**
	 * @param board
	 * @param lastStep
	 * @param firstMark
	 * @return
	 */
	public int[] correct(Board board, int lastStep,boolean firstMark) {
		// answer is array of two int members:
		// (TODO)
		int[] answer={lastStep,-1};
		if ( ((board.getStatus()==3) & (!mark)) || ((board.getStatus()==2) & (mark)) ) { // I win
			answer[0]=lastStep;
			answer[1]=2;
			//System.out.println("111111111");
		}
		else if (board.getStatus()==1) { // Draw (teko)
			answer[0]=lastStep;
			answer[1]=1; 
		}
		else if ( ((board.getStatus()==3) & (mark)) || ((board.getStatus()==2) & (!mark)) ) { // I lose
			answer[0]=lastStep;
			answer[1]=0;
		}
		else { //the game not finished
			// other is CompPlayer object for ... (TODO)
			CompPlayer other=new CompPlayer(!mark, 4);
			for (int i=0;i<board.getEmpty().length;i++){
				// board2 is Board object for ... (TODO)
				// nextStep is int that hold ... (TODO)
				// myStep is int ... (TODO)
				Board board2=board.clone();
				int nextStep=board.getEmpty()[i];
				board2.setLocateValue(nextStep,getGMark());
				int myStep=lastStep;
				if (lastStep==0) myStep=nextStep;
				answer=betterStep(other.correct(board2,myStep,firstMark),answer,firstMark);
			} // for
		} // else
		return answer;
	} // correct function
	

	/**
	 * @param step1
	 * @param step2
	 * @param firstMark
	 * @return
	 */
	private int[] betterStep(int[] step1, int[] step2,boolean firstMark){
		if ((firstMark!=mark)&&(step2[1]!=-1)){
			step1[1]=step1[1]*-1;
			step2[1]=step2[1]*-1;
		}
		if (step1[1]<step2[1]) return step2;
		else return step1;
	}
}
