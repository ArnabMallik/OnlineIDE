package dao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame{
	



    //... Components 
    private JTextArea    _editArea;
    private JFileChooser _fileChooser = new JFileChooser(new File(Path.savepath+"\\temporary\\"+EditorFile.getid()));
    
    private OpenAction _openAction = new OpenAction();
    private SaveAction _saveAction = new SaveAction();
    private ExitAction _exitAction = new ExitAction(); 
   

   



    public Notepad() {
        //... Create scrollable text area.
        _editArea = new JTextArea(15, 80);
        _editArea.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        _editArea.setFont(new Font("monospaced", Font.PLAIN, 20));
        JScrollPane scrollingText = new JScrollPane(_editArea);
        
        //-- Create a content pane, set layout, add component.
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(scrollingText, BorderLayout.CENTER);
        
    

        
        
        //... Create menubar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = menuBar.add(new JMenu("File"));
        fileMenu.setMnemonic('F');
        fileMenu.add(_openAction);       // Note use of actions, not text.
        fileMenu.add(_saveAction);
        fileMenu.addSeparator(); 
        fileMenu.add(_exitAction);
      
       

		
        //... Set window content and menu.
        setContentPane(content);
        setJMenuBar(menuBar);
        
        //... Set other window characteristics.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("NotePad");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    
    








    
    
   
    	
    	
    
    
    class OpenAction extends AbstractAction {
        //============================================= constructor
        public OpenAction() {
            super("Open...");
            putValue(MNEMONIC_KEY, new Integer('O'));
        }
        
        //========================================= actionPerformed
        public void actionPerformed(ActionEvent e) {
            int retval = _fileChooser.showOpenDialog(Notepad.this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File f = _fileChooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(f);
                    _editArea.read(reader, "");  // Use TextComponent read
                } catch (IOException ioex) {
                    System.out.println(e);
                    System.exit(1);
                }
            }
        }
    }
    
    class SaveAction extends AbstractAction {
        //============================================= constructor
        SaveAction() {
            super("Save...");
            putValue(MNEMONIC_KEY, new Integer('S'));
        }
        
        //========================================= actionPerformed
       public void actionPerformed(ActionEvent e) {
    	   
    	   System.out.println("save");
    	   
    	  
			
    	       // System.out.println(xyz.getName());
    	        
    	        
    	    
            int retval = _fileChooser.showSaveDialog(Notepad.this);
            
           
           
            if (retval == JFileChooser.APPROVE_OPTION) {
                File f = _fileChooser.getSelectedFile();
                
                EditorFile.setpath(f.getName());
                
                
                try {
                    FileWriter writer = new FileWriter(f);
                    _editArea.write(writer);  // Use TextComponent write
                } catch (IOException ioex) {
                    JOptionPane.showMessageDialog(Notepad.this, ioex);
                    System.exit(1);
                }
            }
            
            
        
    }
    }
    
    

    class ExitAction extends AbstractAction {
        
        //============================================= constructor
        public ExitAction() {
            super("Exit");
            putValue(MNEMONIC_KEY, new Integer('X'));
        }
        
        //========================================= actionPerformed
        public void actionPerformed(ActionEvent e) {
        	 int confirm=JOptionPane.showOptionDialog(Notepad.this,"Are You Sure to Close this Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
            
             if(confirm==JOptionPane.YES_OPTION)
             {
          	   
          	   JOptionPane.showMessageDialog(Notepad.this,"Filesaved");
             
          	   
                  
          	   setVisible(false);
          	   
          	   
             }
             
             
             
            
             
        }
        
    	
    } 
 

}







	
	
	
	


