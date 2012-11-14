package com.example.android.momsone;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class loginActivity extends Activity {

	 String forcelogin, proccmd, ret_url, log_ID,  log_Pwd, myResult;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // ���÷����� Ÿ��Ʋ�� ��� ������
        //startActivity(new Intent(this, titleActivity.class));
        
        // ����� ������ ���� ����
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        
        
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
        
        Button login_button_1 = (Button)findViewById(R.id.login_button1);
        login_button_1.setOnClickListener(mLoginListener);
        

        
    }
    
    
    
    
    private OnClickListener mLoginListener = new OnClickListener() {
    	public void onClick(View v) {
    		
            Intent myIntent, intentsub;

            log_ID = ((EditText)(findViewById(R.id.log_ID))).getText().toString(); 
            log_Pwd = ((EditText)(findViewById(R.id.log_Pwd))).getText().toString(); 
            HttpPostData();   // 서버와 자료 주고받기           
            // 로그인 결과 판별해서 액션..
            
            
            switch (v.getId()) {
            case R.id.login_button1:
            	
            		startActivity(new Intent(loginActivity.this, noticeActivity.class));
            		finish();

            	break;
            }
                     
            
    	}
    };
    
    

	public void HttpPostData() {
        try {
             //--------------------------
             //   URL 설정하고 접속하기
             //--------------------------
             URL url = new URL("http://www.gulumma.net/member/member/ajaxproc/");       // URL 설정
             HttpURLConnection http = (HttpURLConnection) url.openConnection();   // 접속
             //--------------------------
             //   전송 모드 설정 - 기본적인 설정이다
             //--------------------------
             http.setDefaultUseCaches(false);                                           
             http.setDoInput(true);                         // 서버에서 읽기 모드 지정
             http.setDoOutput(true);                       // 서버로 쓰기 모드 지정 
             http.setRequestMethod("POST");         // 전송 방식은 POST

             // 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
             http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
             //--------------------------
             //   서버로 값 전송
             //--------------------------
             
             StringBuffer buffer = new StringBuffer();
             buffer.append("forcelogin").append("=").append("").append("&");                 // php 변수에 값 대입
             buffer.append("proccmd").append("=").append("loginreq").append("&");   // php 변수 앞에 '$' 붙이지 않는다
             buffer.append("ret_url").append("=").append("").append("&");           // 변수 구분은 '&' 사용 
             buffer.append("log_ID").append("=").append(log_ID).append("&");
             buffer.append("log_Pwd").append("=").append(log_Pwd);
             Log.d("test : ","1111111111");
             
    
             	
             
             
             OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "EUC-KR");
             PrintWriter writer = new PrintWriter(outStream);
             writer.write(buffer.toString());
             writer.flush();
             
             
             Log.d("test : ","22222222");
             //--------------------------
             //   서버에서 전송받기
             //--------------------------
             
             InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "EUC-KR"); 
             BufferedReader reader = new BufferedReader(tmp);
             StringBuilder builder = new StringBuilder();
             String str;
             while ((str = reader.readLine()) != null) {       // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
                  builder.append(str + "\n");                     // View에 표시하기 위해 라인 구분자 추가
             }
             myResult = builder.toString();  
             
             // 전송결과를 전역 변수에 저장
             Log.d("test : ","33333"+myResult);
             
             //((TextView)(findViewById(R.id.text_result))).setText(myResult);
             //Toast.makeText(MainActivity.this, "전송 후 결과 받음", 0).show();
             
             
            
        } catch (MalformedURLException e) {
               //
        } catch (IOException e) {
               // 
        }// try

       
   } // HttpPostData
    
    
	
	
}
