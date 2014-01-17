package states;

import main.Grammar;
import main.StarterClass;

public class AnonymousVariableState implements State {
	public boolean isSingleSymbol = true;
	@Override
	public State check(char c) {
		if(Grammar.isDelemiter(c)){
			return  StarterClass.delimiterState;	
		}else{
			return StarterClass.errorState;
		}
	}

}
