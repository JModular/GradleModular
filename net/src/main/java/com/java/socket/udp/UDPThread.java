package com.java.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPThread implements Runnable{
    
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    

    public UDPThread(DatagramSocket socket,DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        String info = null;
        InetAddress address = null;
        int port = 10086;
        byte[] data2 = null;
        DatagramPacket packet2 = null;
        try {
            info = new String(packet.getData(), 0, packet.getLength());
            System.out.println("我是服务器，客户端说："+info);
            
            address = packet.getAddress();
            port = packet.getPort();
            data2 = "我在响应你！".getBytes();
            packet2 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //socket.close();不能关闭         
    }

}