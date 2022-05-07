/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */

class Slice {
   double value;
   Color color;
   public Slice(double value, Color color) {  
      this.value = value;
      this.color = color;
   }
}
class MyComponent extends JComponent {
   Slice[] slices = new Slice[3];
   public MyComponent(Slice[] slices) {
       this.slices = slices; 
   }
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
   void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
      double total = 0.0D;
      g.clearRect(0, 0, this.getWidth(), this.getHeight());
      
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
         curValue += slices[i].value;
         
         ImageIcon imageicon = new ImageIcon("C:/Users/HP/Documents/NetBeansProjects/DSProject/src/dsproject/pielabel.png");
         g.drawImage(imageicon.getImage(), 0, 0,imageicon.getIconWidth()/2,imageicon.getIconHeight()/2, null);
      }
   }
}