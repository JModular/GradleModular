package com.java.socket.bio.client;

import com.android.core.utils.StringUtils;
import com.java.socket.bio.client.interfaces.SocketClientResponseInterface;
import com.java.socket.bio.client.thread.SocketClientThread;

public class SocketClient {
	private static final String TAG = SocketClient.class.getSimpleName();

    private SocketClientThread socketClientThread;

    public SocketClient(SocketClientResponseInterface socketClientResponseInterface) {
        socketClientThread = new SocketClientThread("socketClientThread", socketClientResponseInterface);
        socketClientThread.start();
        //ThreadPoolUtil.getInstance().addExecuteTask(socketClientThread);
    }

    public <T> void sendData(T data) {
        //convert to string or serialize object
        String s = (String) data;
        if (StringUtils.isEmpty(s)) {
            System.out.println(TAG+ ":sendData: 消息不能为空");
            return;
        }
        if (socketClientThread != null) {
            socketClientThread.sendMsg(s);
        }
    }

    public void stopSocket() {
        //一定要在子线程内执行关闭socket等IO操作
        new Thread(() -> {
            socketClientThread.setReConnect(false);
            socketClientThread.stopThread();
        }).start();
        //ThreadPoolUtil.getInstance().addExecuteTask(() -> {
        //    socketClientThread.setReConnect(false);
        //    socketClientThread.stopThread();
        //});
        //ThreadPoolUtil.getInstance().shutdown();
    }
}
