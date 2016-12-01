package Mmn11.Q2;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Paint extends JPanel {

    private int _numOfOvals;

    private final int WHITE = 0, GRAY = 1 , MAX_COLORS = 3;


    public Paint(int ovals) {
        super();
        _numOfOvals = ovals;
    }

    @Override
    /**
     * we overwrite the function to fill the panel with the random colors according to the instructions...
     * allways the attitude between the ovals stay n*n (see the conditions in the loops)
    * */
    public void paintComponent(Graphics g) {

        int ovalWidth = this.getWidth() / _numOfOvals,
                ovalHeight = this.getHeight() / _numOfOvals,
                length = this.getWidth() < this.getHeight() ? this.getWidth() : this.getHeight();

        super.paintComponent(g);

        for (int i = 0; i + ovalWidth <= length; i += ovalWidth) {
            for (int j = 0; j + ovalHeight <= length; j += ovalHeight) {
                g.setColor(getRandomColor_WGB());
                g.fillOval(i, j, ovalWidth, ovalHeight);
            }
        }

    }

    /**
     * Returns a random color between white gray and black
     * */
    private Color getRandomColor_WGB() {
        Random rand = new Random();
        switch (rand.nextInt(MAX_COLORS)) {
            case WHITE:
                return Color.white;
            case GRAY:
                return Color.gray;
            default:
                return Color.black;
        }
    }
}
