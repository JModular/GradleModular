package com.java.socket.stream;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import com.java.socket.bio.client.utils.BytesUtils;

public class SocketHandler implements Runnable{
    private Socket socket;
    private DataOutputStream dataOutputStream;
    public SocketHandler(Socket socket){
        try {
            this.socket=socket;
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run(){
        try{
            System.out.println("新连接:"+socket.getInetAddress()+":"+socket.getPort());
            Thread.sleep(5000);
            //startHeartbeat();
            receiveMessage(socket.getInputStream());

        }catch(Exception e){e.printStackTrace();}finally{
            try{
                System.out.println("关闭连接:"+socket.getInetAddress()+":"+socket.getPort());
                if(socket!=null)socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void startHeartbeat() {
        // 新开线程处理心跳
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isConnected()){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    byte[] heartbeat = " server 发动心跳包 ".getBytes();
                    sendMessage(heartbeat);
                }
            }
        }).start();
    }

    private void sendMessage(byte[] bytes) {
        System.out.println("server >>> 发送到客服端消息: \" "+new String(bytes)+"\"");
        if(dataOutputStream != null){
            try {
                byte type = 1;
//                dataOutputStream.writeByte(type);
//                dataOutputStream.writeChar(bytes.length);
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public ChangeTool changeTool = new ChangeTool();
    private void receiveMessage(InputStream inputStream) {
    	while(isConnected()){
    		  int size;
              try {
                  byte[] buffer = new byte[64];
                  if (inputStream == null) return;
                  /* read会一直等待数据，如果要判断是否接受完成，只有设置结束标识，或作其他特殊的处理 */
                  //Log.i("SerialPort", mReadThreadBox.getName() + "---locker port------读取中");
                  size = inputStream.read(buffer);
//                  sendMessage();
                  if (size > 0) {
                	  System.out.println("字节："+ArrayUtils.toString(buffer));
                	   System.out.println("十六进字符串："+changeTool.ByteArrToHex(buffer));
                      System.out.println("十六进字符串："+BytesUtils.bytesToHex(buffer));
                  }else{
                	  System.out.println("size:"+size);
                  }
              } catch (IOException e) {
                  e.printStackTrace();
                  return;
              }
    	}
    
    	
    	
//        final DataInputStream dataInputStream = new DataInputStream(inputStream);
//        while(isConnected()){
//            try {         
//            	byte [] lengh=new byte [3];
//                lengh[0]=dataInputStream.readByte();
//                lengh[1]=dataInputStream.readByte();
//                lengh[2]=dataInputStream.readByte();
//                System.out.println("长度字节："+BytesUtils.bytesToInt(lengh, 1, 2));
//             
//                byte[] data = new byte[BytesUtils.bytesToInt(lengh, 1, 2)+1];
//                dataInputStream.readFully(data);
//                String hex=BytesUtils.bytesToHex(lengh)+BytesUtils.bytesToHex(data);
//                System.out.println("server <<< 收到客户端消息   十六进制: \""+hex +"\"");
//                System.out.println("server <<< 收到客户端消息   字节: \""+ Arrays.toString(BytesUtils.hexStringToBytes(hex))+"\"");
//                System.out.println("server <<< 收到客户端消息   字节长度: \""+ BytesUtils.hexStringToBytes(hex).length+"\"");
//                System.out.println("server <<< 收到客户端消息   字符: \""+ BytesUtils.getByteToStr(BytesUtils.hexStringToBytes(hex))+"\"");
//                System.out.println("server <<< 收到客户端消息: \""+ new String(BytesUtils.hexStringToBytes(hex), Charset.defaultCharset())+"\"");
//
//                sendMessage(BytesUtils.hexStringToBytes(hex));
//            } catch (SocketTimeoutException e) {
//                e.printStackTrace();
//                break;
//            } catch (IOException e) {
//                e.printStackTrace();
//                break;
//            }
//        }
    }

    private boolean isConnected() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }
}