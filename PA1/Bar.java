// Name: Yuxiang Wang	
// USC NetID: 6707470120
// CS 455 PA1
// Fall 2018

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   
   private int barBottom;
   private int barLeft;
   private int barWidth;
   private int barHeight;
   private double barScale;
   private Color barColor;
   private String barLabel;
   
   public Bar(int bottom, int left, int width, int height,
              double scale, Color color, String label) {
		barBottom = bottom;
		barLeft = left;
		barWidth = width;
		barHeight = height;
		barScale = scale;
		barColor = color;
		barLabel = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(barLabel, context);
		double widthOfLabel = labelBounds.getWidth();
		double heightOfLabel = labelBounds.getHeight();
		g2.setColor(barColor);
		Rectangle body = new Rectangle(barLeft, barBottom - (int)Math.round(barHeight * barScale) - (int)heightOfLabel, 
		barWidth, (int)Math.round(barHeight * barScale));                           // height of each bar is the product  
		g2.fill(body);                                                              // of bar height in appication unit and scale
		
		int centerX = barLeft + (int)(barWidth / 2);
		int baselineY = barBottom;
		
		g2.draw(body);
		g2.drawString(barLabel, centerX - (int)(widthOfLabel / 2), baselineY);      // center the text under the bar
		
   }
}
