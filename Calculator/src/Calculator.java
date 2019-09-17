import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener
{JFrame numpad;
JTextField textfield;
JButton numbutton[],c;
double value=0;double tmp=0;
static final int NONE=0;
static final int SUM=1;
static final int SUB=2;
static final int MUL=3;
static final int DIV=4;
static int action=NONE;
boolean  flag=false;
Calculator()
{
String caption[]={"1","2","3","+","4","5","6","-","7","8","9","*",".","0","=","/"};
numpad=new JFrame();
numpad.setLayout(new GridLayout(4,4));
numbutton=new JButton[16];
for(int i=0;i<numbutton.length;i++)
{
numbutton[i]=new JButton(caption[i]);
numbutton[i].addActionListener(this);
numpad.add(numbutton[i]);
}
textfield=new JTextField("0");
textfield.setFont(new Font(" ",Font.BOLD,18));
textfield.setEditable(false);
Container cont=getContentPane();
cont.add(textfield, BorderLayout.NORTH);
cont.add(textfield, BorderLayout.CENTER);
cont.add(c=new JButton("C"),BorderLayout.SOUTH);
c.addActionListener(this);
addWindowListener(new ExitListener());
WIndowUtility.show(this,250,280);
}
public void actionPerformed(ActionEvent ae)
{
if ((int)ae.getActionCommand().charAt(0)>=48 && (int)ae.getActionCommand().charAt(0)<=57)
{
if(textfield.getText().equals("0"))
    textfield.setText(ae.getActionCommand());
else
    if(!flag)
        textfield.setText(textfield.getText()+ae.getActionCommand());

else
    textfield.setText(ae.getActionCommand());
value=Double.parseDouble(textfield.getText());
flag=false;
}
else if(ae.getActionCommand().equals("C"))
{
textfield.setText("0");
value=0;
tmp=0;
action = NONE;
}
else if(ae.getActionCommand().equals("+"))
{ if(!flag)eq();
tmp=Double.parseDouble(textfield.getText());
action=SUM;
flag=true;
value=tmp;}
else if(ae.getActionCommand().equals("-"))
{ if(!flag)eq();
tmp=Double.parseDouble(textfield.getText());
action=SUB;
flag=true;
value=tmp;}
else if(ae.getActionCommand().equals("*"))
{ if(!flag)eq();
tmp=Double.parseDouble(textfield.getText());
action=MUL;
flag=true;
value=tmp;}

else if(ae.getActionCommand().equals("/"))
{ if(!flag)eq();
tmp=Double.parseDouble(textfield.getText());
action=DIV;
flag=true;
value=tmp;}

else if(ae.getActionCommand().equals("."))
{ if(textfield.getText().indexOf(".")==-1)
 textfield.setText(textfield.getText()+".");
 }
else if (ae.getActionCommand().equals("="))
 {
 eq();}}
 public void eq()
 {
 switch(action)
 {
 case 1:
 textfield.setText((tmp=tmp+value)+" ");
 break;

case 2:
 textfield.setText((tmp=tmp-value)+" ");
 break;
 
 case 3:
  textfield.setText((tmp=tmp*value)+" ");
 break;
 
 case 4:
  textfield.setText((tmp=tmp/value)+" ");
 break;}
 if(textfield.getText().endsWith(".0"))
 textfield.setText(textfield.getText().substring(0,textfield.getText().length()-2));
 }
 public Insets insets()
 {
 return new Insets(40,10,10,10);
 }
 public static void main(String args[])
 {
 new Calculator();
 }
 }
