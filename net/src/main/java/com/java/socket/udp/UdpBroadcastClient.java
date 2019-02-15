package com.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpBroadcastClient {

	public static void main(String[] args) {
		sendUdp();
	}

	private static void sendUdp() {
		String host = "255.255.255.255";
        int port = 10085;
        String message = "10.1.80.196:8085";
        try {
        	System.out.println("发送udp广播...");
            InetAddress adds = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(message.getBytes(),
            message.length(), adds, port);
            ds.send(dp);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

}
