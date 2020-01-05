package cn.edu.lingnan.test;

import cn.edu.lingnan.dao.BudgetDAO;
import cn.edu.lingnan.dto.Budget;

public class BudgetTest {
	
	public static void main(String[] args) {
		Budget b = new Budget();
		b.setmId("m01");
		b.setwId("w01");
		b.setbCost(700);
		BudgetDAO bd = new BudgetDAO();
		System.out.println(bd.insertInfoToBudget(b));
	}
	
}
