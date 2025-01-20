package io.github.michaeldev1337;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private final ImageIcon imageIcon;
    private boolean imageDimensionsLogged = false;

    public ImagePanel(String imagePath) {
        // Enable double buffering to prevent tearing and flicker
        setDoubleBuffered(true);

        this.imageIcon = loadImageFromResources(imagePath);
        if (imageIcon != null) {
            // Set preferred size based on the loaded image's dimensions
            int imageWidth = imageIcon.getIconWidth();
            int imageHeight = imageIcon.getIconHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                setPreferredSize(new Dimension(imageWidth, imageHeight));
            } else {
                System.err.println("Failed to determine image dimensions.");
            }
        } else {
            System.err.println("Failed to load image: " + imagePath);
        }
    }

    // Method to load image using ImageIcon
    private ImageIcon loadImageFromResources(String imagePath) {
        // Load the image from the resources folder
        java.net.URL imageUrl = getClass().getClassLoader().getResource(imagePath);
        if (imageUrl != null) {
            try {
                System.out.println("Image URL: " + imageUrl);  // Print the URL for debugging
                return new ImageIcon(imageUrl);
            } catch (Exception e) {
                System.err.println("Error reading image: " + e.getMessage());
            }
        } else {
            System.err.println("Image not found: " + imagePath);
        }
        return null;  // Return null if not found
    }

    

    // Paint the component with the image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imageIcon != null) {
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();

            // Debugging output
            if (!imageDimensionsLogged) {
                System.out.println("Image dimensions: " + originalWidth + "x" + originalHeight);
                imageDimensionsLogged = true;
            }
            // Get the panel's width and height
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate the position to center the image in the panel
            int x = (panelWidth - originalWidth) / 2;
            int y = (panelHeight - originalHeight) / 2;

            // Paint the image at the calculated position
            imageIcon.paintIcon(this, g, x, y);
        } else {
            System.err.println("Image is null, nothing to draw.");
        }
    }
}