package bank.dao;

import java.util.List;

import bank.model.FundTransfer;
import bank.model.Recharge;
import bank.model.Register;
import bank.model.Transaction;

public interface BankDao {

	int createRecord(List<Register> lst);
	List<Register> Login(List<Register> lst);
	int Recharge(Recharge r, Register rg, String rechargeType);
	int Transfer(Register r, FundTransfer f , String Type);

	List<Transaction> DisplayHistory();
}