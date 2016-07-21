package com.gl.designpattern.decorator.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GrepReader extends FilterReader{
	protected BufferedReader in;
	private String keyWord;
	
	public GrepReader(FileReader f, String keyWord){
		super(f);
		this.in = new BufferedReader(f);
		this.keyWord= keyWord;
	}

	public Map<Integer,String> readLines() throws IOException{
		Map<Integer,String> foundLines = new HashMap<Integer,String>();
		String line;
		Integer lineNumber = 0;
		do{
			 line = this.in.readLine();
			 lineNumber++;
			 if((line != null ) && (line.indexOf(keyWord) >= 0)){
				 foundLines.put(lineNumber, line);
			 }
		}while(line != null);
		
		return foundLines;
	}

}
