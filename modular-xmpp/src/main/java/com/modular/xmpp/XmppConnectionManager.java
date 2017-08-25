package com.modular.xmpp;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;

import com.modular.xmpp.listener.NotifyConnectionListener;

/**
 * 管理连接
 * 
 * @author Arison
 *
 */
public class XmppConnectionManager {

	private String mXmppHost;
	private int mXmppPort;
	private String XmppDomain="";
	private String user="";
	private String password="";

	private XMPPConnection mConnection;
	//连接不属于同一个线程，需要回调连接状态
	private NotifyConnectionListener mNotifyConnectionListener;
	//构造方法
	public XmppConnectionManager(NotifyConnectionListener listener) {
		this.mNotifyConnectionListener=listener;
		mConnection = new XMPPTCPConnection(getConnectionConfiguration());
	}

	String getHost() {
		return mXmppHost;
	}

	int getPort() {
		return mXmppPort;
	}

	private XMPPTCPConnectionConfiguration getConnectionConfiguration() {
		XMPPTCPConnectionConfiguration configuration = null;
		try {
			configuration = XMPPTCPConnectionConfiguration.builder()
					.setXmppDomain(XmppDomain)//try catch
					.setUsernameAndPassword(user, password)
					.setHost(mXmppHost)
					.setPort(mXmppPort)
					.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
					.setCompressionEnabled(false)
					.setSendPresence(false)
					.setDebuggerEnabled(false)
					.build();
		} catch (XmppStringprepException e) {
			e.printStackTrace();
		}
		return configuration;
	}

}
