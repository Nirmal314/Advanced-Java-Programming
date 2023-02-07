import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(1060);
        byte buffer[] = new byte[1];
        byte result[] = new byte[1];

        int input = sc.nextInt();
        Integer i = Integer.valueOf(input);
        buffer[0] = i.byteValue();

        ds.send(new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 1050));
        System.out.println("Data sent, wait for results...");

        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        System.out.println("Result: " + result[0]);
        sc.close();
        ds.close();
    }
}
