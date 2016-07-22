package com.corejava.io;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws URISyntaxException, IOException {
		String filepath = RandomAccessFileDemo.class.getResource("random-access.txt").toURI().toString().substring(5);
		// String dir = filepath.substring(0, filepath.lastIndexOf("/"));

		// System.out.println(dir);

		File f = new File(filepath);
		RandomAccessFile raf = new RandomAccessFile(f, "rw");

		System.out.println("write 1..10");

		for (int i = 1; i <= 10; i++) {
			raf.writeInt(i);
		}

		System.out.println("read back 1..10");
		raf.seek(0);
		int readint;
		do {
			try {
				readint = raf.readInt();
				System.out.print(readint);
				System.out.print(" ");
			} catch (EOFException e) {
				System.out.println("EOF");
				break;
			}
		} while (true);
		
		System.out.println("read and then write back the value of 10 times of current number");
		raf.seek(0);
		
		int multipliedInt;
		do{
			try {
				readint = raf.readInt();
				System.out.print(readint);
				System.out.print(" ");
				
				multipliedInt = 10*readint;
				raf.writeInt(multipliedInt);
			} catch (EOFException e) {
				System.out.println("EOF");
				break;
			}
		}while(true);
		
		System.out.println("print all numbers");
		raf.seek(0);
		do {
			try {
				readint = raf.readInt();
				System.out.print(readint);
				System.out.print(" ");
			} catch (EOFException e) {
				System.out.println("EOF");
				break;
			}
		} while (true);
		
		
		raf.close();
	}

}
