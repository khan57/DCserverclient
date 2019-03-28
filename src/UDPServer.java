/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haseebk
 */
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {

    public static void main(String args[]) {
      
  DatagramSocket aSocket = null;
 InetAddress  ip;
 String hostname,sresponse;
  String Data="";
      
 try {
            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];
      ip = InetAddress.getLocalHost();
      hostname=ip.getHostName();
     Runtime runtime = Runtime.getRuntime();
     while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
//                System.out.println(request.getData());
                Data+=new String(request.getData()) + "";
                System.out.print("!!!!!!!!!!!!!!!"+Data+"!!!!!!!!!!!!!");
                
                switch(Data){
     
                    
                    case "ctime":
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                 Date date = new Date();  
                 
                        sresponse="time: "+formatter.format(date);
                     break;
                       case "ip":
                        sresponse="ip:"+ip;
                     break;
                       case "tmem":
                           long maxMemory = runtime.maxMemory();
                        sresponse="t.memory: "+maxMemory/1024;
                     break;
                       case "fmem":
                            long freeMemory = runtime.freeMemory();
                        sresponse="free Memory: "+freeMemory;
                     break;
                       case "hname":
                        sresponse="Hostname "+hostname;
                     break;
                    default:
                       sresponse="Nothing matched again this request: "+Data;
                        
     
     }
               
                        
                  
                byte [] m = sresponse.getBytes();
                
               
                DatagramPacket reply = new DatagramPacket(m,
                        m.length, request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
