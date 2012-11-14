package com.example.android.momsone;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class titleActivity extends Activity {

	Handler mHandler;
	
	// ó��ȭ�� 0
	int splashSceneNumber;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	splashSceneNumber = 0;
    	
        super.onCreate(savedInstanceState);
        
        // ����� ������ ���� ����
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);  
        
        // �ڵ鷯 �������� ������ �޽����� ����
        mHandler = new Handler() {
        	public void handleMessage(Message msg) {
        		// ���� �ð��� Ÿ��Ʋ ����
        		startActivity(new Intent(titleActivity.this, loginActivity.class));
        		finish();
        		}
        };            
       
        // �ڵ鷯���� ���� �ð� �ڿ� ����ϴ� �༮ (���� 0 �ǹ� �𸣰���)
        mHandler.sendEmptyMessageDelayed(0, 2000);
        

        

    };
	
	
}
