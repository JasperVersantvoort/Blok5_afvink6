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
    static final String[] ONE = { "R", "N", "D", "C", "Q", "E", "G", "H", "K","S", "T","Y",
            "A","F","I","L","M","P","W","V"};
    static int polair = 0;
    static int apolair = 0;
    static int goed = 0;

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
                int t = 0;

                try {
                    BufferedReader inFile = new BufferedReader(new FileReader(textField1.getText()));
                    while ((line = inFile.readLine()) != null) {
                        for (int i = 0; i < line.length(); i++) {
                            t ++;
                            char a = line.charAt(i);
                            System.out.println(a);
                            for (int x = 0; x< ONE.length;x++) {
                                char s = ONE[x].charAt(0);
                                if (a == s ) {
                                    goed ++;
                                    if (x>11){
                                        polair ++;
                                } else {
                                        apolair ++;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println(polair);
                    inFile.close();

                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }

                if (goed != t) {
                    System.out.println(goed);
                    textArea1.setText("zit een fout aminozuur in bestand");
                }
                else{
                    textArea1.setText("alle aminozuren zijn juist \n" +
                            "Het totaal aantal aminozuren is: " + (polair+apolair) + "\n" +
                            (polair*100/(polair+apolair)) + "% van de aminozuren is polair en " +
                            (apolair*100/(polair+apolair)) + "% is apolair");
                }
            }

        });

    }

}