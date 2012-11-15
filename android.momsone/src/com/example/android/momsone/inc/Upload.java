package com.example.android.momsone.inc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;

public class Upload {

	// 전송 데이터 구분자
	public static String boundary = "SpecificString";
	
	//텍스트값 처리
	public static void setText(String no, String text){
		StringBuilder builder = new StringBuilder();

	}

	//이미지값 처리
	private String setImage(String iname, String image){
		//SendSet();
	return "Content-Disposition: form-data; name=\""+iname+"\"; filename=\""+image+"\"\r\n";
	}

	public URLConnection SendSet() throws IOException {
		  // 전송 준비
		URLConnection con = null;
	  try{
		  // http://www.dbapps.kr/moms/act.php
		  URL url = new URL("http://www.dbapps.kr/moms/act.php");
		  con = url.openConnection();
		  con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		  con.setDoOutput(true);
	  } catch (Exception e) {
		  Log.d("moms",e.toString());
	  }
	   return con;
	 }


}