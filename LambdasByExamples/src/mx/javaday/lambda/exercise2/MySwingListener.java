package mx.javaday.lambda.exercise2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jgmnx
 */
public class MySwingListener {

    public static void main(String[] args) {
        JButton anonBtn = new JButton("Click me!!!");

        //TODO: Implement this with lambdas.
        anonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Hola soy una clase anonima.");
            }
        });

        JFrame frame = new JFrame("JavaDay GDL 2013");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(anonBtn, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
