package com.android.thread.io;

import java.io.PipedOutputStream;

/**
 * д�߳�
 * @author Arison
 *
 */
public class Writer extends Thread {
    
	private PipedOutputStream  pos;
	

	public Writer(PipedOutputStream pos) {
		super();
		this.pos = pos;
	}


	@Override
	public void run() {
		
	}
}
