package bank.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import bank.model.FundTransfer;
import bank.model.Recharge;

import bank.model.Register;
import bank.model.Transaction;

public class BankDaoImpl implements BankDao {
	Connection con;
	PreparedStatement pstate;
	ResultSet result;
	Statement state;

	@Override
	public int createRecord(List<Register> lst) {
		int i = 0;
		con = DBconnection.myConnection();
		Register rmodel = lst.get(0);
		try {
			pstate = con.prepareStatement(
					"INSERT INTO accounts (acc_holder, acc_uname, acc_mobno, acc_email, acc_pancard, acc_adharno, acc_password, acc_balance , date) VALUES (?,?,?,?,?,?,?,?,NOW());");
			pstate.setString(1, rmodel.getAccHolder());
			pstate.setString(2, rmodel.getAccUname());
			pstate.setString(3, rmodel.getMobileNo());
			pstate.setString(4, rmodel.getEmail());
			pstate.setString(5, rmodel.getPanNo());
			pstate.setString(6, rmodel.getAdharNo());
			pstate.setString(7, rmodel.getAccPassword());
			pstate.setDouble(8, rmodel.getAccBal());
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Register> Login(List<Register> lst) {
		List<Register> lstrecord = new LinkedList<>();
		con = DBconnection.myConnection();
		for (Register r : lst) {
			try {
				pstate = con.prepareStatement("SELECT * FROM accounts WHERE acc_uname=? AND acc_password=?");
				pstate.setString(1, r.getAccUname());
				pstate.setString(2, r.getAccPassword());
				ResultSet result = pstate.executeQuery();
				if (result.next()) {
					int accNumber = result.getInt("acc_number");
					String accHolder = result.getString("acc_holder");
					String accUname = result.getString("acc_uname");
					String MobileNo = result.getString("acc_mobno");
					String email = result.getString("acc_email");
					String panNo = result.getString("acc_pancard");
					String adharNo = result.getString("acc_adharno");
					String accPassword = result.getString("acc_password");
					float accBal = result.getFloat("acc_balance");
					Register rmode1 = new Register(accNumber, accHolder, accUname, MobileNo, email, panNo, adharNo,
							accPassword, accBal);
					lstrecord.add(rmode1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		;
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstrecord;
	}

	@Override
	public int Recharge(Recharge r, Register rg, String rechargeType) {
		int result = 0;

		try (Connection con = DBconnection.myConnection()) {
			con.setAutoCommit(false);
			String insertQuery = "";
			switch (rechargeType) {
			case "mobile(prepaid)":
				insertQuery = "INSERT INTO mobile_recharge (mob_no, provider, recharge_type, price, acc_number, recharge_date) VALUES (?, ?, ?, ?, ?, NOW())";
				break;
			case "mobile(postpaid)":
				insertQuery = "INSERT INTO mobile_recharge (mob_no, provider, recharge_type, price, acc_number, recharge_date) VALUES (?, ?, ?, ?, ?, NOW())";
				break;
			case "DTH":
				insertQuery = "INSERT INTO dth_recharge (cust_id, provider,price, acc_number, recharge_date) VALUES (?, ?, ?, ?, NOW())";
				break;
			case "electricity":
				insertQuery = "INSERT INTO electricity_bill (cust_id, provider, billing_unit, price, acc_number, bill_date) VALUES (?, ?, ?, ?, ?, NOW())";
				break;
			default:
				System.out.println("Invalid recharge type!");
				return result;
			}

			try (PreparedStatement pstateInsert = con.prepareStatement(insertQuery);
					PreparedStatement pstateUpdate = con.prepareStatement(
							"UPDATE accounts SET acc_balance = acc_balance - ? WHERE acc_number = ?")) {

				switch (rechargeType) {
				case "mobile(prepaid)":
					pstateInsert.setString(1, r.getMobNo());
					pstateInsert.setString(2, r.getProvider());
					pstateInsert.setString(3, r.getRecharge_type());
					pstateInsert.setDouble(4, r.getPrice());
					pstateInsert.setInt(5, rg.getAccNumber());
					break;
				case "mobile(postpaid)":
					pstateInsert.setString(1, r.getMobNo());
					pstateInsert.setString(2, r.getProvider());
					pstateInsert.setString(3, r.getRecharge_type());
					pstateInsert.setDouble(4, r.getPrice());
					pstateInsert.setInt(5, rg.getAccNumber());
					break;
				case "DTH":
					pstateInsert.setString(1, r.getCust_id());
					pstateInsert.setString(2, r.getProvider());
					pstateInsert.setDouble(3, r.getPrice());
					pstateInsert.setInt(4, rg.getAccNumber());
					break;
				case "electricity":
					pstateInsert.setString(1, r.getCust_id());
					pstateInsert.setString(2, r.getProvider());
					pstateInsert.setInt(3, r.getBilling_unit());
					pstateInsert.setDouble(4, r.getPrice());
					pstateInsert.setInt(5, rg.getAccNumber());
					break;
				}

				result = pstateInsert.executeUpdate();
				pstateUpdate.setDouble(1, r.getPrice());
				pstateUpdate.setInt(2, rg.getAccNumber());
				pstateUpdate.executeUpdate();

				con.commit();
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Transaction> DisplayHistory() {
		con = DBconnection.myConnection();

		List<Transaction> lstallrecords = new LinkedList<Transaction>();
		String str = "select * from transaction_history";

		try {
				state = con.createStatement();
				result = state.executeQuery(str);
				while (result.next()) {
				Transaction robj = new Transaction(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(5), result.getString(6), result.getTimestamp(7));
				lstallrecords.add(robj);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstallrecords;
	}

	@Override
	public int Transfer(Register r, FundTransfer f, String Type) {
		int result = 0;

		try (Connection con = DBconnection.myConnection()) {
			con.setAutoCommit(false);
			String insertQuery = "";
			String updateQuery1 ="";
			String updateQuery2 ="";
			System.out.println(r.getAccNumber());
			switch (Type) {
			case "NEFT":
				insertQuery = "INSERT INTO fund_transfer_neft (type, beneficiary_name, receivers_accNo, bank_name, ifsc_code, amount, acc_number, date) VALUES (?, ?, ?, ?, ?, ?, ?, NOW());";
				updateQuery1 ="UPDATE accounts SET acc_balance = acc_balance + ? WHERE acc_number = ?";
				updateQuery2 ="UPDATE accounts SET acc_balance = acc_balance - ? WHERE acc_number = ?";
				break;
			case "RTGS":
				insertQuery = "INSERT INTO fund_transfer_rtgs (type, beneficiary_name, receivers_accNo, bank_name, ifsc_code, amount, acc_number, date) VALUES (?, ?, ?, ?, ?, ?, ?, NOW());";
				updateQuery1 ="UPDATE accounts SET acc_balance = acc_balance + ? WHERE acc_number = ?";
				updateQuery2 ="UPDATE accounts SET acc_balance = acc_balance - ? WHERE acc_number = ?";
				break;
			case "UPI":
				insertQuery = "INSERT INTO fund_transfer_upi (receiver_upiid, amount, date, acc_number) VALUES (?, ?,NOW(),?)";
				updateQuery1 ="UPDATE accounts SET acc_balance = acc_balance + ? WHERE upi_id = ?";
				updateQuery2 ="UPDATE accounts SET acc_balance = acc_balance - ? WHERE acc_number = ?";
				break;
			default:
				System.out.println("Invalid Fund Transfer type!");
				return result;
			}

			try (PreparedStatement pstateInsert = con.prepareStatement(insertQuery);
				 PreparedStatement pstateUpdate1 = con.prepareStatement(updateQuery1);
				 PreparedStatement pstateUpdate2 = con.prepareStatement(updateQuery2)) {

				switch (Type) {
				case "NEFT":
					pstateInsert.setString(1, f.getType());
					pstateInsert.setString(2, f.getBeneficiaryName());
					pstateInsert.setString(3, f.getAccNo());
					pstateInsert.setString(4, f.getBankName());
					pstateInsert.setString(5, f.getIfscCode());
					pstateInsert.setDouble(6, f.getPrice());
					pstateInsert.setInt(7, r.getAccNumber());
					break;
				case "RTGS":
					pstateInsert.setString(1, f.getType());
					pstateInsert.setString(2, f.getBeneficiaryName());
					pstateInsert.setString(3, f.getAccNo());
					pstateInsert.setString(4, f.getBankName());
					pstateInsert.setString(5, f.getIfscCode());
					pstateInsert.setDouble(6, f.getPrice());
					pstateInsert.setInt(7, r.getAccNumber());
					break;
				case "UPI":
					pstate.setString(1, f.getUpiId());
					pstate.setDouble(2, f.getPrice());
					pstate.setInt(3, r.getAccNumber());
					break;
				}

				result = pstateInsert.executeUpdate();
				pstateUpdate1.setDouble(1, f.getPrice());
				if(f.getType().equals("UPI")) {
					pstateUpdate1.setString(2, f.getUpiId());
				}
				pstateUpdate1.setString(2, f.getAccNo());
				result =pstateUpdate1.executeUpdate();
				pstateUpdate2.setDouble(1, f.getPrice());
				pstateUpdate2.setInt(2, r.getAccNumber());
				result = pstateUpdate2.executeUpdate();
				
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	}
