import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void sendFile(){
        
    }
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1050);
        Socket s = ss.accept();
        System.out.println("Connected");

        File folder = new File("/home/nemo/Desktop/SEM 6/AJP/LAB/Prac5");
        File[] listOfFiles = folder.listFiles();

        int j = 1;
        for (int i = 0; i < listOfFiles.length; i++) {

            File file = listOfFiles[i];

            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(j + ") " + file.getName());
                j++;
            }
        }
        System.out.print("Choose a txt file: ");

        Scanner scanFile = new Scanner(System.in);
        String inputFile = scanFile.nextLine();
        File file = new File(inputFile);

        for (int i = 0; i < listOfFiles.length; i++) {
            File files = listOfFiles[i];

            if (files.isFile() && files.getName().endsWith(".txt") && files.getName().equals(inputFile)) {

                Scanner sc = new Scanner(file);
                StringBuffer sb = new StringBuffer();

                while (sc.hasNext()) {
                    sb.append(sc.nextLine() + "\n");
                }

                sb.delete(sb.length() - 1, sb.length());

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(sb.toString());

                System.out.println("File sent!");
                sc.close();
                break;
            }
        }

        ss.close();
        s.close();
        scanFile.close();
    }
}
