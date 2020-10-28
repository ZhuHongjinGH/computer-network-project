package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Serverdemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(8080);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
