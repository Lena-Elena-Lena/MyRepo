package lab1_demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public	class Sender{
	private String host; 
	private int port; 
	Sender(String host, int port){ 
	this.host = host; 
	this.port = port; 
	}
	Sender(){ 
		this.host = "localhost"; 
		this.port = 1050; 
		}
	public void sendMessage(Demo dem) throws IOException{ 
				
		try{		
		ByteArrayOutputStream byteOutStr = new ByteArrayOutputStream();		
        ObjectOutputStream objOutStr = new ObjectOutputStream(byteOutStr);
        objOutStr.writeObject(dem);
        
        byte[] data = byteOutStr.toByteArray();
		InetAddress addr = InetAddress.getByName(host);
		DatagramPacket pack = new DatagramPacket(data, data.length, addr, port); 
		DatagramSocket ds = new DatagramSocket(); 
		ds.send(pack); 
		//System.out.println ("Message is sent");
        ds.close();
		}
		catch (SocketException e) {
	    System.err.println(e);
	    } 
		catch(IOException e){
		System.err.println(e); 
		} 
	}
	
	public static void main(String[] args) throws IOException {
		
		
        Demo dm = new Demo(2,4,"Vasia","It's really cool!!!!I've been sent...))", new Date(), 5);
             
		// TODO Auto-generated method stub
		//String mes = "This is the sending message."; 
		Sender sndr = new Sender("localhost", 1050); 
		sndr.sendMessage(dm); 
		} 
}
	





