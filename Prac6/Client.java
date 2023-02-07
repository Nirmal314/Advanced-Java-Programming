import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client {
    public static StringBuffer getData(byte[] buffer) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (buffer[i] != 0) {
            sb.append((char) buffer[i]);
            i++;
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1050);
        byte buffer[] = new byte[1000];

        while (true) {
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);

            System.out.println(getData(buffer));

            if (getData(buffer).toString().equals("bye"))
                break;

            buffer = new byte[1000]; // reset buffer
        }
        ds.close();
    }
}
