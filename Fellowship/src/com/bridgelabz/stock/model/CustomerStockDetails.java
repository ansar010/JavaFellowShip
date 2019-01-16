package com.bridgelabz.stock.model;

public class CustomerStockDetails 
{
	private int stockShare[];
	int share[];
	String name[];
	private String stockName[];
	
	public String[] getStockName() {

		return stockName;
	}
	public void setStockName(String productName[]) {
		this.stockName = productName;
	}
	public int[] getStockShare() {
		share=new int[stockShare.length];

		return stockShare;
	}
	public void setStockShare(int productShare[]) {
		this.stockShare = productShare;
	}
	
}
