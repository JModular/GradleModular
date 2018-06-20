package com.java.socket.bio.client.thread;



import java.io.BufferedReader;

import com.java.socket.bio.client.interfaces.SocketClientResponseInterface;
import com.java.socket.bio.client.interfaces.SocketCloseInterface;
import com.java.socket.bio.client.utils.SocketUtil;

/**
 * Created by gavinandre on 18-3-13.
 * 数据接收线程
 */
public class SocketReceiveThread extends Thread {

    private static final String TAG = SocketReceiveThread.class.getSimpleName();

    private volatile String name;

    private volatile boolean isCancel = false;

    private BufferedReader bufferedReader;

    private SocketCloseInterface socketCloseInterface;

    private SocketClientResponseInterface socketClientResponseInterface;

    public SocketReceiveThread(String name, BufferedReader bufferedReader,
                               SocketClientResponseInterface socketClientResponseInterface,
                               SocketCloseInterface socketCloseInterface) {
        this.name = name;
        this.bufferedReader = bufferedReader;
        this.socketClientResponseInterface = socketClientResponseInterface;
        this.socketCloseInterface = socketCloseInterface;
    }

    @Override
    public void run() {
        final Thread currentThread = Thread.currentThread();
        final String oldName = currentThread.getName();
        currentThread.setName("Processing-" + name);
        try {
            while (!isCancel) {
                //if (!isConnected()) {
                //    break;
                //}

                if (bufferedReader != null) {
                    String receiverData = SocketUtil.readFromStream(bufferedReader);
                    if (receiverData != null) {
                        successMessage(receiverData);
                    } else {
                        System.out.println(TAG+"run: receiverData==null");
                        break;
                    }
                }
            }
        } finally {
            //循环结束则退出输入流
            SocketUtil.closeBufferedReader(bufferedReader);
            currentThread.setName(oldName);
           System.out.println(TAG+":SocketReceiveThread finish");
        }
    }

    /**
     * 接收消息回调
     */
    private void successMessage(String data) {
        if (socketClientResponseInterface != null) {
            socketClientResponseInterface.onSocketReceive(data, SocketUtil.SUCCESS);
        }
    }

    public void close() {
        isCancel = true;
        this.interrupt();
        if (bufferedReader != null) {
            if (socketCloseInterface != null) {
                socketCloseInterface.onSocketShutdownInput();
            }
            SocketUtil.closeBufferedReader(bufferedReader);
            bufferedReader = null;
        }
    }

}
