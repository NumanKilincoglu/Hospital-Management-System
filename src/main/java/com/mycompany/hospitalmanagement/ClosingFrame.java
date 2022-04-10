/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagement;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author numan.kilincoglu
 */
//THIS CLASS CREATE A GRAPHIC FRAME AFTER PATIENTGUI IS CLOSED. 
public class ClosingFrame extends JFrame implements ActionListener {

    JLabel lbl = new JLabel();
    Font font;

    public static void main(String[] args) {

        ClosingFrame frm = new ClosingFrame();

        frm.setLocationRelativeTo(null);

        frm.setVisible(true);

        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public ClosingFrame() {

        JPanel pnl = new JPanel();

        pnl.setLayout(new GridBagLayout());

        this.getContentPane().add(pnl);

        pnl.setBackground(BLACK);

        pnl.add(lbl);

        setTitle("CLOSE");

        setSize(600, 300);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        font = new Font("Times New Roman", Font.BOLD, 25);

        Timer timer = new Timer(3000, this);

        timer.start();

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5.f));
        g2d.setColor(black);
        g2d.fill(new Rectangle2D.Double(0, 0, 600, 300));

        g2d.setFont(font);
        g2d.setColor(blue);
        g2d.drawLine(20, 110, 580, 110);
        g2d.setColor(WHITE);
        g2d.drawString("Thank you for using this applicaton, have a great day", 20, 150);
        g2d.drawString("''ROYAL HOSPITAL''", 175, 185);
        g2d.setColor(blue);
        g2d.drawLine(175, 215, 425, 215);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        System.exit(0);
    }

}
