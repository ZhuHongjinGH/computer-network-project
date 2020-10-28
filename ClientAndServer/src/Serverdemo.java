import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            serverSocket  = new ServerSocket(8080);
            while(true){
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();

                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos != null){
                try {
                    baos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            socket.close();
            serverSocket.close();
        }
    }
}
