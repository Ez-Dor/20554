package Mmn11.Q2;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class PaintRunFile {

    public static void main(String[] args) {
        final int WIDTH = 600,
                HEIGHT = 600,
                REPAINT=0;
         /**
          * Get the "n" ovals from the user..
          * */
        int ovals = Integer.parseInt(JOptionPane.showInputDialog("How many ovals do you want to paint?"));

        JFrame jframe = new JFrame();
        Paint paint = new Paint(ovals);
        /**
         * Prepare the panel to show..
         * */
        jframe.add(paint);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);

        /**
         * The repaint loop according to the instructions..
         * */
        int toRepaint = REPAINT;
        while (toRepaint == REPAINT) {
            toRepaint  = JOptionPane.showConfirmDialog(null, "Do you want to repaint?");
            if (toRepaint == REPAINT) {
                paint.repaint();
            }
        }
    }
}
