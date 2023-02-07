package Prac1;

import java.net.InetAddress;

public class Inet {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("github.com");

        System.out.println("Host Name: " + ip.getHostName());
        System.out.println("IP Address: " + ip.getHostAddress());
    }
}