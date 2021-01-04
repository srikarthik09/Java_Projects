
package jtexpo.double_pendulum;

import java.awt.*;
import javax.swing.*;  

public class Main {
    
    public static void main(String[] args) {
        // set the title of the screen to "Double Pendulum"
        JFrame frame = new JFrame("Double Pendulum");
        // close the frame when the close button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting the side of the frame to 600px by 600px
        frame.setSize(600, 600);
        // the frame will just appear with no refrence in placement
        frame.setLocationRelativeTo(null);
        // calling the PendulumCanvas with the following arguements
        // 6 : pendulum's to view
        // 0 : random first angle
        // 0 : random second angle
        frame.add(new PendulumCanvas(6,0.0,0.0));
        frame.setVisible(true);
    }
}  


class PendulumCanvas extends JComponent {
    //
    
    private int off_set_x = 300;
    private int off_set_y = 50;
    private int max_count = 6;
    
    private double gravity  = .981;
    
    private double[] len_1 = new double[max_count]; //200 is a good size
    private double[] len_2 = new double[max_count]; //200 is a good size
    
    private double[] mass_1 = new double[max_count]; //20 is a good size
    private double[] mass_2 = new double[max_count]; //20 is a good size
    
    private double[] angle_1 = new double[max_count]; //Math.PI*(Math.random()*2)
    private double[] angle_2 = new double[max_count]; //Math.PI*(Math.random()*2)
    
    private double[] vel_1 = new double[max_count];
    private double[] vel_2 = new double[max_count];
    
    private double[] acc_1 = new double[max_count];
    private double[] acc_2 = new double[max_count];
    
    private int pos_history[][][] = new int[max_count][200][2];
    private int index_draw = 0;
    
    private int count = 1;

