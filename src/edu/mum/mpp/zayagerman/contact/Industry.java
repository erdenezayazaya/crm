package edu.mum.mpp.zayagerman.contact;

public class Industry {

    private String name;
    private boolean state;

    public Industry() {
    }    

	public Industry(String name, boolean state) {
		super();
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}    
}