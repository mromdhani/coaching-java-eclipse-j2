package lu.cronos._02_lambda_use_cases;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Lambda_02_EventListener extends JFrame {
 
    private JButton button = new JButton("Click Me!");
 
    public Lambda_02_EventListener() {
        super("Listener Lambda Example");
 
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setLocationRelativeTo(null);
        
        getContentPane().setLayout(new FlowLayout());

        getContentPane().add(button);
 
        // Old style
        //   button.addActionListener(new ActionListener() {
        //       public void actionPerformed(ActionEvent evt) {
        //           System.out.println("Handled by anonymous class listener");
        //       }
        //   });
 
        // Lambda Style
        button.addActionListener(e -> System.out.println("Handled by Lambda listener"));
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Lambda_02_EventListener().setVisible(true);
            }
        });
    }
}