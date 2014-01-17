package states;

import main.Grammar;
import main.StarterClass;

public class DelimiterState implements State {
	public boolean isSingleSymbol = true;
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

		else if(Grammar.isColon(c)){
			return  StarterClass.colonState;	
			
		}
		else if(Grammar.isDelemiter(c)){
			return  StarterClass.delimiterState;	
			
		}
		else if(Grammar.istAnonymousVariable(c)){
			return  StarterClass.anonymVariableState;
		}
		else if(Grammar.isString(c)){
			return StarterClass.stringState;
		}		
		else{
			return StarterClass.errorState;
		}

	}

}
