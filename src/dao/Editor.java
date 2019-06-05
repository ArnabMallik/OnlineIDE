package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Editor extends JFrame implements ActionListener , KeyListener
{
JTextArea jta;
JScrollPane jscroll;

JToolBar jtbar;
JButton bttnopen, bttnnew, bttnsave,bttncut, bttncopy,bttnpaste;

JMenuBar mbar;
JMenu file,edit;
JMenuItem fnew , fexit, fopen, fsave;
JMenuItem ecut , ecopy, epaste, eselall, edel;

ImageIcon iNew, iOpen, iSave, iCut, iCopy, iPaste;

String fname;
boolean chg;

public Editor()
{
fname = "";
chg = false;
setLayout(new BorderLayout());

jta = new JTextArea();
jta.setFont(new Font("Comic Sans MS", Font.PLAIN , 24) );
jta.addKeyListener(this);

jscroll = new JScrollPane(jta);
add(jscroll, BorderLayout.CENTER );

initIcons();

makemenu();
setJMenuBar(mbar);

maketoolbar();
add(jtbar, BorderLayout.NORTH);

setSize(400,300);
setVisible(true);

setDefaultCloseOperation(EXIT_ON_CLOSE);

}

void initIcons()
{
iNew  = new ImageIcon("images/new.gif");
iOpen  = new ImageIcon("/WebContent/images/open.gif");
iSave  = new ImageIcon("/WebContent/images/save.gif");
iCut  = new ImageIcon("/WebContent/images/cut.gif");
iCopy  = new ImageIcon("/WebContent/images/copy.gif");
iPaste  = new ImageIcon("/WebContent/images/paste.gif");
}

void makemenu()
{
mbar = new JMenuBar();

file = new JMenu("File");
edit = new JMenu("Edit");

file.setMnemonic('F');
edit.setMnemonic('E');

fnew = new JMenuItem("New", iNew);
fopen = new JMenuItem("Open", iOpen);
fsave = new JMenuItem("Save",iSave);
fexit = new JMenuItem("Exit");

ecut=new JMenuItem("cut", iCut);
ecopy=new JMenuItem("copy", iCopy);
epaste=new JMenuItem("Paste", iPaste);
eselall=new JMenuItem("Selectall");
edel=new JMenuItem("Delete");

file.add(fnew);
file.add(fopen);
file.add(fsave);
file.addSeparator();
file.add(fexit);

edit.add(ecut);
edit.add(ecopy);
edit.add(epaste);
edit.addSeparator();
edit.add(eselall);
edit.add(edel);

mbar.add(file);
mbar.add(edit);

fnew.addActionListener(this);
fopen.addActionListener(this);
fsave.addActionListener(this);
fexit.addActionListener(this);

ecut.addActionListener(this);
ecopy.addActionListener(this);
epaste.addActionListener(this);
eselall.addActionListener(this);
edel.addActionListener(this);

KeyStroke k ;

k = KeyStroke.getKeyStroke('N', java.awt.Event.CTRL_MASK);
fnew.setAccelerator(k);

k = KeyStroke.getKeyStroke('O', java.awt.Event.CTRL_MASK);
fopen.setAccelerator(k);

k = KeyStroke.getKeyStroke('S', java.awt.Event.CTRL_MASK);
fsave.setAccelerator(k);

}

void maketoolbar()
{
bttnnew = new JButton(iNew);
bttnopen = new JButton(iOpen);
bttnsave = new JButton(iSave);
bttncut  = new JButton(iCut);
bttncopy = new JButton(iCopy);
bttnpaste = new JButton(iPaste);

bttnnew.addActionListener(this);
bttnopen.addActionListener(this);
bttnsave.addActionListener(this);
bttncut.addActionListener(this);
bttncopy.addActionListener(this);
bttnpaste.addActionListener(this);

jtbar = new JToolBar();
jtbar.add(bttnnew);
jtbar.add(bttnopen);
jtbar.add(bttnsave);
jtbar.addSeparator();
jtbar.add(bttncut);
jtbar.add(bttncopy);
jtbar.add(bttnpaste);
}
public void keyPressed(KeyEvent e)
{}
public void keyReleased(KeyEvent e)
{}
public void keyTyped(KeyEvent e)
{
chg = true;
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource().equals(bttncut) || e.getSource().equals(ecut) )
{
jta.cut();
}
else if(e.getSource().equals(bttncopy) || e.getSource().equals(ecopy))
{
jta.copy();
}
else if(e.getSource().equals(bttnpaste) || e.getSource().equals(epaste))
{
jta.paste();
}
else if(e.getSource().equals(eselall))
{
jta.selectAll();
}
else if(e.getSource().equals(edel))
{
jta.replaceSelection("");
}
else if(e.getSource().equals(fnew))
{
fname = "";
chg = false;
jta.setText("");
}
else if(e.getSource().equals(fopen))
{
fileopen();
}
else if(e.getSource().equals(fsave))
{
filesave();
}
else if(e.getSource().equals(fexit))
{
fileexit();
}
}

void fileexit()
{
if(chg == true)
{
int res;
res = JOptionPane.showConfirmDialog(this, "Do You Want to Save Changes", "File Exit", JOptionPane.YES_NO_CANCEL_OPTION );
if(res == JOptionPane.YES_OPTION)
{
filesave();
}
else if(res == JOptionPane.CANCEL_OPTION)
{
return;
}
}
System.exit(0);
}

void fileopen()
{

JFileChooser jfc = new JFileChooser();
jfc.setFileSelectionMode(jfc.FILES_ONLY);

int res = jfc.showOpenDialog(this);
if(res == jfc.APPROVE_OPTION)
{
File f = jfc.getSelectedFile();
try
{
FileReader fr = new FileReader(f);
BufferedReader br = new BufferedReader(fr);

String data;
jta.setText("");

while( (data =br.readLine()) != null)
{
data = data + "n";
jta.append(data);
}
fname = f.getAbsolutePath();
br.close();
fr.close();

}
catch(IOException e)
{
JOptionPane.showMessageDialog
(
this , e.getMessage() , "File Open Error",
JOptionPane.ERROR_MESSAGE
);
}
}
}

void filesave()
{
if(fname.equals(""))
{
JFileChooser jfc = new JFileChooser();
jfc.setFileSelectionMode(jfc.DIRECTORIES_ONLY);

int res = jfc.showSaveDialog(this);
if(res == jfc.APPROVE_OPTION)
{
File f = jfc.getSelectedFile();
fname = f.getAbsolutePath();
filewrite();
}
}
else
filewrite();
}

void filewrite()
{
try
{
FileWriter fw = new FileWriter(fname);

fw.write(jta.getText());
fw.flush();
fw.close();
chg = false;
}
catch(IOException e)
{
JOptionPane.showMessageDialog
(
this , e.getMessage() , "File Save Error",
JOptionPane.ERROR_MESSAGE
);
}

}

public static void main(String args[])
{
new Editor();
}
}
