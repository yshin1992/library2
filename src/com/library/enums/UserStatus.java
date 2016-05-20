package com.library.enums;

public enum UserStatus {
	Normal(0),Cancel(1);
	int status;

	UserStatus(int status){
		this.status=status;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
