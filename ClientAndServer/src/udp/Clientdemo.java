package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Clientdemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        Random rand = new Random();
        StringBuffer sb =new StringBuffer();
        for (int i=1;i<=32;i++){
            int randNum = rand.nextInt(9)+1;
            String num = randNum+"";
            sb = sb.append(num);
        }
        String random = String.valueOf(sb);
        String msg = random;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8080;

        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,inetAddress,port);

        socket.send(packet);
        socket.close();
    }
}
