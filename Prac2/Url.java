package Prac2;

import java.net.URL;

public class Url {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://drive.google.com/file/d/1Bea4vHPSs24VVxAcBrj57GAELL7Nkx9R/view");

        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host Name: " + url.getHost());
        System.out.println("Port Number: " + url.getPort());
        System.out.println("File Name: " + url.getFile());
    }
}
