import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LaneWorldLogger {
  private static JTextArea textArea;

  public static void createGUI(){
    JFrame frame = new JFrame("LaneWorld Log");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    textArea = new JTextArea(30, 30);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    frame.add(scrollPane);
    frame.pack();
    frame.setVisible(true);
  }

  public static void log(String msg) {
    textArea.append(msg + "\n");
  }

}
