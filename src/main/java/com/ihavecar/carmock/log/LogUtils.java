package com.ihavecar.carmock.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * Created by lsz on 2016/12/5.
 */
public class LogUtils {
	
	static String loggerName ="com.ihavecar.carmock";
	
	static Logger logger = LoggerFactory.getLogger(loggerName);
	
    static Gson gson = new Gson();
    
    public static void log(String msg,Object ... formatParam){
        log(LogLevel.INFO,msg,formatParam);
    }
    
    public static void log(LogLevel logLevel,String msg,Object ... formatParam){
        String content = "";
        if(formatParam == null || formatParam.length == 0 ){
            content = msg;
        }else {
            content = String.format(msg,formatParam);
        }
        //System.out.println(logLevel.name()+":"+content);
        printLog(logLevel, content);
    }
    
	private static void printLog(LogLevel level, String message) {
		switch (level) {
		case DEBUG: {
			logger.debug(message);
			break;
		}
		case INFO: {
			logger.info(message);
			break;
		}
		case WARN: {
			logger.warn(message);
			break;
		}
		case ERROR: {
			logger.error(message);
			break;
		}
		default: {
			logger.info(message);
			break;
		}
		}
	}
    
    public static void logJson(LogLevel logLevel,Object object){
        System.out.println(logLevel.name()+":"+(gson.toJson(object)));
    }
    public static String toJSON(Object obj){
        return gson.toJson(obj);
    }
}
