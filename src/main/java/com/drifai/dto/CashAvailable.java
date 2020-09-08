package com.drifai.dto;

public class CashAvailable {
	private String clientId;
	private String fundId;
	private String cashAvailType;
	private String cashAvailSubtype;
	private String knowledgeDate;
	private String effectiveDate;
	private String currency;
	private double amount;
	
	
	public CashAvailable(String clientId, String fundId, String cashAvailType, String cashAvailSubtype,
			String knowledgeDate, String effectiveDate, String currency, double amount) {
		super();
		this.clientId = clientId;
		this.fundId = fundId;
		this.cashAvailType = cashAvailType;
		this.cashAvailSubtype = cashAvailSubtype;
		this.knowledgeDate = knowledgeDate;
		this.effectiveDate = effectiveDate;
		this.currency = currency;
		this.amount = amount;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getFundId() {
		return fundId;
	}
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	public String getCashAvailType() {
		return cashAvailType;
	}
	public void setCashAvailType(String cashAvailType) {
		this.cashAvailType = cashAvailType;
	}
	public String getCashAvailSubtype() {
		return cashAvailSubtype;
	}
	public void setCashAvailSubtype(String cashAvailSubtype) {
		this.cashAvailSubtype = cashAvailSubtype;
	}
	public String getKnowledgeDate() {
		return knowledgeDate;
	}
	public void setKnowledgeDate(String knowledgeDate) {
		this.knowledgeDate = knowledgeDate;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
