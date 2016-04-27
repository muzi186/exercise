package com.corejava.concurrency.blockingqueue;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TextFileSearcher {
	private static final int FILE_QUEUE_SIZE = 10;
	private static final int SEARCH_THREADS = 100;
	
	private static final File DUMMY = new File("");
	
	private BlockingQueue<File> candidates = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
	
	public void kickoff(){
		
	}

	public static void main(String[] args) {
		new TextFileSearcher().kickoff();
	}

}
