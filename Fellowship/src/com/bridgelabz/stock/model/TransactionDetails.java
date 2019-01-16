package com.bridgelabz.stock.model;

import java.time.LocalTime;

public class TransactionDetails 
{
	private long id;
	private String customerName;
	private String stockName;
	private long NumberOfShare;
	private String date;
	private LocalTime time;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getNumberOfShare() {
		return NumberOfShare;
	}
	public void setNumberOfShare(long numberOfShare) {
		NumberOfShare = numberOfShare;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	private String mode;
}
