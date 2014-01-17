package states;

import main.StarterClass;

public class ErrorState implements State{

	@Override
	public State check(char c) {
		return StarterClass.startState;
	}

}
