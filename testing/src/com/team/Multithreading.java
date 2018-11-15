package com.team;

import com.notification.SendMail;

public class Multithreading {

	public static void main(String[] str) {
	       
        SendMail mail = com.notification.SendMailFactory.getMailInstance();
		try{
			String message="Hi "+"Upshot"+", You successfully login!";
		mail.send("vikky.softengi@gmail.com", "Login Success!", message);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}   

}
