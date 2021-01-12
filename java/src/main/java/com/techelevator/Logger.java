package com.techelevator;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Logger implements Closeable {
	
	private File logFile;
	private PrintWriter writer;
	
	public Logger (String path) throws IOException {
		this.logFile = new File(path);
		
		if (this.logFile.exists()) {
			writer = new PrintWriter(new FileWriter(this.logFile, true));  // true says we will be appending
		} else {
			writer = new PrintWriter(this.logFile);
		}
	}
	public void write(String logMessage) {
		writer.println(logMessage);
		writer.flush();
	}
	
	@Override
	public void close() throws IOException {
		writer.close();
	}
}