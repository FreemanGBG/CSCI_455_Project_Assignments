// Name: Yuxiang Wang
// USC NetID: 6707470120
// CSCI455 PA2
// Fall 2018

import java.util.Scanner;
import java.util.ArrayList;

/**
   <add main program comment here>
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
	  Scanner in = new Scanner(System.in);
      SolitaireBoard board = userMode(userConfig, in);
	  stopMode(singleStep, in, board);
   }
   
   public static SolitaireBoard userMode(boolean userConfig, Scanner in) {
	  if (userConfig) { 
		 System.out.println("Number of total cards is 45");
         System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
		 ArrayList<Integer> intArr = pilesArray(in);
	     return new SolitaireBoard(intArr);
	  } else {
         return new SolitaireBoard();	  	  
	  }
	   
   }
   
   public static void stopMode(boolean singleStep, Scanner in, SolitaireBoard board) {
	  System.out.println("Initial configuration: " + board.configString());
	  int count = 0;
	  while (!board.isDone()) {
	     board.playRound();
         count++;
         System.out.println("[" + count + "] Current configuration: " + board.configString());
         if (singleStep) {
            System.out.print("<Type return to continue>");
         }
		 while(singleStep) {
		    if (in.hasNextLine()) {
               in.nextLine();
			   break;	
			}	 
		 }
	  }
	  System.out.println("Done!"); 
   }
   
   public static ArrayList<Integer> pilesArray(Scanner in) {
	  boolean errOccur = true;
	  ArrayList<Integer> intArr = new ArrayList<Integer>();
	  while (errOccur) {
		 System.out.println("Please enter a space-separated list of positive integers followed by newline:");
		 String inStr = in.nextLine();
		 Scanner inLine = new Scanner(inStr);
		 intArr = new ArrayList<Integer>();
		 while (inLine.hasNextInt()){
		    intArr.add(inLine.nextInt());
		 }
		 errOccur = errorChecking(inStr);
		 if (errOccur) {
		    System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
		 }
	  }
	  return intArr;
   }
   
   public static boolean errorChecking(String inStr) {
	  boolean res = true;
	  Scanner inLine = new Scanner(inStr); 
	  int temp = 0;
      int sum = 0;
	  while (inLine.hasNextInt()){
		 temp = inLine.nextInt();
         if (temp <= 0) {
		    return res;			   
	     }
	     sum += temp;
	  }
	  if (inLine.hasNext()){
		 return res;	
	  }
	  if (sum == SolitaireBoard.CARD_TOTAL) {
         res = false; 
	  }
	  return res;
   }
   
   
  
}
