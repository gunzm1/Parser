package states;

import main.Grammar;
import main.StarterClass;

public class StringState implements State {

	@Override
	public State check(char c) {
		if(!Grammar.isString(c)){
			return  StarterClass.stringState;
		}else{
			return  StarterClass.delimiterState;
		}
	}

}
