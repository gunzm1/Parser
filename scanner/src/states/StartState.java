package states;

import main.Grammar;
import main.StarterClass;

public class StartState implements State {

	@Override
	public State check(char c) {
		if(Grammar.isComment(c)) {	
			return StarterClass.commentState;
			
		}
		else if(Grammar.isVariable(c)){
			return  StarterClass.variableState;	
		}
		else if(Grammar.isConstant(c)){
			return  StarterClass.constantState;		
		}
		else if(Grammar.isDelemiter(c)){
			return  StarterClass.delimiterState;		
		}
		else{
			return StarterClass.errorState;	
		}
	}

}
