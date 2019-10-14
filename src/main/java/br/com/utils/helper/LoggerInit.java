package br.com.utils.helper;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggerInit {
	private static final Logger logger = Logger.getLogger(LoggerInit.class);
	private static ConsoleAppender console;
	private static FileAppender fa;
	
	public static void initConsoleAppender() {
		initConsoleAppender(Level.DEBUG);
	}
	
	public static void initConsoleAppender(Level level) {
		console = new ConsoleAppender();
		// configure the appender
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN));
		console.setThreshold(level);
		console.activateOptions();
		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(console);
		Logger.getRootLogger().setLevel(level);
	}
	
	public static void initFileAppender(String fileName) {
		initFileAppender(fileName,Level.DEBUG);
	}
	
	public static void initFileAppender(String fileName, Level level) {
		fa = new FileAppender();
		fa.setName("FileLogger");
		fa.setFile(fileName);
		fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		fa.setThreshold(Level.DEBUG);
		fa.setAppend(true);
		fa.activateOptions();

		// add appender to any Logger (here is root)
		Logger.getRootLogger().addAppender(fa);
		// repeat with all other desired appenders
		Logger.getRootLogger().setLevel(level);
	}
	
	public static void main(String[] args) {
		LoggerInit.initConsoleAppender();
		System.out.println(logger.getLevel());
		logger.debug("Teste em Level DEBUG");
	}

}
