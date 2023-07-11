package Tess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShadowPanelExample extends JPanel {

    private final int shadowSize = 10; // Kích thước bóng đổ

    public ShadowPanelExample() {
        setPreferredSize(new Dimension(200, 200));
        setBorder(BorderFactory.createEmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Vẽ nền trắng cho JPanel
        g.setColor(Color.WHITE);
        g.fillRect(shadowSize, shadowSize, getWidth() - 2 * shadowSize, getHeight() - 2 * shadowSize);

        // Vẽ bóng đổ
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        g2d.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, 10, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shadow Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.add(new ShadowPanelExample());

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
