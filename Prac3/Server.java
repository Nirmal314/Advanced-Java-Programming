package Prac3;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1050);
        Socket s = ss.accept();
        System.out.println("Connected");

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("This is the message from server!");

        System.out.println("Message sent successfully!");
        ss.close();
        s.close();
    }
}
