package com.corejava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		try {
			testFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testFileInputStream() throws IOException {
		File f = createInputFile();

		InputStream is = null;
		try {
			is = new FileInputStream(f);
			int readbyte = -1;

			do {
				readbyte = is.read();
				if (readbyte != -1) {
					System.out.print((char) readbyte);
					System.out.print(" ");

				} else {
					System.out.println();
					System.out.println(readbyte);
				}
			} while (readbyte != -1);
		} finally {
			if (is != null) {
				is.close();
			}
		}
		
		System.out.println(byte.class);

	}

	private static File createInputFile() {
		try {
			String filepath = FileInputStreamDemo.class.getResource("alphabet.txt").toURI().toString().substring(5);
			System.out.println("input file:" + filepath);

			return new File(filepath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

}
