package Uhr;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
 
/* ColorChooserDemo.java requires no other files. */
public class JavaDialogHintergrundfarbe extends JPanel
                              implements ChangeListener {
 
    protected static JColorChooser tcc;
    protected JLabel banner;
 
    public JavaDialogHintergrundfarbe() {
        super(new BorderLayout());
 
        //Set up the banner at the top of the window
        banner = new JLabel("Wählen Sie eine Hintergrundfarbe",
                            JLabel.CENTER);
        banner.setForeground(Color.black);
        banner.setBackground(Color.red);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));
        
 
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder(""));
 
        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getBackground());
        tcc.setPreviewPanel(new JPanel());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Mögliche Hintergrundfarben"));
        ColorSelectionModel model = tcc.getSelectionModel();
        model.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            ColorSelectionModel model = (ColorSelectionModel) evt.getSource();
            Color newColor = model.getSelectedColor();
            System.out.println(model.getSelectedColor());
          }
        });

        // Get current selected color
        Color color = tcc.getColor();
 
        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
    }
 
    public void stateChanged(ChangeEvent e) {
        ColorSelectionModel model = (ColorSelectionModel) e.getSource();
        Color newColor = model.getSelectedColor();
        banner.setBackground(newColor);
      }
   
    

        //Color newColor = tcc.getColor();
       
        
    
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    protected static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Schriftfarbe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new JavaDialogHintergrundfarbe();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}