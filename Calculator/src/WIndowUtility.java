import java.awt.*;
import javax.swing.*;
public class WIndowUtility{
public static final int NATIVE=0;
public static final int JAVA=1;
public static final int MOTF=2;
static Toolkit t;
static Dimension d;
static{
t= Toolkit.getDefaultToolkit();
d=t.getScreenSize();
}
public static void setLookAndFeel(int landf)
{
String lookandfeel[]={UIManager.getSystemLookAndFeelClassName(),UIManager.getCrossPlatformLookAndFeelClassName(),
"com.sun.java.swing.plaf.motif.MotifLookAndFel"};
try{if(landf<=2 && landf>=0) 
UIManager.setLookAndFeel(lookandfeel[landf]);
}
catch(Exception e){}
}
static void show(JFrame f, int width, int height)
{
f.setResizable(false);
f.setBounds((d.width=width)/2,(d.height-height)/2,width,height);
f.setVisible(true);
}
static void show (Frame f, int width, int height)
{
f.setResizable(false);
f.setBounds((d.width-width)/2,(d.height-height)/2,width,height);
f.setVisible(true);
}
static void show(JFrame f)
{
f.setResizable(false);
f.setVisible(true);
f.setLocation(d.width/3,d.height/3);
f.pack();
}
static void show(Frame f)
{
f.setResizable(false);
f.setVisible(true);
f.setLocation(d.width/3,d.height/3);
f.pack();
}}
