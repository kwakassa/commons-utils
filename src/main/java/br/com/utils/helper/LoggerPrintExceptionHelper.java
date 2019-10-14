package br.com.utils.helper;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerPrintExceptionHelper {
	
	private static Logger logger = Logger.getLogger(LoggerPrintExceptionHelper.class);
	
	public static void printExceptionOnLogger(Logger logger, Throwable e) {
    	if(logger != null && e != null){
			
			StringWriter stack = new StringWriter();
		    e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		}
    }
	
    public static void printExceptionOnLogger(Logger logger, Throwable e, String msgErro) {
    	if(logger != null && e != null){
			if(msgErro != null) {
				logger.error(msgErro);
			}
			StringWriter stack = new StringWriter();
		    e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		}
    }

    public static void printExceptionOnLogger(Logger logger, String msgErro) {
    	if(logger != null){
			if(msgErro != null) {
				logger.error(msgErro);
			}
		}
    }
    
    protected static void testaPilhaExcecao1(){
    	boolean executeBoth = true;
    	logger.setLevel(Level.DEBUG);
    	try{
    		System.out.println("Inicio");
    		Object x = new Integer(0);
    	    System.out.println((String)x);
    	    System.out.println("Fim");
    	}catch (Exception e){
    		logger.info("Logger Debbug: "+logger.isDebugEnabled());
    		if(executeBoth){
    			logger.info("Error com PrintWriter");
    			StringWriter stack = new StringWriter();
	    	    e.printStackTrace(new PrintWriter(stack));
	    	    logger.error(stack.toString());
	    	    logger.info("Error com logger.error(e)");
	    	    logger.error(e);
	    	    logger.info("Error com e.toString()");
	    	    logger.error(e.toString());
	    	    logger.info("Error com logger.error(e) com 2 argumentos");
	    	    logger.error("Mensagem Erro",e);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	testaPilhaExcecao1();
	}

}
