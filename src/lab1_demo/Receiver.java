package lab1_demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

	
		public static void main(String[] args) throws ClassNotFoundException{ 
		try{
		int port = 1050;
		int bufSize = 1024;
        byte[] data =  new byte[bufSize];
        DatagramPacket pack = new DatagramPacket(data, data.length);
		DatagramSocket ds = new DatagramSocket(port); 
        ds.receive(pack);
        ByteArrayInputStream byteInpStr = new ByteArrayInputStream(pack.getData());
        ObjectInputStream objInpStr = new ObjectInputStream(byteInpStr);
        Object obj = objInpStr.readObject();
        
        Demo dem;
        dem = (Demo) obj;
        System.out.println ("Read me....");
        System.out.println (dem.toString());
        ds.close();
		
		}
		 
		catch (SocketException e) {
		    System.err.println(e);
		    } 
			catch(IOException e){
			System.err.println(e); 
			} 
		} 
		

}