    public PendulumCanvas(int c,double r1,double r2) {
        /*
        Parameters
        ----------
        c   : count of pendulums
        r1  : starting angle for the first rod
        r2  : starting angle for the second rod
        
        Outputs
        -------
        Prints and refreshes a window similution of the double pendulum
        */
        // we can not have a negative pendulum, the min is 1
        c = c > 0 ? c : 1;
        // if we have more requested then we do a use case, to set it to the max
        count = c < max_count ? c : max_count;
        // A for loop to set every element in the array set to 0
        for (int i = 0; i < pos_history.length; i++){
            for (int i2 = 0; i2 < pos_history[0].length; i2++){
                pos_history[i][i2][0] = 0;
                pos_history[i][i2][1] = 0;
            }
        }
        // Giving a uniformed distribution for all varibles
        for (int i = 0; i < len_1.length; i++){ len_1[i] = 200.0; }
        for (int i = 0; i < len_2.length; i++){ len_2[i] = 200.0; }
        for (int i = 0; i < mass_1.length; i++){ mass_1[i] = 20.0; }
        for (int i = 0; i < mass_2.length; i++){ mass_2[i] = 20.0; }
        for (int i = 0; i < vel_1.length; i++){ vel_1[i] = 0.0; }
        for (int i = 0; i < vel_2.length; i++){ vel_2[i] = 0.0; }
        for (int i = 0; i < acc_1.length; i++){ acc_1[i] = 0.0; }
        for (int i = 0; i < acc_2.length; i++){ acc_2[i] = 0.0; }
        // Giving an almost uniformed distribution to all angles
        // The initial starting points are random, and the pendulums are 
        // All spaced with a stagering of .01
        double a_1 = r1 != 0 ? r1 : Math.PI*(Math.random()*2);
        double a_2 = r2 != 0 ? r2 : Math.PI*(Math.random()*2);
        double stager = 0.01;
        for (int i = 0; i < angle_1.length; i++){
            angle_1[i] = a_1 + stager*i;
            angle_2[i] = a_2 + stager*i;
        }
        // Craeting a thread to start the animation
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // repaint clears the entire canvas
                    repaint();
                    // update the canvas ever .20 seconds
                    try {Thread.sleep(20);} catch (Exception ex) {}
                }
            }
        });
        // running the thread
        animationThread.start();
    }

    // paint component is the method that Java awt calls which is how we can get the graphics to show
    public void paintComponent(Graphics g) {
        // casting the initial graphics varible to be 2D
        Graphics2D gg = (Graphics2D) g;         
        // a for loop to generate each pendulum that is requested. 
        // It count downs that way black is always on the forground
        for (int index = count-1; index >= 0; index--){
            // a switch statement to change the color of the pendulum
            switch(index){
                case 0:
                    gg.setColor(Color.BLACK);
                    break;
                case 1:
                    gg.setColor(Color.RED);
                    break;
                case 2:
                    gg.setColor(Color.BLUE);
                    break;
                case 3:
                    gg.setColor(Color.ORANGE);
                    break;
                case 4:
                    gg.setColor(Color.MAGENTA);
                    break;
                case 5:
                    gg.setColor(Color.GRAY);
                    break;
            }
            // get the X and Y of where the rod is to end at
            double rod_ball_1_x = len_1[index] * Math.sin(angle_1[index]);
            double rod_ball_1_y = len_1[index] * Math.cos(angle_1[index]);
            // drawing a line from the offset to the X and Y obtained above
            gg.drawLine(
                    off_set_x, 
                    off_set_y, 
                    off_set_x + (int)rod_ball_1_x, 
                    off_set_y + (int)rod_ball_1_y
            );
            // placing the oval around the tip of the line
            gg.fillOval(
                    off_set_x + (int)rod_ball_1_x - (int)(mass_1[index]/2), 
                    off_set_y + (int)rod_ball_1_y - (int)(mass_1[index]/2),
                    (int)mass_1[index], 
                    (int)mass_1[index]
            );
            // doing the same as above, but with the line attached to the first line
            double rod_ball_2_x = len_2[index] * Math.sin(angle_2[index]);
            double rod_ball_2_y = len_2[index] * Math.cos(angle_2[index]);
            gg.drawLine(
                    off_set_x + (int)rod_ball_1_x, 
                    off_set_y + (int)rod_ball_1_y, 
                    off_set_x + (int)rod_ball_1_x + (int)rod_ball_2_x, 
                    off_set_y + (int)rod_ball_1_y + (int)rod_ball_2_y
            );
            gg.fillOval(
                    off_set_x + (int)rod_ball_1_x + (int)rod_ball_2_x - (int)(mass_2[index]/2), 
                    off_set_y + (int)rod_ball_1_y + (int)rod_ball_2_y - (int)(mass_2[index]/2),
                    (int)mass_2[index], 
                    (int)mass_2[index]
            );
            // drawing the dots to place out the history that the pendulum was in
            for (int i = 0; i < pos_history[0].length; i++){
                gg.fillOval(pos_history[index][i][0],pos_history[index][i][1],3,3);
            }
            // adding the current X and Y to the history list
            pos_history[index][index_draw][0] = off_set_x + (int)rod_ball_1_x + (int)rod_ball_2_x - (int)(mass_2[index]/2);
            pos_history[index][index_draw][1] = off_set_y + (int)rod_ball_1_y + (int)rod_ball_2_y - (int)(mass_2[index]/2);
            // to increment the drawl counter by 1 only when everything is done
            if (index == 0){
                index_draw = index_draw == (pos_history[0].length - 1) ? 0 : index_draw+1;
            }
            // the math equation provided by https://www.myphysicslab.com/pendulum/double-pendulum-en.html
            // was too long, and I tried to make the code as readable as possible by breaking it up into parts
            double part_1 = -1 * gravity * (2 * mass_1[index] + mass_2[index] ) * Math.sin(angle_1[index]);
            double part_2 = -1 * mass_2[index] * gravity * Math.sin(angle_1[index] - 2 * angle_2[index]);
            double part_3 = -2 * Math.sin(angle_1[index] - angle_2[index]) * mass_2[index];
            double part_4 = vel_2[index] * vel_2[index] * len_2[index] + vel_1[index] * vel_1[index] * len_1[index] * Math.cos(angle_1[index]-angle_2[index]);
            double part_5 = part_1 + part_2 + part_3 * part_4;
            double part_6 = len_1[index] * ( 2 * mass_1[index] + mass_2[index] - mass_2[index] * Math.cos(2 * angle_1[index] - 2 * angle_2[index]));
            // setting the pendulum's acceleration equal to what the website told me to
            acc_1[index] = part_5 / part_6;
            // the parts all chopped up for the second equation
            part_1 = 2 * Math.sin(angle_1[index] - angle_2[index]);
            part_2 = vel_1[index] * vel_1[index] * len_1[index] *(mass_1[index] + mass_2[index]);
            part_3 = gravity * (mass_1[index] + mass_2[index]) * Math.cos(angle_1[index]);
            part_4 = vel_2[index] * vel_2[index] * len_2[index] * mass_2[index] * Math.cos(angle_1[index] - angle_2[index]);
            part_5 = part_1 * (part_2 + part_3 + part_4);
            part_6 = len_2[index] * ( 2 * mass_1[index] + mass_2[index] - mass_2[index] * Math.cos(2 * angle_1[index] - 2 * angle_2[index]));
            // setting the second pendulum's acceleration equal to what the website told me to
            acc_2[index] = part_5 / part_6;
            // adding the acceletation to the velocity 
            vel_1[index] += acc_1[index];
            vel_2[index] += acc_2[index];
            // without this modifier the simulation goes on forever
            // this is a dampener
            vel_1[index] *= .999;
            vel_2[index] *= .999;
            // adding the velocity to the position
            angle_1[index] += vel_1[index];
            angle_2[index] += vel_2[index];
        }
    }

}