package states;

import main.Grammar;
import main.StarterClass;

public class ColonState implements State{
	@Override
	public State check(char c) {
		// TODO Auto-generated method stub
		if(Grammar.isDash(c)){
			StarterClass.lastIsColon = true;
			return StarterClass.startState;			
		}
		return StarterClass.errorState;
	}

}
