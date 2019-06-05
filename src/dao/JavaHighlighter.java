package dao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import dao.Notepad.ExitAction;
import dao.Notepad.OpenAction;
import dao.Notepad.SaveAction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaHighlighter extends JFrame {

	public static final Color DEFAULT_KEYWORD_COLOR = Color.blue;
	
	 private JTextArea    _editArea;
	    private JFileChooser _fileChooser = new JFileChooser(new File(Path.savepath+"\\temporary\\"+EditorFile.getid()));
	    
	    private OpenAction _openAction = new OpenAction();
	    private SaveAction _saveAction = new SaveAction();
	    private ExitAction _exitAction = new ExitAction(); 

	public static final String[] JAVA_KEYWORDS = new String[] { "abstract",
			"assert", "boolean", "break", "byte", "case", "catch", "char",
			"class", "const", "continue", "default", "do", "double", "else",
			"enum", "extends", "final", "finally", "float", "for", "goto",
			"if", "implements", "import", "instanceof", "int", "long",
			"native", "new", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "try",
			"void", "volatile", "while", "false", "null", "true","namespace" };
	public static String JAVA_KEYWORDS_REGEX;

	static {
		StringBuilder buff = new StringBuilder("");
		buff.append("(");
		for (String keyword : JAVA_KEYWORDS) {
			buff.append("\\b").append(keyword).append("\\b").append("|");
		}
		buff.deleteCharAt(buff.length() - 1);
		buff.append(")");
		JAVA_KEYWORDS_REGEX = buff.toString();
	}

	private JPanel contentPane;
	private JToolBar toolBar;
	private JTextPane textEditor;
	private JScrollPane textEditorScrollPane;
	private JButton highLightBtn;
	private StyledDocument textEditorDoc;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaHighlighter frame = new JavaHighlighter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JavaHighlighter() {
		setTitle("EDITOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	

		highLightBtn = new JButton("Highlight Syntax");
		highLightBtn.addActionListener(highLightBtnClick());
		

		textEditor = new JTextPane();
		textEditor.setFont(new Font("monospaced", Font.PLAIN, 20));
		textEditorDoc = textEditor.getStyledDocument();
		textEditor.getDocument().putProperty(
				DefaultEditorKit.EndOfLineStringProperty, "\n");
		textEditorScrollPane = new JScrollPane(textEditor);
		textEditorScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(textEditorScrollPane, BorderLayout.CENTER);
		
		  JMenuBar menuBar = new JMenuBar();
	        JMenu fileMenu = menuBar.add(new JMenu("File"));
	        fileMenu.setMnemonic('F');
	        fileMenu.add(_openAction);       // Note use of actions, not text.
	        fileMenu.add(_saveAction);
	        fileMenu.addSeparator(); 
	        fileMenu.add(_exitAction);
	        fileMenu.add(highLightBtn);
	        
	        setJMenuBar(menuBar);
	}
	
	 
    class OpenAction extends AbstractAction {
        //============================================= constructor
        public OpenAction() {
            super("Open...");
            putValue(MNEMONIC_KEY, new Integer('O'));
        }
        
        //========================================= actionPerformed
        public void actionPerformed(ActionEvent e) {
            int retval = _fileChooser.showOpenDialog(JavaHighlighter.this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File f = _fileChooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(f);
                    textEditor.read(reader, "");  // Use TextComponent read
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
    	        
    	        
    	    
            int retval = _fileChooser.showSaveDialog(JavaHighlighter.this);
            
           
           
            if (retval == JFileChooser.APPROVE_OPTION) {
                File f = _fileChooser.getSelectedFile();
                
                EditorFile.setpath(f.getName());
                
                
                try {
                    FileWriter writer = new FileWriter(f);
                    textEditor.write(writer);  // Use TextComponent write
                } catch (IOException ioex) {
                    JOptionPane.showMessageDialog(JavaHighlighter.this, ioex);
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
        	 int confirm=JOptionPane.showOptionDialog(JavaHighlighter.this,"Are You Sure to Close this Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
            
             if(confirm==JOptionPane.YES_OPTION)
             {
          	   
          	   JOptionPane.showMessageDialog(JavaHighlighter.this,"Filesaved");
             
          	   
                  
          	   setVisible(false);
          	   
          	   
             }
             
             
             
            
             
        }
        
    	
    } 
 

	public ActionListener highLightBtnClick() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearTextColors();
				Pattern pattern = Pattern.compile(JAVA_KEYWORDS_REGEX);
				//System.out.println(pattern.pattern());
				Matcher match = pattern.matcher(textEditor.getText());
				while (match.find()) {
					updateTextColor(match.start(), match.end() - match.start());
				}

			}
		};
	}

	public void updateTextColor(int offset, int length, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
				StyleConstants.Foreground, c);
		textEditorDoc.setCharacterAttributes(offset, length, aset, true);
	}

	public void clearTextColors() {
		updateTextColor(0, textEditor.getText().length(), Color.BLACK);
	}

	public void updateTextColor(int offset, int length) {
		updateTextColor(offset, length, DEFAULT_KEYWORD_COLOR);
	}
}