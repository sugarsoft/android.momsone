package com.example.android.momsone.inc;


import com.example.android.momsone.R;
import com.example.android.momsone.R.id;
import com.example.android.momsone.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Footer extends LinearLayout {
	
	private Context mContext;
	private Button footerBtn,footerBtn2,footerBtn3,footerBtn4,footerBtn5;
	private Activity mActivity;

    public Footer(Context context, AttributeSet attrs) {
    	super(context, attrs);
    	
    	mContext = context;
    	
    	String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
 
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.footer, this, true);
 
        footerBtn = (Button) findViewById(R.id.footer_btn1);
        footerBtn.setOnClickListener(mFooterListener);
        footerBtn2 = (Button) findViewById(R.id.footer_btn2);
        footerBtn2.setOnClickListener(mFooterListener);
        
    }
    
 
    

 
    public void setActivity(Activity activity) {
        // set init otherwise of ctor and call externally...
        mActivity = activity;
    }
 
    // Create an anonymous implementation of OnClickListener
    private OnClickListener mFooterListener = new OnClickListener() {
        public void onClick(View v) {
            Intent myIntent;
            switch (v.getId()) {
            case R.id.footer_btn1:
            	mActivity.finish();
            	break;
            	
            case R.id.footer_btn2:
                //myIntent = new Intent(mContext, Activity2.class);
                Toast.makeText(mContext, "2번째 버튼이 눌려졌습니다", 0);
                //mActivity.startActivity(myIntent);
                break;
                
            case R.id.footer_btn3:
            	Toast.makeText(mContext, "3번째 버튼이 눌려졌습니다", 0);
            	break;
            }
 
        }
    };
    
    
}