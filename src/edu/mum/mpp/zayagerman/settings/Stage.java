package edu.mum.mpp.zayagerman.settings;

public enum Stage {
    PROSPECTING("Prospecting"),
    NEEDS_ANALYSIS("Needs Analysis"),
    PROPOSAL("Proposal"),
    NEGOTIATION("Negotiation"),
    CLOSED_WON("Closed Won"),
    CLOSED_LOST("Closed Lost");
    
    private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private Stage(String fullName) {
		this.fullName = fullName;
	}
	
	
}