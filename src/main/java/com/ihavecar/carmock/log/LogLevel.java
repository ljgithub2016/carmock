package com.ihavecar.carmock.log;

/**
 * Created by lsz on 2016/12/5.
 */
public enum  LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4);
    
    private int level;
	
	private LogLevel(int level){
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
