
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haseebk
 */
public class Functions {
    
    DatagramSocket aSocket = null;
    public  void  sendreq(String condition){
        System.out.println("@@@@@@@@@@@@@@@@@"+condition);
        
        try {
aSocket = new DatagramSocket();
//byte [] m = args[0].getBytes();
byte [] m = condition.getBytes();
InetAddress aHost = InetAddress.getByName("127.0.0.1"); 
int serverPort = 6789;
DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort); 



aSocket.send(request);



byte[] buffer = new byte[1000];
DatagramPacket reply = new DatagramPacket(buffer, buffer.length); 
aSocket.receive(reply);
System.out.println("Reply:: " + new String(reply.getData()));
} catch (SocketException e){System.out.println("Socket: " + e.getMessage()); } 
        catch (IOException e){System.out.println("IO: " + e.getMessage());
} finally { if(aSocket != null) aSocket.close();}
    
    
    }
}
