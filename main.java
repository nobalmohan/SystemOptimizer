import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;


public class SystemOptimizer extends JFrame implements ActionListener
 {
    JTextArea ta =new JTextArea(36,40);
JScrollPane tascroll = new JScrollPane(ta,ScrollPaneConstants.  VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

JButton scbtn = new JButton("scan");
JButton clbtn = new JButton("clean");
JCheckBox tf = new  JCheckBox("temp files");
JCheckBox cok = new JCheckBox("cookies");
JCheckBox lfc = new JCheckBox("log files");
JCheckBox rc = new JCheckBox("recent documents");
JCheckBox tif = new JCheckBox("Temporary internet files");

void buildConstraints(GridBagConstraints gbc, int gx, int gy,
        int gw, int gh, int wx, int wy) {

        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.weightx = wx;
        gbc.weighty = wy;
    }

    public SystemOptimizer() 
    {
         super("SYSTEM OPTIMIZER");
        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta.setEditable(false);
        JPanel pane = new JPanel();
 	 
GridBagLayout gridbag = new GridBagLayout();
GridBagConstraints constraints = new GridBagConstraints();
pane.setLayout(gridbag);

scbtn.addActionListener(this);
scbtn.setActionCommand("scan");

clbtn.addActionListener(this);
clbtn.setActionCommand("clean");

        //user name label
        buildConstraints(constraints, 0, 0, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        JLabel un=new JLabel("User Name:");
        gridbag.setConstraints(un,constraints);
        pane.add(un);

        //user name text
        String n = System.getProperty("user.name");
        buildConstraints(constraints, 1, 0, 1, 1, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JLabel unt=new JLabel(n);
        gridbag.setConstraints(unt,constraints); 
        pane.add(unt);

        //os label
        buildConstraints(constraints, 0, 1, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        JLabel osl=new JLabel("Operating System:");
        gridbag.setConstraints(osl,constraints);
        pane.add(osl);

        //os text 
        String o = System.getProperty("os.name");
        buildConstraints(constraints, 1, 1, 1, 1, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JLabel ost=new JLabel(o);
        gridbag.setConstraints(ost,constraints);
        pane.add(ost);

        //osvl
        buildConstraints(constraints, 0, 2, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        JLabel osvl=new JLabel("OS Version:");
        gridbag.setConstraints(osvl,constraints);
        pane.add(osvl);

        //osvt
        String v = System.getProperty("os.version");
        buildConstraints(constraints, 1, 2, 1, 1, 0, 0);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JLabel osvt=new JLabel(v);
        gridbag.setConstraints(osvt,constraints);
        pane.add(osvt);

        //spl
        buildConstraints(constraints, 0, 3, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        JLabel spl=new JLabel("Service Pack Version:");
        gridbag.setConstraints(spl,constraints);
        pane.add(spl);


        //spt
        String s = System.getProperty("sun.os.patch.level");
        buildConstraints(constraints, 1, 3, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JLabel spt=new JLabel(s);
        gridbag.setConstraints(spt,constraints);
        pane.add(spt);


         //sal
        buildConstraints(constraints, 0, 4, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        JLabel sal=new JLabel("System Architecture:");
        gridbag.setConstraints(sal,constraints);
        pane.add(sal);


        //sat
        String a = System.getProperty("os.arch");
        buildConstraints(constraints, 1, 4, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JLabel sat=new JLabel(a);
        gridbag.setConstraints(sat,constraints);
        pane.add(sat);

        //temp files-check box
        buildConstraints(constraints, 0, 5, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(tf,constraints);
        pane.add(tf);

        //cookie-check box 
        buildConstraints(constraints, 0, 6, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
         gridbag.setConstraints(cok,constraints);
        pane.add(cok);

        //log files-check box
        buildConstraints(constraints, 0, 7, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(lfc,constraints);
        pane.add(lfc);

        //recent documents
        buildConstraints(constraints, 0, 8, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(rc,constraints);
        pane.add(rc);

        //temporary internet files
        buildConstraints(constraints, 0, 9, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(tif,constraints);
        pane.add(tif);

        
        //scan button
        buildConstraints(constraints, 0, 13, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(scbtn,constraints);
         pane.add(scbtn);

        //clean button
        buildConstraints(constraints, 0, 14, 1, 1, 0, 5);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        gridbag.setConstraints(clbtn,constraints);
        pane.add(clbtn);


         //text area
        buildConstraints(constraints, 20, 0, 0, 0, 0, 10);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        gridbag.setConstraints(tascroll,constraints);
        pane.add(tascroll);
    
/*
pane.add(new JLabel("TOTAL DATA TO REMOVED:"));
pane.add(new JLabel(stoval,SwingConstants.RIGHT));
pane.add(new JLabel("MB")); */

setContentPane(pane);
setVisible(true);
 }

public void actionPerformed(ActionEvent event)
 {
String command = event.getActionCommand();
String n = System.getProperty("user.name");
if (command == "scan")
{
if(tf.isSelected())
{
String com="C:/Documents and Settings/" + n +"/Local Settings/temp";
File f = new File(com);
File[] ComFile = f.listFiles();
 long Comtotal = 0;
for (int i = 0; i < ComFile.length; i++) 
{
Comtotal += ComFile[i].length();
ta.append(ComFile[i].getName());
ta.append("\n");
}
long dtotal=(Comtotal/1024);
if(dtotal>1)
JOptionPane.showMessageDialog(null, "Total temporary files to be removed="+dtotal+" KB");
else
JOptionPane.showMessageDialog(null, "Total temporary files to be removed="+dtotal+"KB");
}//tf sel

if(cok.isSelected())
{
String coo="C:/Documents and Settings/" + n +"/Cookies";
File co=new File(coo);
File[] CooFile = co.listFiles();
long  CooTotal=0;
for(int k=0;k<CooFile.length;k++)
{
CooTotal +=CooFile[k].length();
ta.append(CooFile[k].getName());
ta.append("\n");
}
long dtotal=(CooTotal/1024);
if(dtotal>1)
JOptionPane.showMessageDialog(null, "Total Cookies  to be removed="+dtotal+" KB");
else
JOptionPane.showMessageDialog(null, "Total Cookies  to be removed="+dtotal+"KB");
}//cookie if


//log files
if(lfc.isSelected())
{
String logf="C:/Windows/System32/wbem/logs";
File log=new File(logf);
File[] logFile = log.listFiles();
long logTotal=0;
for(int k=0;k<logFile.length;k++)
{
logTotal +=logFile[k].length();
ta.append(logFile[k].getName());
ta.append("\n");
}
long dtotal=(logTotal/1024);
if(dtotal>1)
JOptionPane.showMessageDialog(null, "Total logs files size to be removed="+dtotal+" KB");
else
JOptionPane.showMessageDialog(null, "Total log files size to be removed="+dtotal+"KB");

}

//recent document
if(rc.isSelected())
{
String micrec="C:/Documents and Settings/" +n+"/Application Data/Microsoft/Office/Recent";
File m = new File(micrec);
File[] MicrecFile = m.listFiles();
long MicrecTotal = 0;
for(int j=0;j<MicrecFile.length;j++)
{
MicrecTotal +=MicrecFile[j].length();
ta.append(MicrecFile[j].getName());
ta.append("\n");
}
long dtotal=(MicrecTotal/1024);
if(dtotal>1)
JOptionPane.showMessageDialog(null, "Total Recent files size to be removed="+dtotal+" KB");
else
JOptionPane.showMessageDialog(null, "Total Recent files size to be removed="+dtotal+"KB");
}

//temp internet files
if(tif.isSelected())
{
String recdoc="C:/Documents and Settings/"+n+"/Recent";
File rd=new File(recdoc);
File[] RecDocFile = rd.listFiles();
long RecdocTotal=0;
for(int k=0;k<RecDocFile.length;k++)
{
RecdocTotal +=RecDocFile[k].length();
ta.append(RecDocFile[k].getName());
ta.append("\n");
}
long dtotal=(RecdocTotal/1024);
if(dtotal>1)
JOptionPane.showMessageDialog(null, "Total temporary internet files size to be removed="+dtotal+" KB");
else
JOptionPane.showMessageDialog(null, "Total temporary internet files size to be removed="+dtotal+"KB");
}

/*long toval = Comtotal + MicrecTotal+RecdocTotal+CooTotal+logTotal;
String stoval = String.valueOf(toval/1024);*/


if(!tf.isSelected() && !cok.isSelected() && !lfc.isSelected() && ! tif.isSelected() && !rc.isSelected())
{
JOptionPane.showMessageDialog(null, "select atleast one option");
}//not if

}//scan
if (command == "clean")
{
if(tf.isSelected())
{
String com="C:/Documents and Settings/" + n +"/Local Settings/temp";
File f = new File(com);
File[] ComFile = f.listFiles();
 long Comtotal = 0;
for (int i = 0; i < ComFile.length; i++) 
{
ComFile[i].delete();
}
JOptionPane.showMessageDialog(null, "data cleaned");
}

if(cok.isSelected())
{
String coo="C:/Documents and Settings/" + n +"/Cookies";
File co=new File(coo);
File[] CooFile = co.listFiles();
long  CooTotal=0;
for(int k=0;k<CooFile.length;k++)
{
CooFile[k].delete();
}
JOptionPane.showMessageDialog(null, "data cleaned");
}

if(lfc.isSelected())
{
String logf="C:/Windows/System32/wbem/logs";
File log=new File(logf);
File[] logFile = log.listFiles();
long logTotal=0;
for(int k=0;k<logFile.length;k++)
{
logFile[k].delete();
}
JOptionPane.showMessageDialog(null, "data cleaned");
}

if(rc.isSelected())
{
String micrec="C:/Documents and Settings/" +n+"/Application Data/Microsoft/Office/Recent";
File m = new File(micrec);
File[] MicrecFile = m.listFiles();
long MicrecTotal = 0;
for(int j=0;j<MicrecFile.length;j++)
{
MicrecFile[j].delete();
}
JOptionPane.showMessageDialog(null, "data cleaned");
}
if(tif.isSelected())
{
String recdoc="C:/Documents and Settings/"+n+"/Recent";
File rd=new File(recdoc);
File[] RecDocFile = rd.listFiles();
long RecdocTotal=0;
for(int k=0;k<RecDocFile.length;k++)
{
RecDocFile[k].delete();
}
JOptionPane.showMessageDialog(null, "data cleaned");
}
if(!tf.isSelected() && !cok.isSelected() && !lfc.isSelected() && ! tif.isSelected() && !rc.isSelected())
{
JOptionPane.showMessageDialog(null, "select atleast one option");
}

}//clean
}//action


    public static void main(String[] arguments) {
        SystemOptimizer st = new SystemOptimizer();
    }
}
