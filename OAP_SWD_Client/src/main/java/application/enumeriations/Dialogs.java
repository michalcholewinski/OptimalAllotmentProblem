package application.enumeriations;

public enum Dialogs {
	MAIN_PANEL("MainPanel"),
	FERRYMANS_MANAGEMENT("FerrymansManagement"),
	USERS_MANAGEMENT("UsersManagement"),
	USER_DETAILS("UserDetails"),
	FERRYMAN_DETAILS("FerrymanDetails"),
	OPTIMAL_ALLOTMENT_CALCULATION("OptimalAllotmentCalculation");
	
	private Dialogs(String name){
		this.name=name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

}
