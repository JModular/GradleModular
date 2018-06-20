package com.java.socket.bio.client.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/**
 * 基本数据互转工具
 * @author eguid
 eguid的官网：www.eguid.cc
 *eguid的csdn博客：http://blog.csdn.net/eguid_1,博客园：http://www.cnblogs.com/eguid 
 */
public class ByteUtil {
	private static ByteBuffer buffer = ByteBuffer.allocate(8);
	 /**
	  * int转byte
	  * @param x
	  * @return
	  */
    public static byte intToByte(int x) {  
        return (byte) x;  
    }  
    /**
     * byte转int
     * @param b
     * @return
     */
    public static int byteToInt(byte b) {  
        //Java的byte是有符号，通过 &0xFF转为无符号
        return b & 0xFF;  
    }  
      
    /**
     * byte[]转int
     * @param b
     * @return
     */
    public static int byteArrayToInt(byte[] b) {  
        return   b[3] & 0xFF |  
                (b[2] & 0xFF) << 8 |  
                (b[1] & 0xFF) << 16 |  
                (b[0] & 0xFF) << 24;  
    }
    public static int byteArrayToInt(byte[] b, int index){
    	  return   b[index+3] & 0xFF |  
                  (b[index+2] & 0xFF) << 8 |  
                  (b[index+1] & 0xFF) << 16 |  
                  (b[index+0] & 0xFF) << 24;  
    }
    /**
     * int转byte[]
     * @param a
     * @return
     */
    public static byte[] intToByteArray(int a) {  
        return new byte[] {  
            (byte) ((a >> 24) & 0xFF),  
            (byte) ((a >> 16) & 0xFF),     
            (byte) ((a >> 8) & 0xFF),     
            (byte) (a & 0xFF)  
        };  
    }  
    /** 
     * short转byte[]
     *  
     * @param b 
     * @param s 
     * @param index 
     */  
    public static void byteArrToShort(byte b[], short s, int index) {  
        b[index + 1] = (byte) (s >> 8);  
        b[index + 0] = (byte) (s >> 0);  
    }
    /** 
     * byte[]转short 
     *  
     * @param b 
     * @param index 
     * @return 
     */  
    public static short byteArrToShort(byte[] b, int index) {  
        return (short) (((b[index + 0] << 8) | b[index + 1] & 0xff));  
    }
    /** 
     * 16位short转byte[] 
     *  
     * @param s 
     *            short 
     * @return byte[]
     * */  
    public static byte[] shortToByteArr(short s) {  
        byte[] targets = new byte[2];  
        for (int i = 0; i < 2; i++) {  
            int offset = (targets.length - 1 - i) * 8;  
            targets[i] = (byte) ((s >>> offset) & 0xff);  
        }  
        return targets;  
    }
    /**
     * byte[]转16位short
     * @param b
     * @return
     */
    public static short byteArrToShort(byte[] b){
    	return byteArrToShort(b,0);
    }
    
    /**
     * long转byte[]
     * @param x
     * @return
     */
    public static byte[] longToBytes(long x) {  
        buffer.putLong(0, x);  
        return buffer.array();  
    }  
    /**
     * byte[]转Long
     * @param bytes
     * @return
     */
    public static long bytesToLong(byte[] bytes) {  
        buffer.put(bytes, 0, bytes.length);  
        buffer.flip();//need flip   
        return buffer.getLong();  
    }
    /**
     * 从byte[]中抽取新的byte[]
     * @param data - 元数据
     * @param start - 开始位置
     * @param end - 结束位置
     * @return 新byte[]
     */
    public static byte[] getByteArr(byte[]data,int start ,int end){
		byte[] ret=new byte[end-start];
		for(int i=0;(start+i)<end;i++){
			ret[i]=data[start+i];
		}
		 return ret;
	}
	
	/**
	 * 流转换为byte[]
	 * @param inStream
	 * @return
	 */
	public static byte[] readInputStream(InputStream inStream) {
		ByteArrayOutputStream outStream = null;
		try {
			outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			byte[] data = null;
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			data = outStream.toByteArray();
			return data;
		}catch (IOException e) {
			return null;
		} finally {
			try {
				if (outStream != null) {
					outStream.close();
				}
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				return null;
			}
		}
	}
	/**
	 * byte[]转inputstream
	 * @param b
	 * @return
	 */
	public static InputStream readByteArr(byte[] b){
		return new ByteArrayInputStream(b);
	}
	/**
	 * byte数组内数字是否相同
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isEq(byte[] s1,byte[] s2){
		int slen=s1.length;
		if(slen==s2.length){
			for(int index=0;index<slen;index++){
				if(s1[index]!=s2[index]){
					return false;
				}
			}
			return true;
		}
		return  false;
	}
	/**
	 * byte数组转换为Stirng
	 * @param s1 -数组
	 * @param encode -字符集
	 * @param err -转换错误时返回该文字
	 * @return
	 */
	public static String getString(byte[] s1,String encode,String err){
		try {
			return new String(s1,encode);
		} catch (UnsupportedEncodingException e) {
			return err==null?null:err;
		}
	}
	/**
	 * byte数组转换为Stirng
	 * @param s1-数组
	 * @param encode-字符集
	 * @return
	 */
	public static String getString(byte[] s1,String encode){
		return getString(s1,encode,null);
	}
	//测试
	public static void main(String []args){
		System.err.println(isEq(new byte[]{1,2},new byte[]{1,2}));
	}
	/**
	 * 字节数组转16进制字符串
	 * @param b
	 * @return
	 */
	public static String byteArrToHexString(byte[] b){
		  String result="";
		  for (int i=0; i < b.length; i++) {
		    result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring(1);
		  }
		  return result;
	}
	
	/**
	 * 16进制字符创转int
	 * @param hexString
	 * @return
	 */
	public static int hexStringToInt(String hexString){
		return Integer.parseInt(hexString,16);
	}
	/**
	 * 十进制转二进制
	 * @param i
	 * @return
	 */
	public static String intToBinary(int i){
		return Integer.toBinaryString(i);
	}
}