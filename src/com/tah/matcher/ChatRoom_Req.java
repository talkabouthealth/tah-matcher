package com.tah.matcher;

public class ChatRoom_Req {
	private int uid;
	private int Conv_Id;
	private String Conv_Title;
	private ChatRoom_Info CR_Info;
	public ChatRoom_Req(){
		uid = 0;
		Conv_Id = 0;
		Conv_Title = null;
		CR_Info = null;
		
	}
	public ChatRoom_Req(int Uid, int C_Id, String C_Tit){
		uid = Uid;
		Conv_Id = C_Id;
		Conv_Title = C_Tit;	
		CR_Info = new ChatRoom_Info();
		
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setConv_Id(int conv_Id) {
		Conv_Id = conv_Id;
	}
	public int getConv_Id() {
		return Conv_Id;
	}
	public void setConv_Title(String conv_Title) {
		Conv_Title = conv_Title;
	}
	public String getConv_Title() {
		return Conv_Title;
	}
	public int Req_Status(){
		return 3;
	}
	public String Re_ChatRoomUrl(){
		return "http://www.google.com";
	}
	public void setCR_Info() {
		CR_Info.setCR_Status(5);
		CR_Info.setCR_URL("http://www.google.com/");
	}
	public ChatRoom_Info getCR_Info() {
		return CR_Info;
	}
	public ChatRoom_Info getChatRoom_Info(){
		return CR_Info;
	}
	
	
}
