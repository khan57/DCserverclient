/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haseebk
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class UDPClient implements ActionListener {
    
   static  JButton ctime,hname,ip,freeMemory,tmemory;
   String cbutton="";
   
public static void main(String args[]) {
// args give message contents and server hostname 


//UI Code

JFrame frame = new JFrame("UDP client server");
frame.setBounds(50,50,500,300);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

JPanel panel = new JPanel();

panel.setBounds(0, 0, 700, 300);
panel.setBackground(Color.yellow);

 ctime= new JButton("Time");
ctime.setBounds(3, 3, 100, 50);
ctime.addActionListener(new UDPClient());

panel.add(ctime);

 hname= new JButton("Hostname");
hname.setBounds(105, 3, 100, 50);
hname.addActionListener(new UDPClient());
panel.add(hname);

 freeMemory= new JButton("Max_Memory");
freeMemory.setBounds(205, 3, 100, 50);
freeMemory.addActionListener(new UDPClient());
panel.add(freeMemory);

 tmemory= new JButton("T.Memory");
tmemory.setBounds(305, 3, 100, 50);
tmemory.addActionListener(new UDPClient());
panel.add(tmemory);

 ip= new JButton("IP");
ip.setBounds(405, 3, 100, 50);
ip.addActionListener(new UDPClient());
panel.add(ip);
frame.add(panel);
//

}

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == ctime){
            new Functions().sendreq("ctime");
            System.out.println("time");
        }else if(ae.getSource()==freeMemory){
            new Functions().sendreq("fmem");
         System.out.println("mMemory");
        
        }else if(ae.getSource()==ip){
        new Functions().sendreq("ip");
         System.out.println("ip");
        }
       
        else if(ae.getSource()==hname){
            new Functions().sendreq("hname");
        
         System.out.println("host name");
        }
         else if(ae.getSource()== tmemory){
        
             new Functions().sendreq("tmem");
         System.out.println("  t memory");
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    
   
}