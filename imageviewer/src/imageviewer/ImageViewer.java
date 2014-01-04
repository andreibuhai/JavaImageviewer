
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
// import




    public class ImageViewer extends JFrame implements ActionListener {
        
        private Container contentPane;
        
	  public ImageViewer() {
	    setTitle("Image Viewer");
	    setSize(500, 550); // creates window and sets window size
            GridLayout gridL = new GridLayout();
            this.setLayout(gridL);
	    JMenuBar mbar = new JMenuBar();
	    JMenu m = new JMenu("File");
	    openItem = new JMenuItem("Open");
	    openItem.addActionListener(this);
	    m.add(openItem);
	    exitItem = new JMenuItem("Exit");
	    exitItem.addActionListener(this);
	    m.add(exitItem);
	    mbar.add(m);
	    setJMenuBar(mbar); // Creates menu bar with open/ exit choices.
	 
	    label = new JLabel();
	    contentPane = getContentPane();
	    contentPane.add(label, "Center");
            contentPane.add(label, "Center");
	  }

  
          
          
          public void actionPerformed(ActionEvent evt) {
	    Object source = evt.getSource();
	    if (source == openItem) {
	      JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                chooser.setCurrentDirectory(new File("."));
	 
	     /* chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
	        public boolean accept(File f) {
	          return f.getName().toLowerCase().endsWith(".gif")
	              || f.isDirectory();
	        }
	 
	        public String getDescription() {
	          return "GIF Images";
	        }
	      }); // Opens file chooser dialogue and shows only gif images
	 */
	      int r = chooser.showOpenDialog(this);
              
	      if (r == JFileChooser.APPROVE_OPTION) {
                  File[] files = chooser.getSelectedFiles();
                  for(File file : files){
                      System.out.println(file.getName());
                     ImageIcon im = new ImageIcon(file.getPath());
                     
                      JLabel l = new JLabel();
                      l.setIcon(im);
                      contentPane.add(l,"Center");
                      //contentPane.add(new JLabel().setIcon(new ImageIcon(file.getPath())), "Center"); //nu e pl asa dar nu vad ce eroare e 
                  label.setIcon(new ImageIcon(chooser.getSelectedFile().getPath()));
                  }
	        //String name = chooser.getSelectedFile().getName();
	       //label.setIcon(new ImageIcon(chooser.getSelectedFile().getPath())); // pune poza intr-un label
                
               
	      }
	    } else if (source == exitItem)
	      System.exit(0); // Exits program when exit is chosen from the file menu
	  }
	 
	  public static void main(String[] args) {
	    JFrame frame = new ImageViewer();
	    frame.show();
	  }
	 
	 private JLabel label;
          
	 
	  private JMenuItem openItem;
	 
	  private JMenuItem exitItem;
	}
   
    

