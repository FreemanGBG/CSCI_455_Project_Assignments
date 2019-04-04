// Name: Yuxiang Wang  
// USC NetID: 6707470120  
// CS 455 PA1  
// Fall 2018  
  
//   
/**
 * CoinTossSimulatorTester class
 * A tester for the CoinTossSimulator class
 * It tests the full functionality of the CoinTossSimulator class,
 * including the constructor, getTwoHeads(), getTwoTails(), getHeadTails(), reset().
 */
public class CoinTossSimulatorTester {  
   /**
      Test cases:
	  After constructor; after running different numbers of trials; 
	  after reset; after running another different numbers of trials;
   */
   public static void main(String[] args) {  
      CoinTossSimulator toss1 = new CoinTossSimulator();  
      System.out.println("After constructor:");  
      Tester(toss1, 0);  
      System.out.println("After run(1):");  
      Tester(toss1, 1);  
      System.out.println("After run(10):");  
      Tester(toss1, 10);  
      System.out.println("After run(100):");  
      Tester(toss1, 100);  
      System.out.println("After reset:");  
      toss1.reset();  
      Tester(toss1, 0);  
      System.out.println("After run(1000):");  
      Tester(toss1, 1000);  
   }  
   
   /**
      Run simulator with different input to do the test;
	  prints the result to the console;
	  compares the results with expected outputs
	  
      @param toss  the running simulator 
	  @param num   the number of trials for running this time
	  
	  Invariant: expected output = number of trials for running this time 
	                             + number of previous trials
	                             = num + prevNum
   */
   public static void Tester(CoinTossSimulator toss, int num){  
      int prevNum = toss.getNumTrials();  
      toss.run(num);  
      System.out.println("Number of trials [exp:" + (num + prevNum) + "]: " + toss.getNumTrials());  
      System.out.println("Two-head tosses: " + toss.getTwoHeads());  
      System.out.println("Two-tail tosses: " + toss.getTwoTails());  
      System.out.println("One-head one-tail tosses: " + toss.getHeadTails());  
      System.out.print("Tosses add up correctly? ");  
      int sum = toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails();  
      System.out.println(sum == toss.getNumTrials());  
      System.out.println();  
   }  
}  