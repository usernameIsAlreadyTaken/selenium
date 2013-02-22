package org.chris.main;

import org.chris.action.LoginChannel;

public class Main {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			LoginChannel lc = new LoginChannel();
			lc.start();
		}
	}

}
