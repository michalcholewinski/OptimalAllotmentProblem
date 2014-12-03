package oap.utils.xml.enums;

public enum Role {
	ADMIN("ADMIN"),
	USER("USER");
	
	private Role(String roleName){
		this.roleName=roleName;
	}
	private String roleName;

	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
