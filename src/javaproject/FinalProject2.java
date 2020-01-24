package javaproject;


//Evening handling in an applet

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.*;


/*
<applet  code="Applet13" width=400 height=350>
</applet>
*/

public class FinalProject2 extends Applet implements ActionListener
{
Button b1, b2, b3,b4;
FileDialog fileDialog;
AudioClip ac;
String s;
int first=0;

private Frame mainFrame;
private Label headerLabel;
private Label statusLabel;
private Panel controlPanel;

public void init()
{
System.out.println("initializing an applet");
System.out.println("The full path to our applet file : " + getDocumentBase()); //getDocumentBase() gives URL object
System.out.println("Directory in which our applet file is located : " + getCodeBase()); //getCodeBase() gives URL object


b1 = new Button("Play");
add(b1);
b2 = new Button("Loop");
add(b2);
b3 = new Button("Stop");
add(b3);
b4 = new Button("open");
add(b4);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand().equals("Play"))
{
ac = getAudioClip(getDocumentBase(),s); //playing a song(.wav format) from the same directory in which applet code file is located
ac.play();
}


if(ae.getActionCommand().equals("Loop"))
{
ac = getAudioClip(getDocumentBase(),s); //playing a song(.wav format) from the same directory in which applet code file is located
ac.loop();
}

if(ae.getActionCommand().equals("Stop"))
{
ac = getAudioClip(getDocumentBase(),s); //playing a song(.wav format) from the same directory in which applet code file is located
ac.stop();
}

if(ae.getActionCommand().equals("open"))
{

if(first!=0)
{ac = getAudioClip(getDocumentBase(),s); //playing a song(.wav format) from the same directory in which applet code file is located
ac.stop();}
prepareGUI();
showFileDialogDemo();
first++;
}
}

private void prepareGUI(){
  mainFrame = new Frame("Java AWT Examples");
  mainFrame.setSize(400,400);
  mainFrame.setLayout(new GridLayout(3, 1));
  mainFrame.addWindowListener(new WindowAdapter() {
     public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
     }        
  });    
  headerLabel = new Label();
  headerLabel.setAlignment(Label.CENTER);
  statusLabel = new Label();        
  statusLabel.setAlignment(Label.CENTER);
  statusLabel.setSize(350,100);

  controlPanel = new Panel();
  controlPanel.setLayout(new FlowLayout());

  mainFrame.add(headerLabel);
  mainFrame.add(controlPanel);
  mainFrame.add(statusLabel);
  mainFrame.setVisible(true);  
}

private void showFileDialogDemo(){
  headerLabel.setText("Control in action: FileDialog");

  final FileDialog fileDialog = new FileDialog(mainFrame,"Select file");
  Button showFileDialogButton = new Button("Open File");
  showFileDialogButton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
        fileDialog.setVisible(true);
        statusLabel.setText("File Selected :"
        +  fileDialog.getFile());
        s=fileDialog.getFile();
        mainFrame.setVisible(false);
     }
  });

  controlPanel.add(showFileDialogButton);
  mainFrame.setVisible(true);  
}


public void paint(Graphics g)
{
g.drawString("Click on the button to play,loop or stop the music", 80,80);
showStatus("Applet playing audio(.wav file)");
}
}
	
	
	
