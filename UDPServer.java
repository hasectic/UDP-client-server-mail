import java.io.IOException;
import java.net.*;
import java.util.Scanner;
public class UDPServer {
	static int port = 9900;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InetAddress iad;
		byte[] buf = new byte[1024];
		Scanner scan = new Scanner(System.in);
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		try {
			iad = InetAddress.getLocalHost();
			System.out.println("Local Address:"+iad.getHostAddress());
			DatagramSocket sc = new DatagramSocket(port,iad);
			while(true){
				sc.receive(packet);
				SocketAddress remoteAdd = packet.getSocketAddress();
				buf = packet.getData();
				String ms = new String(buf);
				System.out.println("Client address:"+remoteAdd+" Data Received:"+ms);
				System.out.println("enter the message to respond");
				String msg = scan.nextLine();
				byte[] bs = msg.getBytes();
				DatagramPacket dp = new DatagramPacket(bs,bs.length,remoteAdd);
				sc.send(dp);
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
