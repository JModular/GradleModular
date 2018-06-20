package com.java.socket.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.java.socket.bio.server.interfaces.SocketServerResponseInterface;
import com.java.socket.bio.server.thread.ServerResponseThread;
import com.java.socket.bio.server.utils.SocketUtil;

public class ServerMain {
	 private static boolean isStart = true;
	    private static ServerResponseThread serverResponseThread;
	public static void main(String[] args) {
	     ServerSocket serverSocket = null;
	        ExecutorService executorService = Executors.newCachedThreadPool();
	        System.out.println("服务端 " + SocketUtil.getIP() + " 运行中...\n");
	        try {
	            serverSocket = new ServerSocket(SocketUtil.PORT);
	            while (isStart) {
	                Socket socket = serverSocket.accept();
	                //设定输入流读取阻塞超时时间(10秒收不到客户端消息判定断线)
	                socket.setSoTimeout(60000);
	                serverResponseThread = new ServerResponseThread(socket,
	                      new SocketServerResponseInterface() {
							
							@Override
							public void clientOnline(String clientIp) {
								   System.out.println(clientIp + " is online:"+new Date());
	                                System.out.println("-----------------------------------------");
								
							}
							
							@Override
							public void clientOffline() {
								System.out.println("-----------------------------------------"+new Date());
								
							}

							@Override
							public void onSocketReceive(String socketResult,
									int code) {
								System.out.println("接收消息:"+socketResult+code);
							}
						});

	                if (socket.isConnected()) {
	                    executorService.execute(serverResponseThread);
	                }
	            }

	            serverSocket.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (serverSocket != null) {
	                try {
	                    isStart = false;
	                    serverSocket.close();
	                    serverResponseThread.stop();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	}

}
