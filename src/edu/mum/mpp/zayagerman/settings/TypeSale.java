
package edu.mum.mpp.zayagerman.settings;

public enum TypeSale {
    HEALTHINSURANCE(0.10, "Health Insurance"),
    CARINSURANCE(0.07, "Car Insurance"),
    HOMEINSURANCE(0.12, "Home Insurance"),
    LIFEINSURANCE(0.11, "Life Insurance"),
    DISABILITYINSURANCE(0.09, "Disability Insurance");
    
	
    private TypeSale(Double percentage, String fullName) {
		this.percentage = percentage;
		this.fullName = fullName;
	}

	private Double percentage;
    private String fullName;

	TypeSale(Double percentage) {
        this.percentage = percentage;
    }

    public Double percentage() {
        return percentage;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
    

}