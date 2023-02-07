package Prac4;

import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1050);
        Socket s = ss.accept();

        System.out.println("Connected");

        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        StringBuffer sb = new StringBuffer();

        while (sc.hasNext()) {
            sb.append(sc.nextLine() + "\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF(sb.toString());

        System.out.println("File sent!");
        ss.close();
        s.close();
        sc.close();
    }
}
