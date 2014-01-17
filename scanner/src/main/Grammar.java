package main;

import java.util.ArrayList;

public final class  Grammar {
	private static ArrayList<Character>delimiter = new ArrayList<Character>();	
	private static ArrayList<Character>variable = new ArrayList<Character>();
	private static ArrayList<Character>constant = new ArrayList<Character>();	
	
	public Grammar(){

	}

	private static void fillDelimiter(){
		delimiter.add(',');
		delimiter.add(';');
		delimiter.add('.');
		delimiter.add('(');
		delimiter.add(')');
		delimiter.add('[');
		delimiter.add(']');
		delimiter.add('|');
		delimiter.add('!');			
	}

	private static void fillVariableStarter(){
		for(char a = 'A', z = 'Z'; a < z; a++) {
			variable.add(a);
	      }		
	}
	private static void fillConstantStarter(){
		for(char a = 'a', z = 'z'; a < z; a++) {			
			constant.add(a);
	      }			
	}
	public static void fillAll(){
		fillDelimiter();
		fillVariableStarter();
		fillConstantStarter();		
	}
	
	public static  boolean isComment(Character c){
		if (c.equals('%')){
			return true;
		}
		else if(StarterClass.currentState == StarterClass.commentState){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isColon(Character c){
		if (c.equals(':')){
			return true;
		}
		return false;
	}
	public static boolean isDash(Character c){
		if (c.equals('-')){
			return true;
		}
		return false;
	}
	
	public static  boolean isString(Character c){
		if (c.equals('\'')){
			return true;
		}
//		else if(StarterClass.currentState == StarterClass.stringState){
//			return true;
//		}
		else{
			return false;
		}
	}
	
	public static boolean isVariable(Character c){
		for(Character element:variable){
			if (c.equals(element)){
				return true;
			}
		}
		 if(StarterClass.currentState == StarterClass.variableState){
			if(!isComment(c)){
				return true;
			}else if(!isDelemiter(c)){
				return true;
			}
		}		
		return false;
	}
	public static boolean isConstant(Character c){
		for(Character element:constant){
			if (c.equals(element)){
				return true;
			}
		}
		if(StarterClass.currentState == StarterClass.constantState){
			if(!isComment(c)){
				return true;
			}else if(!isDelemiter(c)){
				return true;
			}
		}		
		return false;
	}
	public static boolean istAnonymousVariable(Character c){
		if (StarterClass.currentState.equals(StarterClass.delimiterState)){
			if(c.equals('_')){
				return true;
			}
		}
		return false;
	}
	public static boolean isDelemiter(Character c){
		for(Character element:delimiter){
			if(c.equals(element))return true;
		}
		return false;
	}
	
	public static boolean changeToken(){
		// wenn Status wechselt, Token in Tokenliste verschieben und currentToken Leeren
		// -> neues Token beginnt		
		if (!StarterClass.currentState.equals(StarterClass.runningState) 
				&& (!StarterClass.runningState.equals(StarterClass.startState)) 
				&& (!StarterClass.runningState.equals(StarterClass.commentState)) 
				&& (!StarterClass.runningState.equals(StarterClass.colonState)) 
				&& (!StarterClass.runningState.equals(StarterClass.stringState)) ) {
			return true;										
		}else if(StarterClass.runningState.equals(StarterClass.delimiterState)|| StarterClass.runningState.equals(StarterClass.anonymVariableState)){
			return true;
		}else if(StarterClass.runningState.equals(StarterClass.startState) && StarterClass.lastIsColon){
			StarterClass.lastIsColon = false;
			return true;
		}
		return false;
	}
	

}
