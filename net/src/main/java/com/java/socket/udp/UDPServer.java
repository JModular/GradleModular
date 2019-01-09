package com.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
        int port = 10086;
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];
        try {         
            ds = new DatagramSocket(port);
            dp = new DatagramPacket(buf, buf.length);
            System.out.println("监听广播端口打开：");
            while (true) {
                ds.receive(dp);
                int i;
                StringBuffer sbuf = new StringBuffer();
                for (i = 0; i < 1024; i++) {
                    if (buf[i] == 0) {
                        break;
                    }
                    sbuf.append((char) buf[i]);
                }
                System.out.println("收到广播消息：" + sbuf.toString());
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

	}

}
