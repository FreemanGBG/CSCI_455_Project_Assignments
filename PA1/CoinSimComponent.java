// Name: Yuxiang Wang
// USC NetID: 6707470120
// CS 455 PA1
// Fall 2018

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


/**
   class CoinSimComponent
   Draws three bars which represent data for two heads, a head and a tail,
   two tails. 
*/
public class CoinSimComponent extends JComponent
{     
   private static final int WIDTH = 50; 
   private static final int VERTICALBUFFER = 20; 
   private static final double PERCENT = 100.0;
   private static final Color TWO_HEAD_COLOR = Color.RED;
   private static final Color TWO_TAIL_COLOR = Color.BLUE;
   private static final Color HEAD_TAIL_COLOR = Color.BLACK;
   private int numTrial;
   
   /**
      Create a component after given number of trials, set field numTrial as input
	  
	  @param num   number of trials for simulations
   */
   public CoinSimComponent(int num){
      numTrial = num;
   }

   
   /**
      Paint the component with running simulator of given number of trials.
	  In detail, draw three labeled bar in different color. Bar height is directly proportional
	  to the output. Labels indicates the number of each outputs and relevant ratio
	  @param g   the graphics context
   */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
	  Font font = g2.getFont();											// get label height for scale 
      FontRenderContext context = g2.getFontRenderContext();			// and bar bottom position calculation
      Rectangle2D labelBounds = font.getStringBounds("Test", context);
      double heightOfLabel = labelBounds.getHeight();
		
	  CoinTossSimulator toss1 = new CoinTossSimulator();				// construct the simulator and run with
	  toss1.run(numTrial);												// given number of trials
	  int numTwoHeads = toss1.getTwoHeads();							// get each output and do computation for 
	  int numTwoTails = toss1.getTwoTails();							// bar height and the data in label
	  int numHeadTails = toss1.getHeadTails();
	  int heightTwoHeads = (int)Math.round(numTwoHeads * PERCENT / numTrial);
	  int heightTwoTails = (int)Math.round(numTwoTails * PERCENT / numTrial);
	  int heightHeadTails = (int)Math.round(numHeadTails * PERCENT / numTrial);
	  
	  int x1 = getWidth() / 4 - WIDTH / 2;								// the bars stand at a quarter, a half and three quarter
	  int x2 = getWidth() / 2 - WIDTH / 2;								// of the width
	  int x3 = 3 * getWidth() / 4 - WIDTH / 2;
      int y = getHeight() - VERTICALBUFFER;
	  double scale = (getHeight() - 2 * VERTICALBUFFER - heightOfLabel) / 100.0;
	  
	  
	  String labelTwoHeads = "Two Heads: " + numTwoHeads + " (" + heightTwoHeads + "%)";
	  String labelTwoTails = "Two Tails: " + numTwoTails + " (" + heightTwoTails + "%)";
	  String labelHeadTails = "a Head and a Tail: " + numHeadTails + " (" + heightHeadTails + "%)";
	  
	  Bar barTwoHeads = new Bar(y, x1, WIDTH, heightTwoHeads, scale, TWO_HEAD_COLOR, labelTwoHeads);
      Bar barHeadTails = new Bar(y, x2, WIDTH, heightHeadTails, scale, HEAD_TAIL_COLOR, labelHeadTails);
      Bar barTwoTails = new Bar(y, x3, WIDTH, heightTwoTails, scale, TWO_TAIL_COLOR, labelTwoTails);

      barTwoHeads.draw(g2);
      barHeadTails.draw(g2);
      barTwoTails.draw(g2);
   }
}
