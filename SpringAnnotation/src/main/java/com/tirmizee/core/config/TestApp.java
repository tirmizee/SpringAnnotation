package com.tirmizee.core.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestApp {

	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		System.out.println(encoder.encode("test"));
	}

}
