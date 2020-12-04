package entity.Q5.Ex2;

public abstract class MobilePhone {
	private String	listen;
	private String call;
	private String sendMess;
	private String receiveMess;
	
	
	public String getListen() {
		return listen;
	}
	public void setListen(String listen) {
		this.listen = listen;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getSendMess() {
		return sendMess;
	}
	public void setSendMess(String sendMess) {
		this.sendMess = sendMess;
	}
	public String getReceiveMess() {
		return receiveMess;
	}
	public void setReceiveMess(String receiveMess) {
		this.receiveMess = receiveMess;
	}
	public MobilePhone(String listen, String call, String sendMess, String receiveMess) {
		super();
		this.listen = listen;
		this.call = call;
		this.sendMess = sendMess;
		this.receiveMess = receiveMess;
	}
	
	
	
}
