package com.java.socket.bio.client;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.java.socket.bio.client.interfaces.SocketClientResponseInterface;
import com.java.socket.bio.client.utils.ByteUtil;
import com.java.socket.bio.client.utils.BytesUtils;
import com.java.socket.bio.client.utils.SocketUtil;

public class SocketClientTest{
	public static SocketClient c1;
	
	public static final byte Bytes[] = {(byte)0x10, (byte)0x20, (byte)0x30};
	
	public static void main(String[] args)  {
		
	     String str="我是中国人";
		
	     System.out.println("十六进制数据："+BytesUtils.bytesToHex(BytesUtils.getBytes(str)));
	     try {
			System.out.println(new String(BytesUtils.hexStringToBytes("CED2CAC7D6D0B9FAC8CB"),"gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	     
	     
		String h="AE000F000008DCA9A9A200070008DCA9A9A2CD";
		System.out.println("字节："+Arrays.toString(BytesUtils.hexStringToBytes(h)));
		/**
		 * 校验和：一个字节。超过255的时候属于越位，取低位字节.例如：十进制256  十六进制：0x10,0x00
		 */
		
		System.out.println("--------------------------------------------------------");
		//第一条命令：机器上线
		byte [] data={0x7e,0x00,0x0f,0x00,0x00,0x08,(byte) 0xdc,(byte) 0xb6,(byte) 0xb6,(byte) 0x9f,0x00,0x07,
				0x00,0x08,(byte) 0xdc,(byte) 0xb6,(byte) 0xb6,(byte) 0x9f,0x72};
		byte [] data0={0x7e,0x00,0x0f,0x00,0x00,0x08,(byte) 0xdc,(byte) 0xb6,(byte) 0xb6,(byte) 0x9f,0x00,0x07,
				0x00,0x08,(byte) 0xdc,(byte) 0xb6,(byte) 0xb6,(byte) 0x9f};
		     //十六进制字符串
		String hex="7e000f000008dcb6b69f00070008dcb6b69f72";
		     //十六进制字符串转字节   存在 负号的情况是Java补码
		System.out.println("机器上线命令：字节长度："+(SocketUtil.hexStringToBytes(hex).length-4)+" 十六进制："+BytesUtils.bytesToHex(BytesUtils.intToBytes((SocketUtil.hexStringToBytes(hex).length-4))));
		System.out.println("机器上线命令：字节："+Arrays.toString(BytesUtils.hexStringToBytes(hex)));
		System.out.println("机器上线命令：(十进制)："+BytesUtils.getByteToStr(SocketUtil.hexStringToBytes(hex)));
		System.out.println("机器上线命令：校验和(十进制):"+Arrays.toString(BytesUtils.SumCheck(data0, 1)));
		
		//机器上线 回复命令8007：回复数据 0   校验和：
		String huihex="7e000a000008dcb6b69f800700";
		byte [] hui={0x7e,0x00,0x0a,0x00,0x00,0x08,(byte) 0xdc,(byte) 0xb6,(byte) 0xb6,(byte) 0x9f,(byte) 0x80,0x07,0x00};
		
		System.out.println("校验和："+Arrays.toString(BytesUtils.SumCheck(BytesUtils.hexStringToBytes(huihex), 2)));
		System.out.println("校验和："+Arrays.toString(BytesUtils.SumCheck(hui, 2)));
//		System.out.println("校验和：：："+SocketUtil.BinaryToHexString(BytesUtils.SumCheck(hui, 2)));
//		System.out.println("字符串：补码："+Arrays.toString(hui));
//        System.out.println("字符串：未补码："+BytesUtils.getByteToStr(hui));
//        System.out.println("十六进制字符串："+SocketUtil.BinaryToHexString(hui));
//        System.out.println("字节："+Arrays.toString(SocketUtil.hexStringToBytes(SocketUtil.BinaryToHexString(hui))));
//        System.out.println("--------------------------------------------------------");

		

		
		
		
	
        
		
		 /* c1=new SocketClient(new SocketClientResponseInterface<String>() {

			@Override
			public void onSocketConnect() {
				System.out.println("连接成功！");
				// c1.sendData(hexStr);
			}

			@Override
			public void onSocketReceive(String socketResult, int code) {
				System.out.println("接收数据："+socketResult);
				
			}

			@Override
			public void onSocketDisable(String msg, int code) {
				System.out.println("连接关闭:"+msg);
				
			}
		});*/
//		 

	}

	
}
