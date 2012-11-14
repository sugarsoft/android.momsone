package com.example.android.momsone;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class sub_1 extends Activity {
	


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 헤더에 보여줄 내용 정의
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.sub_1);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header2);        
        
     
        

    }
	
	
}
