package com.yamiy.ayaka;

import javax.security.auth.login.LoginException;

import com.yamiy.ayaka.config.JDABasicConfig;

public class Ayaka {
	public static void main(String[] args) throws LoginException {
		JDABasicConfig.buildJDA();	
	}
}
