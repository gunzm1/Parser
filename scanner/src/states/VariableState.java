package states;

import main.Grammar;
import main.StarterClass;

public class VariableState implements State {

	@Override
	public State check(char c) {

		if(Grammar.isDelemiter(c)){
			return StarterClass.delimiterState;
		}
		else if(Grammar.isComment(c)) {
			return StarterClass.commentState;
		}
		else if(Grammar.isColon(c)){
			return StarterClass.colonState;	
		}
		else if(Grammar.isVariable(c)){
			return StarterClass.variableState;	
		}
		else{
			return StarterClass.errorState;
		}
		
		
	}

}
