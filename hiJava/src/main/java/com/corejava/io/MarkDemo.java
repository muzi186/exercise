package com.corejava.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * test how mark works in InputStream
 * @author gavin
 *
 */
public class MarkDemo {
	static final String INPUT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		byte[] inputBytes = INPUT_CHARS.getBytes();
		
		ByteArrayInputStream bais1 = new ByteArrayInputStream(inputBytes);

		ByteArrayInputStream bais2 = new ByteArrayInputStream(inputBytes, 2, 60);
		
		System.err.println("*** test bais1  ***");
		System.out.println("bais1 available: "+bais1.available());
		int readByte = -1;
		boolean repeatOnce = true;
		do{
			readByte = bais1.read();
			if(readByte != -1){
				System.out.print((char) readByte);
				System.out.print(" ");
				
				char c = (char)readByte;
				if(c == 'K'){
					bais1.skip(3);
				}
				
				if(c == 'W'){
					bais1.mark(0);
				}
				
				if(c == 'Z' && repeatOnce){
					bais1.reset();
					repeatOnce = false;
				}
			} else {
				System.out.println(readByte);
			}
		}while(readByte != -1);
		

		System.out.println();
		System.err.println("*** test bais2  ***");
		System.out.println("bais2 available: "+bais2.available());
		readByte = -1;
		do {
			readByte = bais2.read();
			if (readByte != -1) {
				System.out.print((char) readByte);
				System.out.print(" ");
			} else {
				System.out.println(readByte);
			}
		} while (readByte != -1);

		try {
			bais2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
