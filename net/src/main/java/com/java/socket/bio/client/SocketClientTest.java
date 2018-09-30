package com.java.socket.bio.client;

import com.java.socket.bio.client.interfaces.SocketClientResponseInterface;

public class SocketClientTest{
	
	public static SocketClient c1;
	
	public static final byte Bytes[] = {(byte)0x10, (byte)0x20, (byte)0x30};
	
	public static void main(String[] args)  {

		
		 c1=new SocketClient(new SocketClientResponseInterface<String>() {

			@Override
			public void onSocketConnect() {
				  System.out.println("  上线:");
				
			}

			@Override
			public void onSocketReceive(String socketResult, int code) {
				  System.out.println("  msg:"+socketResult);
				
			}

			@Override
			public void onSocketDisable(String msg, int code) {
			  System.out.println("断开  msg:"+msg);
				
			}
		});
//		 

	}

	
/*	*/
	
}
