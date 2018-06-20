package com.java.socket.simple.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

import com.java.socket.bio.client.utils.SocketUtil;

/**
 * 模拟客户端多线程发送Socket
 * 
 * @author Arison
 *
 */
public class MultiThreadEchoClient {
	static ExecutorService es = Executors.newCachedThreadPool();
	
	public static class EchoClient implements Runnable {
		 Long sleep_time = 1000 * 1000 * 1000L;
		
		public EchoClient(Long sleep_time) {
			super();
			this.sleep_time = sleep_time;
		}

		@Override
		public void run() {

			Socket client = null;
			PrintWriter writer = null;
			BufferedReader reader = null;
            //字节流
			DataOutputStream out = null;
			//
			OutputStream outStream=null;
			
			try {
				client = new Socket();
				client.connect(new InetSocketAddress("192.168.253.200", 10086));
				
				outStream=client.getOutputStream();
				out =new DataOutputStream(client.getOutputStream());
				writer = new PrintWriter(client.getOutputStream(), true);
				
				
				byte[] b=SocketUtil.hexStringToBytes("BE000A800304050808080808017D"); 
				//b="BE000A800304050808080808017D".getBytes();
				String hex=SocketUtil.BinaryToHexString(b);//转十六进制字符串
				
				System.out.println("发送字节："+Arrays.toString(b));
				System.out.println("发送字符串："+hex);
				System.out.println("发送字节："+Arrays.toString(SocketUtil.hexStringToBytes(hex)));
//				out.write(SocketUtil.hexStringToBytes(hex));//十六进制字符串转字节
//                out.flush();
				
			     outStream.write(b);
			     outStream.flush();

				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.println("from server:" + reader.readLine());
			} catch (UnknownHostException ex) {
				ex.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				  try {
		                out.close();
		            } catch(IOException e) {
		            	e.printStackTrace();
		         }

				if (writer != null) {
					writer.close();
				}
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}

				}
				if (client != null) {
					try {
						client.close();			
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			EchoClient ec;
			ec = new EchoClient(0L);
			es.execute(ec);
		}
	}

}
