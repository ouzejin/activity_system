package cn.edu.lingnan.dto;

public class Budget {
	
	private String mId;
	private String wId;
	private String bCost;
	private String aCost;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getwId() {
		return wId;
	}
	public void setwId(String wId) {
		this.wId = wId;
	}
	
	//预计消费
	public String getbCost() {
		return bCost;
	}
	public void setbCost(String bCost) {
		this.bCost = bCost;
	}
	
	//实际消费
	public String getaCost() {
		return aCost;
	}
	public void setaCost(String aCost) {
		this.aCost = aCost;
	}

}
