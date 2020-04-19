package com.Greenkart.qa.util;

public class TestUtil {

	public static final long PAGE_LOAD_TIMEOUT = 5000;
	public static final long IMPLICIT_WAIT = 5000;

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
