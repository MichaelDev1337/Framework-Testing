package io.github.michaeldev1337;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameWork {

    // Method to display the splash screen
    public void showFrameWork() {
        // Create a JFrame (window)
        JFrame frameWork = new JFrame("Simple FrameWork");

        // Set the window size and close operation
        frameWork.setSize(1680, 1080);
        frameWork.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWork.setLocationRelativeTo(null); // Center the window on the screen

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Using null layout to manually position components

        // Add a simple label to the frame
        JLabel label = new JLabel("Welcome to My Framework!", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);

        // Add the animated panel with the image path to the frame
        ImagePanel animatedPanel = new ImagePanel("images/growling-husk.gif");

        // Add the panel to the frame
        frameWork.add(panel, BorderLayout.NORTH);
        frameWork.add(animatedPanel, BorderLayout.CENTER);
        // Make the window visible
        frameWork.setVisible(true);
    }
}