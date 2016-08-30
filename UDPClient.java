import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
public static void main(String atgs[])
{
	InetAddress iad;
	
	String host = "127.0.0.1";
	
	Scanner scan = new Scanner(System.in);
	String mess = new String();
	try {
		while(!mess.contains("bye"))
		{
		iad = InetAddress.getByName(host);
		System.out.println("Local Address:"+iad.getHostAddress());
		DatagramSocket sc = new DatagramSocket();
		
			System.out.println("Enter message to send");
			 mess = scan.nextLine();
			 if(mess.equals("bye")) break;
			byte[] bs = mess.getBytes();
			
			DatagramPacket dp = new DatagramPacket(bs,bs.length,iad,9900);
			sc.send(dp);
			byte[] buf=new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			sc.receive(packet);
			SocketAddress remoteAd = packet.getSocketAddress();
			buf = packet.getData();
			String msg1 = new String(buf);
			
			System.out.println("Server address:"+remoteAd+" Data Received:"+msg1);
		}
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
