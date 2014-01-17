package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import states.*;

public class StarterClass {
	public static State currentState;
	public static State runningState;
	public static StartState startState;
	public static CommentState commentState;
	public static VariableState variableState;
	public static AnonymousVariableState anonymVariableState;
	public static ConstantState constantState;
	public static DelimiterState delimiterState;
	public static StringState stringState;
	public static ColonState colonState;
	public static ErrorState errorState;
	public static ArrayList<String> TokenList;
	public static String currentToken;
	public static boolean lastIsColon;
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		initialize();
		Grammar.fillAll();
		try {
			String fileName = "prologMoodle.pl";
			if(args.length>0 ){
				fileName = args[0];
			}
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String text = null;
			int lineNumber = 1;
			try {
				while((text = in.readLine()) != null){
					for(int i = 0; i<text.length(); i++){
							text = text.trim();
							if(text.length()>0){
								Character c = text.charAt(i);								
								if(!Character.isWhitespace(c) || currentState.equals(StarterClass.commentState)){
									currentState = currentState.check(c);
									if (currentState.equals(StarterClass.errorState)){
										String msg = "Error Parsing prolog file; invalid syntax? LineNumber: " + lineNumber;
										System.out.println(msg);
										TokenList.add(msg);
									}
									if(Grammar.changeToken()){
										TokenList.add(currentToken);							
										currentToken = Character.toString(c);	
									}else{
										currentToken += Character.toString(c);								
									}
									runningState = currentState;																	
								}					
							}
					}
					lineNumber++;
					// wenn der Aktuelle Status am ende einer Zeile ein Kommentar ist
					// gesamte Zeile also currentToken in TokenList verschieben und
					// ThisState in StartState zurück setzten					
					if(currentState.equals(commentState)){
						currentToken = "";	
						currentState = startState;
					}						
				}
				//TODO: ausgeben aller Elemente von TokenList in ein Outputfile
				PrintWriter out = new PrintWriter(new FileWriter("output.txt"));				
				for(String token:TokenList){
					out.println(token);
				     // out.append(token + "\n");			
				}
			    out.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// inizialisierung aller Variablen
	public static void initialize(){
		startState = new StartState();
		commentState = new CommentState();
		variableState = new VariableState();
		anonymVariableState = new AnonymousVariableState();
		constantState = new ConstantState();
		delimiterState = new DelimiterState();	
		stringState = new StringState();
		errorState = new ErrorState();
		colonState = new ColonState();
		
		currentState =  startState;
		runningState = currentState;
		
		TokenList = new ArrayList<String>();
		currentToken = "";
		lastIsColon = false;
	}

}
