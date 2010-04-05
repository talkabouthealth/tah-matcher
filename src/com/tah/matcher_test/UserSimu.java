package com.tah.matcher_test;

import org.testng.annotations.Test;

import com.tah.matcher.TAHmatcher;


public class UserSimu {
  @Test
  public void UserBehaviorSimu() throws Exception {
	  int Uid = 31;
	  int Conv_Id = 100;
	  String Conv_Title = "This is a test conversation";
	  com.tah.matcher.ChatRoom_Req CRR;
	  CRR = new com.tah.matcher.ChatRoom_Req(Uid, Conv_Id, Conv_Title);
	  CRR.setCR_Info();
	  System.out.println(CRR.getCR_Info().getCR_Status());
	  System.out.println(CRR.getCR_Info().getCR_URL());
	  
	  
	// instantiate TAHmatcher and call matcher method sending CRR
	  TAHmatcher tm = new TAHmatcher(Uid, Conv_Id, Conv_Title);
	  tm.matcher();
	  System.out.println(tm.getUserList().size());
	  for(int i = 0; i < tm.getUserList().size(); i++){
		  System.out.println(tm.getUserList().get(i).getInviteeName() + " " +tm.getUserList().get(i).getInviteeIMAcc());
	  }
	  
	  
  }

}
