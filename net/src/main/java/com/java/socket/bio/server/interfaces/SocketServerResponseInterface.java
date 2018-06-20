package com.java.socket.bio.server.interfaces;

public interface SocketServerResponseInterface {
	  /**
     * 客户端断线回调
     */
    void clientOffline();

	/**
	 * 接收客户端消息
	 * @param socketResult
	 * @param code
	 */
	public void onSocketReceive(String socketResult, int code);
    /**
     * 客户端上线回调
     *
     * @param clientIp
     */
    void clientOnline(String clientIp);
}
