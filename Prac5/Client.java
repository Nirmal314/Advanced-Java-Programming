import java.io.DataInputStream;
import java.io.EOFException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        try {
            Socket s = new Socket("localhost", 1050);

            System.out.println("Connected");

            DataInputStream dis = new DataInputStream(s.getInputStream());

            String data = dis.readUTF();

            System.out.println("Data: ");
            System.out.println(data);

            s.close();
        } catch (EOFException eof) {
            System.out.println("File not found!");
        }
    }
}
