package states;

import main.StarterClass;


public class CommentState implements State {

	@Override
	public State check(char c) {
		// CommentState bleibt immer, 
		// bei Zeilenumbruch wird in StarterClasse Status in StartStatus gesetzt
		return StarterClass.commentState;
	}

}
