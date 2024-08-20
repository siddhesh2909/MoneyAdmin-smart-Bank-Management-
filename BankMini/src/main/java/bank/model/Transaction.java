package bank.model;
import java.sql.Timestamp;
public class Transaction {
	private String tId;
	private String tType;
	private double price;
	private String tSender;
	private String tReceiver;
	private String accNo;
	private java.sql.Timestamp timestamp;
	public Transaction(String tId, String tType, double price, String tSender, String tReceiver, String accNo,
			Timestamp timestamp) {
		super();
		this.tId = tId;
		this.tType = tType;
		this.price = price;
		this.tSender = tSender;
		this.tReceiver = tReceiver;
		this.accNo = accNo;
		this.timestamp = timestamp;
	}

	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String gettSender() {
		return tSender;
	}
	public void settSender(String tSender) {
		this.tSender = tSender;
	}
	public String gettReceiver() {
		return tReceiver;
	}
	public void settReceiver(String tReceiver) {
		this.tReceiver = tReceiver;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}