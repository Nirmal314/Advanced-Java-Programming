import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1050);
        byte buffer[] = new byte[1];
        byte result[] = new byte[1];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);

        System.out.println(buffer[0] * buffer[0]);
        result[0] = (byte) (buffer[0] * buffer[0]);
        ds.send(new DatagramPacket(result, result.length, InetAddress.getLocalHost(), 1060));
        System.out.println("Result sent!");
        ds.close();
    }
}
