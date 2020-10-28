package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Clientdemo {

    public static void main(String[] args){

        Socket client = null;
        OutputStream outputStream = null;

        try {
            Random rand = new Random();
            StringBuffer sb =new StringBuffer();
            for (int i=1;i<=32;i++){
                int randNum = rand.nextInt(9)+1;
                String num = randNum+"";
                sb = sb.append(num);
            }
            String random = String.valueOf(sb);
            String ip = "127.0.0.1";
            int port = 8080;
            InetAddress inetAddress = InetAddress.getByName(ip);
            client = new Socket(inetAddress,port);
            client.setSoTimeout(3000);
            outputStream = client.getOutputStream();
            outputStream.write(random.getBytes());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(client != null){
                try {
                    client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
