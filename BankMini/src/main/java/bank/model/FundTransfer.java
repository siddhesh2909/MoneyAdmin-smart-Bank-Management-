package bank.model;

public class FundTransfer {
	String beneficiaryName;
	String accNo;
	String bankName;
	String ifscCode;
	double price;
	String type;
	String upiId;
	public FundTransfer(String beneficiaryName, String accNo, String bankName, String ifscCode, double price,
			String type, String upiId) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.accNo = accNo;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.price = price;
		this.type = type;
		this.upiId = upiId;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
}
