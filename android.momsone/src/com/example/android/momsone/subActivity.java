package com.example.android.momsone;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class subActivity extends Activity {
	        /** Called when the activity is first created. */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	            
	            //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	            setContentView(R.layout.activity_sub);
	            //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
	            
	            
	            ImageButton sub_button_1 = (ImageButton)findViewById(R.id.sub_Button_1);
	            sub_button_1.setOnClickListener( new View.OnClickListener() {
	               public void onClick(View v) {
	               // TODO Auto-generated method stub
	            	   finish(); // 액티비티를 종료합니다.
	               }              
	            });                
	 
	        }
}

