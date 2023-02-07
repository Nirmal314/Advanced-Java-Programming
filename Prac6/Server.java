import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(1060);
        byte buffer[] = new byte[1000];

        while (true) {
            String input = sc.nextLine();
            buffer = input.getBytes();

            ds.send(new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 1050));

            if (input.equals("bye"))
                break;
        }

        sc.close();
        ds.close();
    }
}
