// Name: Yuxiang Wang
// USC NetID: 6707470120
// CS 455 PA1
// Fall 2018

import javax.swing.JFrame;
import java.util.Scanner;

/**
   class CoinSimViewer
   Builds the viewer frame and adds the coin simulation component
   so that the users could see results in a graphical way
   
*/
public class CoinSimViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(800, 500);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  int numTrial = 0;
	  while (true) {
         System.out.print("Enter number of trials: ");		// Check the scanned input integer
         Scanner in = new Scanner(System.in);				// report error if the input is not
         numTrial = in.nextInt();							// valid, and ask for another input if invalid
         if (numTrial <= 0) {
			 System.out.println("ERROR: Number entered must be greater than 0.");
		 } else {
			 break;
		 }		 
	  }
      CoinSimComponent component = new CoinSimComponent(numTrial);
      frame.add(component);
      frame.setVisible(true);
   }
}
