package com.caps.model.beans;


public class UserAuth {
int attempts;
boolean lock;
long logtime;

public int getAttempts() {
	return attempts;
}
public void setAttempts(int attempts) {
	this.attempts = attempts;
}
public boolean isLock() {
	return lock;
}
public void setLock(boolean lock) {
	this.lock = lock;
}
public long getLogtime() {
	return logtime;
}
public void setLogtime(long logtime) {
	this.logtime = logtime;
}

}