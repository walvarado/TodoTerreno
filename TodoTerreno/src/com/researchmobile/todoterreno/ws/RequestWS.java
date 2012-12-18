package com.researchmobile.todoterreno.ws;

import org.json.JSONObject;
import com.researchmobile.todoterreno.entity.LoginEntity;


public class RequestWS {
	private static String WS_LOGIN = "login.php?";
	
	@SuppressWarnings("unused")
public LoginEntity login(String usuario, String password){
	String url = WS_LOGIN + "usuario=" + usuario + "&" + "password=" + password;
	
	JSONObject objectJson = ConnectWS.obtenerJson(url);
	
	return null;
	
}	

}
