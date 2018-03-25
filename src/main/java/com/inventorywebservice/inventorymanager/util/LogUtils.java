package com.inventorywebservice.inventorymanager.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtils {
	private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);
		 public final static boolean DEBUG = true;    
		 public static void logDebug(String message) {
		  if (DEBUG) {
		    String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		    String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
		    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		    int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

		    logger.info(className + "." + methodName + "():" + lineNumber, message);
		  }
		 }
		 
		 public static void logDebug(String message, Throwable e) {
			  if (DEBUG) {
			    String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			    String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			    int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();

			    logger.info(className + "." + methodName + "():" + lineNumber+ "( "+ message + " )"+"\n",e);
			  }
			 }
}
