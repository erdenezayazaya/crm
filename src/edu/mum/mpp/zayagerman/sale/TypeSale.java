
package edu.mum.mpp.zayagerman.sale;

public enum TypeSale {
    HEALTHINSURANCE(0.10),
    CARINSURANCE(0.07),
    HOMEINSURANCE(0.12),
    LIFEINSURANCE(0.11),
    DISABILITYINSURANCE(0.09);
    
    private Double percentage;

	TypeSale(Double percentage) {
        this.percentage = percentage;
    }

    public Double percentage() {
        return percentage;
    }

}