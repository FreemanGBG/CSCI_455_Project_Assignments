// Name: Yuxiang Wang
// USC NetID: 6707470120
// CS 455 PA1
// Fall 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;

public class CoinTossSimulator {

   private int num;
   private int numTwoHeads;
   private int numTwoTails;
   private int numHeadTails; 

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      num = 0;
      numTwoHeads = 0;
      numTwoTails = 0;
      numHeadTails = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	  num += numTrials;
      int count = 0;
      Random coin = new Random();
      int result;
      while(count < numTrials){
         result = coin.nextInt(2) + coin.nextInt(2);
         if (result == 0){
            numTwoHeads++;
         } else if (result == 1) {
            numHeadTails++;
         } else {
            numTwoTails++;
         }
         count++;
      } 
   }

   
   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return num; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return numTwoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numTwoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return numHeadTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      num = 0;
      numTwoHeads = 0;
      numTwoTails = 0;
      numHeadTails = 0;
   }

}
