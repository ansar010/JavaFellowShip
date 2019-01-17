package stockManagement;

import java.time.LocalTime;

public class TransactionInJson
{
	private long id;
	private String customerName;
	private String stockName;
	private long NumberOfShare;
	private String date;
	private LocalTime time;
	private String mode;//buy or sell
	
	public long getId() {
		return id;
	}
	public void setId(Long customerId) {
		this.id = customerId;
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
}
