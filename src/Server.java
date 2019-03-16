/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamal
 */
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    public static void main(String args[]) {
      
  DatagramSocket aSocket = null;
 InetAddress  ip;
 String hostname;
       
 try {
            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];
      ip = InetAddress.getLocalHost();
      hostname=ip.getHostName();
     while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                System.out.println(request.getData());
               String allData="";
               allData+="Response from server\n";               
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                 Date date = new Date();  
                  System.out.println(formatter.format(date)); 
                  allData+="Current Date&Time: "+ formatter.format(date)+"\n";
                  allData+= "Current Ip Address: "+ip+"\n";
                  //
                  Runtime runtime = Runtime.getRuntime();
                  long maxMemory = runtime.maxMemory();
                    long allocatedMemory = runtime.totalMemory();
                    long freeMemory = runtime.freeMemory();
                  //
              
                        allData+= "Max Memory: "+maxMemory+"\n";
                       allData+= "free memory: "+freeMemory+"\n";
                          allData+= "used memory: "+allocatedMemory+"\n";
                byte [] m = allData.getBytes();
                
               
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
