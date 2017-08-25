package com.modular.xmpp.listener;

import org.jivesoftware.smack.XMPPConnection;

public interface NotifyConnectionListener {
	public void notifyConnectting();
	public void notifyAuthenticated(XMPPConnection arg0);
	public void notifyConnected(XMPPConnection arg0);
	public void notifyConnectionClosed();
	public void notifyConnectionClosedOnError(Exception arg0);
}
