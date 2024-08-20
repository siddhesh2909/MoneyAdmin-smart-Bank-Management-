package bank.model;

public class Register {
    private int accNumber;
    private String accHolder;
    private String accUname;
    private String mobileNo;
    private String email;
    private String panNo;
    private String adharNo;
    private String accPassword;
    private double accBal;
    
    public Register(String accUname, String accPassword) {
		super();
		this.accUname = accUname;
		this.accPassword = accPassword;
	}

	public Register(int accNumber, String accHolder, String accUname) {
		super();
		this.accNumber = accNumber;
		this.accHolder = accHolder;
		this.accUname = accUname;
	}

	public Register(int accNumber, String accHolder, String accUname, String mobileNo, String email, String panNo,
            String adharNo, String accPassword, double accBal) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.accUname = accUname;
        this.mobileNo = mobileNo;
        this.email = email;
        this.panNo = panNo;
        this.adharNo = adharNo;
        this.accPassword = accPassword;
        this.accBal = accBal;
    }
    
    public Register(String accHolder, String accUname, String mobileNo, String email, String panNo, String adharNo,
            String accPassword, double accBal) {
        this.accHolder = accHolder;
        this.accUname = accUname;
        this.mobileNo = mobileNo;
        this.email = email;
        this.panNo = panNo;
        this.adharNo = adharNo;
        this.accPassword = accPassword;
        this.accBal = accBal;
    }
    

    public Register() {
    }

    public int getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }
    public String getAccHolder() {
        return accHolder;
    }
    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }
    public String getAccUname() {
        return accUname;
    }
    public void setAccUname(String accUname) {
        this.accUname = accUname;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPanNo() {
        return panNo;
    }
    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
    public String getAdharNo() {
        return adharNo;
    }
    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }
    public String getAccPassword() {
        return accPassword;
    }
    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }
    public double getAccBal() {
        return accBal;
    }
    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }
}
