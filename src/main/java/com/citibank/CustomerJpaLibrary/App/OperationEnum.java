package com.citibank.CustomerJpaLibrary.App;

public enum OperationEnum {

	ADDCUSTOMER(1),DISPLAYCUSTOMER(2),UPDATECUSTOMER(3),DELETECUSTOMER(4),ADDORDERS(5),VIEWORDERS(6),UPDATEORDERS(7),DELETEORDERS(8),PAYMENT(9), UNKNOWN(-1);

	private int option;
	OperationEnum(int option) {
		this.option = option;
	}
	
	public int getOption() {
		return option;
	}
	
	public static OperationEnum getMatchingOperation(int option) {
		for (OperationEnum operation : OperationEnum.values()) {
			if (operation.getOption() == option) {
				return operation;
			}
		}
		
		return UNKNOWN;
	}
}