package cn.edu.lingnan.test;

import cn.edu.lingnan.dao.WorkDAO;
import cn.edu.lingnan.dto.Work;

public class WorkTest {
	public static void main(String[] args) {
		Work w = new Work();
		WorkDAO wd = new WorkDAO();
		w.setwId("w04");
		w.setwName("w04");
		System.out.println(wd.updateWork(w));
	}
}
