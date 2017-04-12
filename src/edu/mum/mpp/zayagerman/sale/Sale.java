package edu.mum.mpp.zayagerman.sale;

import java.time.LocalDate;

import edu.mum.mpp.zayagerman.client.ClientBasic;
import javax.persistence.*;

@Entity
@Table(name="Sale")
public class Sale {
	
	@Id @GeneratedValue
	@Column(name = "idSale")
	private int idSale;
	
	@Column(name = "typeSale")
    private TypeSale typeSale;
	
	@Column(name = "amount")
    private double amount;
	
	@Column(name = "percentGain")
    private double percentGain;
	
	@Column(name = "amountGain")
    private double amountGain;
	
	@Column(name = "dateSale")
    private LocalDate dateSale;
	
	@Column(name = "clientBasic")
    private ClientBasic clientBasic;
    
    public Sale() {
    }
    
	public Sale(int idSale, TypeSale typeSale, double amount, double percentGain, double amountGain, LocalDate dateSale, ClientBasic clientBasic) {
		super();
		this.idSale = idSale;
		this.typeSale = typeSale;
		this.amount = amount;
		this.percentGain = percentGain;
		this.amountGain = amountGain;
		this.dateSale = dateSale;
		this.clientBasic = clientBasic;
	}

	public int getIdSale() {
		return idSale;
	}
	
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	
	public TypeSale getTypeSale() {
		return typeSale;
	}
	
	public void setTypeSale(TypeSale typeSale) {
		this.typeSale = typeSale;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getPercentGain() {
		return percentGain;
	}
	
	public void setPercentGain(double percentGain) {
		this.percentGain = percentGain;
	}
	
	public double getAmountGain() {
		return amountGain;
	}
	
	public void setAmountGain(double amountGain) {
		this.amountGain = amountGain;
	}
	
	public LocalDate getDateSale() {
		return dateSale;
	}
	
	public void setDateSale(LocalDate dateSale) {
		this.dateSale = dateSale;
	}

	public ClientBasic getClientBasic() {
		return clientBasic;
	}

	public void setClientBasic(ClientBasic clientBasic) {
		this.clientBasic = clientBasic;
	}
}