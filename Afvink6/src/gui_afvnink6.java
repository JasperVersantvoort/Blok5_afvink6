import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * javadoc
 */
public class gui_afvnink6 {
    private JButton bestand;
    private JTextField textField1;
    private JButton analyseer;
    private JTextArea textArea1;
    private JPanel panel;
    static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K"
            , "M", "F", "P", "S", "T", "W", "Y", "V"};
    static int voldoen = 0;
    static int fout = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui_afvnink6");
        frame.setContentPane(new gui_afvnink6().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public gui_afvnink6() {
        bestand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedFile;
                JFileChooser fileChooser = new JFileChooser();
                int reply = fileChooser.showOpenDialog(null);
                if (reply == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    textField1.setText(selectedFile.getAbsolutePath());
                }


            }
        });
        analyseer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line;
                try {
                    BufferedReader inFile = new BufferedReader(new FileReader(textField1.getText()));
                    while ((line = inFile.readLine()) != null) {
                        for (int i = 0; i < line.length(); i++) {
                            for (String s : ONE) {
                                if (line[i] == s) {
                                    voldoen += 1;
                                } else {
                                    fout += 1;
                                }
                            }
                        }
                    }
                    inFile.close();

                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
            
        });

    }
}

class NotAnAA extends Exception {

    public NotAnAA() {
        super();
    }

    public NotAnAA(String err) {
        super(err);
    }
}