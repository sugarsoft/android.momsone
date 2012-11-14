package com.example.android.momsone;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class noticeActivity extends Activity {
	
	Button closebtn, notopenbtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        // ����� ������ ���� ����
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notice);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);  
        
        closebtn = (Button) findViewById(R.id.notice_close_btn);
        notopenbtn = (Button) findViewById(R.id.notice_notopen_btn);
        
        closebtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        notopenbtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("���� �ѹ� �������� ó���ؾ���");
			}
		});
        
    }
	
	
}
