
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CandyDispenser extends JPanel {
    private static Stack stack;
    private static JFrame frame;

    public CandyDispenser() {
        stack = new Stack();
    }

    public void paintComponent(Graphics g) {
        g.drawRect(20, 20, 100, 180);
        if (!stack.isEmpty()) {
            int count = stack.countStack();
            for (int i = 0; i < count; i++) {
                g.setColor(Color.DARK_GRAY);
                g.fillOval(20, (i * 30) + 20, 100, 30);
                String text = "c" + (count - i);
                g.setColor(Color.white);
                g.drawString(text, 65, ((i * 30) + 40));
            }
        }
        // spring
        int candyHeight = 20 + stack.countStack() * 30;

        while (candyHeight < 180) {
            g.setColor(Color.lightGray);
            int height = 180 - candyHeight;
            for (int i = 1; i <= 5; i++) {
                g.drawLine(20, candyHeight, 120, candyHeight);
                candyHeight += height / 5;
                g.drawLine(20, candyHeight - (height / 5), 120, candyHeight);
                g.drawLine(20, candyHeight, 120, candyHeight);
            }
        }
    }

    // Create the window.
    public static void main(String args[]) {
        frame = new JFrame("GUI for Stack Candy Dispenser");
        frame.setSize(700, 400);
        JPanel panel = new CandyDispenser();
        panel.setSize(700, 400);

        JLabel title = new JLabel("Stack (Dispenser) Operations");
        title.setBounds(200, 0, 300, 30);

        JLabel msg = new JLabel();
        msg.setBounds(400, 20, 300, 30);

        JButton size = new JButton("size()");

        size.setBounds(200, 30, 100, 30);
        size.setBackground(Color.CYAN);

        size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msg.setText("Stack Size = " + stack.countStack());
            }
        });
        JButton push = new JButton("push()");
        push.setBounds(200, 70, 100, 30);
        push.setBackground(Color.CYAN);

        push.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isFull()) {
                    msg.setText("Stack is full");
                } else {
                    stack.push();
                    frame.repaint();
                }
            }
        });
        JButton pop = new JButton("pop()");
        pop.setBounds(200, 110, 100, 30);
        pop.setBackground(Color.CYAN);
        pop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    msg.setText("Stack is empty");
                } else {
                    stack.pop();
                    frame.repaint();
                }
            }
        });
        JButton top = new JButton("peek()");
        top.setBounds(200, 150, 100, 30);
        top.setBackground(Color.CYAN);
        top.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    msg.setText("Stack is empty");
                } else {
                    msg.setText("Top = c" + stack.countStack());
                }
            }
        });

        JButton isEmpty = new JButton("IsEmpty()");
        isEmpty.setBounds(200, 190, 100, 30);
        isEmpty.setBackground(Color.CYAN);

        isEmpty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    msg.setText("True");
                } else {
                    msg.setText("False");
                }
            }
        });
        // Add the msg label
        frame.add(msg);
        frame.add(title);
        // add action buttons to the frame
        frame.add(size);
        frame.add(push);
        frame.add(pop);
        frame.add(top);
        frame.add(isEmpty);
        // Added the JPanel isntance
        frame.add(panel);
        // Display the JFrame
        frame.setVisible(true);

    }

}
