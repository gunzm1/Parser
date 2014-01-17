package states;

import main.Grammar;
import main.StarterClass;

public class ConstantState implements State {

	@Override
	public State check(char c) {
		if(Grammar.isDelemiter(c)){
			return StarterClass.delimiterState;
		}
		else if(Grammar.isComment(c)) {
			return StarterClass.commentState;
		}
		else if(Grammar.isConstant(c)) {
			return StarterClass.constantState;
		}		
		else if(Grammar.isColon(c)){
			return StarterClass.colonState;	
		}
		else{
			return StarterClass.errorState;
		}		
	}

}
