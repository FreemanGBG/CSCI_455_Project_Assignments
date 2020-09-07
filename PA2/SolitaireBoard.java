// Name: Yuxiang Wang
// USC NetID: 6707470120
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;


/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
      Representation invariant:

      <put rep. invar. comment here>

   */
   
   // <add instance variables here>
   private int[] piles = new int[CARD_TOTAL];
   private int numPiles;
   
 
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      for (int i=0; i < piles.size(); i++) {
         this.piles[i] = piles.get(i);
      }
	  numPiles = piles.size();
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      Random rand = new Random();
	  int sum = CARD_TOTAL;
	  int randomInt;
	  int count = 0;
	  while (sum != 0) {
		 randomInt = rand.nextInt(sum + 1); 
		 if (randomInt != 0) {
            piles[count] = randomInt; 
		    sum = sum - randomInt;
		    count++;
		 }
	  }
	  numPiles = count;
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {
      int newPile = numPiles;
	  for (int i = 0; i < numPiles; i++){
	  	 piles[i] -= 1;
      }
      int count = 0;
      while (count < numPiles) {
		 if (piles[count] == 0) {
			for (int i = count + 1; i <= newPile ; i++ ) {
               piles[i - 1] = piles[i];
            }
            numPiles--;
         } else {
            count++;
         }
      }
	  piles[numPiles] = newPile; 
      numPiles++;
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
   */
   
   public boolean isDone() {
	  if (numPiles != NUM_FINAL_PILES) {
         return false;
      }
	  int[] res = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
	  res = Arrays.copyOf(res, CARD_TOTAL);
	  int[] copy = piles.clone();
	  Arrays.sort(copy, 0, NUM_FINAL_PILES); 
      //System.out.println(Arrays.toString(copy));
      if (Arrays.equals(res, copy)) {
		 return true; 
	  }
      return false;
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {
	  String res = "" + piles[0];
      for (int i = 1; i < numPiles; i++){
         res += " " + piles[i];
      }
      return res;
   }
   
   /**
      Returns current board configuration as a string with the format of
      a comma-separated list of numbers with bracket.
      The numbers represent the number of cards in each non-empty pile.
	  Used for error checking.
   */
   public String toString() {
      return Arrays.toString(piles);
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      int sum = 0;
	  for (int i = 0; i < numPiles; i++) {
		  sum += piles[i];
	  }
	  if (sum == CARD_TOTAL) {
         return true;  // dummy code to get stub to compile
      }
	  return false;
   }
   

   // <add any additional private methods here>
   
   //from Names.java
   private boolean remove(int target) {
      for (int i = target + 1; i < numPiles ; i++  ) {
         piles[ i - 1 ] = piles[ i ];
      }
      numPiles--;
      return true;
   }
}

