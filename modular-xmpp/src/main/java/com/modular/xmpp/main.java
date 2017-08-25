package com.modular.xmpp;

import java.io.IOException;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.stringprep.XmppStringprepException;

public class main {

	public static void main(String[] args) throws XmppStringprepException {
		
		try {
			
			XMPPTCPConnection con = new XMPPTCPConnection("igniterealtime.org", "");
			
			
			con.login("", "");
		} catch (XMPPException | SmackException | IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
