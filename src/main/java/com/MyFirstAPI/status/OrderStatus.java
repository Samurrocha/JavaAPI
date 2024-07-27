package com.MyFirstAPI.status;


public enum OrderStatus {

	PAID(0),
	WAITING(1),
	CANCELED(2);
	
	
	private Integer code;
	
	
 OrderStatus() {
		
	}

private OrderStatus(int code) {

	this.code = code;
	
}
	
	
public Integer getCode() {
	return code;
}

public void setCode(Integer code) {
	
	this.code = code == null ? 0 : code;
	
}


public static OrderStatus valueOf(Integer code) {
	
	for (OrderStatus value : OrderStatus.values()) {
		
		if(value.getCode() == code) return value;
	}

	throw new IllegalArgumentException("Not exist this status");
}


}
