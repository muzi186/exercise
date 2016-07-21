package com.corejava.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URISyntaxException;

public class SequenceInputStreamDemo {
	static final String INPUT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		try {
			test();
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}

	private static void test() throws IOException {
		File f = createInputFile();
		InputStream is1 = new FileInputStream(f);
		InputStream is2 = new ByteArrayInputStream(INPUT_CHARS.getBytes());

		SequenceInputStream sis = new SequenceInputStream(is1, is2);
		int readbyte = -1;
		do {
			readbyte = sis.read();
			if (readbyte != -1) {
				System.out.print((char) readbyte);
				System.out.print(" ");

			} else {
				System.out.println();
				System.out.println(readbyte);
			}
		} while (readbyte != -1);
	}

	private static File createInputFile() {
		try {
			String filepath = SequenceInputStreamDemo.class.getResource("alphabet.txt").toURI().toString().substring(5);
			System.out.println("input file:" + filepath);

			return new File(filepath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

}
