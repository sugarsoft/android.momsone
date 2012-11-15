package com.example.android.momsone;

import com.example.android.momsone.Community.*;
import com.example.android.momsone.Education.*;
import com.example.android.momsone.iOneHome.*;
import com.example.android.momsone.iOneAlimi.*;
import com.example.android.momsone.iOneAlbum.*;
//import com.example.android.momsone.iOneAlbum.recent_album_list;
import com.example.android.momsone.iOneEtc.*;
import com.example.android.momsone.inc.Footer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	private ViewFlipper m_viewFlipper;
	private int m_nPreTouchPosX = 0;
	private int startView = 0;
	Footer footer;
	
	
	/// first modify    또 수정 맨날 수정

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        startActivity(new Intent(this, titleActivity.class));
		
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
        
        footer = (Footer) findViewById(R.id.layoutFooter);
        footer.setActivity(this);
    		    
        m_viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        m_viewFlipper.setOnTouchListener(MyTouchListener);	    
        
        startView = m_viewFlipper.getCurrentView().getId();
    
	           
        // 버튼 선언
        // 버튼 선언
        Button main_button_1 = (Button)findViewById(R.id.main_Button_1);
        main_button_1.setOnClickListener(mMainListener);
        Button main_Button_2 = (Button)findViewById(R.id.main_Button_2);
        main_Button_2.setOnClickListener(mMainListener);
        Button main_Button_3 = (Button)findViewById(R.id.main_Button_3);
        main_Button_3.setOnClickListener(mMainListener);
        Button main_Button_4 = (Button)findViewById(R.id.main_Button_4);
        main_Button_4.setOnClickListener(mMainListener);
        Button main_Button_5 = (Button)findViewById(R.id.main_Button_5);
        main_Button_5.setOnClickListener(mMainListener);
        Button main_Button_6 = (Button)findViewById(R.id.main_Button_6);
        main_Button_6.setOnClickListener(mMainListener);
        Button main_Button_7 = (Button)findViewById(R.id.main_Button_7);
        main_Button_7.setOnClickListener(mMainListener);
        Button main_Button_8 = (Button)findViewById(R.id.main_Button_8);
        main_Button_8.setOnClickListener(mMainListener);
        Button main_Button_9 = (Button)findViewById(R.id.main_Button_9);
        main_Button_9.setOnClickListener(mMainListener); 
        Button main_button_10 = (Button)findViewById(R.id.main_Button_10);
        main_button_10.setOnClickListener(mMainListener);
        
        Button main_button_11 = (Button)findViewById(R.id.main_Button_11);
        main_button_11.setOnClickListener(mMainListener);
        Button main_Button_12 = (Button)findViewById(R.id.main_Button_12);
        main_Button_12.setOnClickListener(mMainListener);
        Button main_Button_13 = (Button)findViewById(R.id.main_Button_13);
        main_Button_13.setOnClickListener(mMainListener);
        Button main_Button_14 = (Button)findViewById(R.id.main_Button_14);
        main_Button_14.setOnClickListener(mMainListener);
        Button main_Button_15 = (Button)findViewById(R.id.main_Button_15);
        main_Button_15.setOnClickListener(mMainListener);
        Button main_Button_16 = (Button)findViewById(R.id.main_Button_16);
        main_Button_16.setOnClickListener(mMainListener);
        Button main_Button_17 = (Button)findViewById(R.id.main_Button_17);
        main_Button_17.setOnClickListener(mMainListener);
        Button main_Button_18 = (Button)findViewById(R.id.main_Button_18);
        main_Button_18.setOnClickListener(mMainListener);
        Button main_Button_19 = (Button)findViewById(R.id.main_Button_19);
        main_Button_19.setOnClickListener(mMainListener); 	        
        Button main_button_20 = (Button)findViewById(R.id.main_Button_20);
        main_button_20.setOnClickListener(mMainListener);        

        Button main_button_21 = (Button)findViewById(R.id.main_Button_21);
        main_button_21.setOnClickListener(mMainListener);
        Button main_Button_22 = (Button)findViewById(R.id.main_Button_22);
        main_Button_22.setOnClickListener(mMainListener);
        Button main_Button_23 = (Button)findViewById(R.id.main_Button_23);
        main_Button_23.setOnClickListener(mMainListener);
        Button main_Button_24 = (Button)findViewById(R.id.main_Button_24);
        main_Button_24.setOnClickListener(mMainListener);
        Button main_Button_25 = (Button)findViewById(R.id.main_Button_25);
        main_Button_25.setOnClickListener(mMainListener);
        Button main_Button_26 = (Button)findViewById(R.id.main_Button_26);
        main_Button_26.setOnClickListener(mMainListener);
        Button main_Button_27 = (Button)findViewById(R.id.main_Button_27);
        main_Button_27.setOnClickListener(mMainListener);
        Button main_Button_28 = (Button)findViewById(R.id.main_Button_28);
        main_Button_28.setOnClickListener(mMainListener);
        Button main_Button_29 = (Button)findViewById(R.id.main_Button_29);
        main_Button_29.setOnClickListener(mMainListener); 	        
        Button main_button_30 = (Button)findViewById(R.id.main_Button_30);
        main_button_30.setOnClickListener(mMainListener);   
        
        Log.i("moms", "여기는 메인");
        

        
    }
    
    // 클릭에 따른 버튼 처리
    private OnClickListener mMainListener = new OnClickListener() {
        public void onClick(View v) {
            Intent myIntent, intentsub;
            switch (v.getId()) {
            
            
            	case R.id.main_Button_1:
                
            	// 원아알림장
            	intentsub = new Intent( MainActivity.this, notify_home_view.class );
            	startActivity(intentsub);
            	break;
            
            	case R.id.main_Button_2:
            	// 가정통신문
            	intentsub = new Intent( MainActivity.this, homereport_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_3:
            
            	//쪽지
            	intentsub = new Intent( MainActivity.this, receiveMsg_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_4:
            
            	//투약의뢰
            	intentsub = new Intent( MainActivity.this, medicine_list.class );
            	startActivity(intentsub);
                break;
            
            	case R.id.main_Button_5:
            
            	//출결관리
            	intentsub = new Intent( MainActivity.this, rollbook.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_6:
            	//식단표
            	intentsub = new Intent( MainActivity.this, diet_babyfood.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_7:
            	//1대1상담
            	intentsub = new Intent( MainActivity.this, mantoman.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_8:
            
            	//원정보
            	intentsub = new Intent( MainActivity.this, school_info.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_9:
            
            	//원소식
            	intentsub = new Intent( MainActivity.this, news_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_10:
            
            	//자유게시판
            	intentsub = new Intent( MainActivity.this, freeboard_list.class );
            	startActivity(intentsub);
                break;
                
                
                
            	case R.id.main_Button_11:
            
            	// 우리아이앨범
            	intentsub = new Intent( MainActivity.this, recent_album_list.class );
            	startActivity(intentsub);
            	break;
            
            	case R.id.main_Button_12:
            	// 실시간앨범
            	intentsub = new Intent( MainActivity.this, recent_album_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_13:
            	//행사앨범
           		intentsub = new Intent( MainActivity.this, festival_album_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_14:
            	//우리반앨범
            	intentsub = new Intent( MainActivity.this, class_album_list.class );
            	startActivity(intentsub);
                break;
            
            	case R.id.main_Button_15:
            		//우리반이야기
            	intentsub = new Intent( MainActivity.this, class_story_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_16:
            		//맘스원공지
            	intentsub = new Intent( MainActivity.this, moms_noti_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_17:
            		//맘스원제안
            	intentsub = new Intent( MainActivity.this, offer_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_18:
            		//교육육아비법
            	intentsub = new Intent( MainActivity.this, com_edu_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_19:
            		//사회정책토론
            	intentsub = new Intent( MainActivity.this, com_society_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_20:
            		//연예속닥속닥
            	intentsub = new Intent( MainActivity.this, com_enter_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_21:
            
            	// 유머2번지
            	intentsub = new Intent( MainActivity.this, com_humor_list.class );
            	startActivity(intentsub);
            	break;
            
            	case R.id.main_Button_22:
            	// 고민상담
            	intentsub = new Intent( MainActivity.this, com_worry_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_23:
            		//억울사연
            	intentsub = new Intent( MainActivity.this, com_unfair_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_24:
            		//정보공유
            	intentsub = new Intent( MainActivity.this, com_info_list.class );
            	startActivity(intentsub);
                break;
            
            	case R.id.main_Button_25:
            		//무료나눔
            	intentsub = new Intent( MainActivity.this, com_free_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_26:
            		//자유talk
            	intentsub = new Intent( MainActivity.this, com_talk_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_27:
            		//교육기관찾기
            	intentsub = new Intent( MainActivity.this, school_sch_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_28:
            		//교육기관유형
            	intentsub = new Intent( MainActivity.this, school_kindergarten.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_29:
            		//입학상담
            	intentsub = new Intent( MainActivity.this, entrance_list.class );
            	startActivity(intentsub);
                break;
                
            	case R.id.main_Button_30:
            		//대기신청내역
            	intentsub = new Intent( MainActivity.this, standby_list.class );
            	startActivity(intentsub);
                break;  
                
                
            }
 
        }
    };
    
    
    // 옵션 메뉴 호출
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.option, menu);
    	return true;
    }
    
    // 옵션 메뉴 선택시 액션
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch(item.getItemId()) {
    	case R.id.settings:
    		return true;
    	case R.id.logout:
    		return true;
    	case R.id.exit:
    		finish();
    		return true;
    	}    	
		return true;
	}
    
    

    private void MoveNextView()
    {
    	Log.d("moms","다음 이동");
    	
    	
    	m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.apear_from_right));
    	m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.disappear_to_left));
    	m_viewFlipper.showNext();
    	changeView();

    	
    	
    	
    	
    	
    }
     
    private void MovewPreviousView()
    {
    	Log.d("moms","이전 이동");
    	m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.apear_from_left));
    	m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.disappear_to_right));
    	m_viewFlipper.showPrevious();	
    	changeView();
    	
    	
    }
    
    private void changeView(){
    	
    	ImageView page_icon_1 = (ImageView)findViewById(R.id.imageView1);
    	ImageView page_icon_2 = (ImageView)findViewById(R.id.imageView2);
    	ImageView page_icon_3 = (ImageView)findViewById(R.id.imageView3);
    	ImageView page_icon_4 = (ImageView)findViewById(R.id.imageView4);    	
    	ImageView tab_title = (ImageView)findViewById(R.id.tab_title);    	
    	    
    	
    	if ( m_viewFlipper.getCurrentView().getId() == startView ) {
    		
    		page_icon_1.setBackgroundResource(R.drawable.main_1_on);
    		page_icon_2.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_3.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_4.setBackgroundResource(R.drawable.main_1_off);
    		tab_title.setBackgroundResource(R.drawable.h2_1);
    	
    	} else if ( m_viewFlipper.getCurrentView().getId() == startView+1 ) {
    		
    		page_icon_1.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_2.setBackgroundResource(R.drawable.main_1_on);
    		page_icon_3.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_4.setBackgroundResource(R.drawable.main_1_off);
    		tab_title.setBackgroundResource(R.drawable.h2_1);
    	
    	} else if ( m_viewFlipper.getCurrentView().getId() == startView+2 ) {
    		
    		page_icon_1.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_2.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_3.setBackgroundResource(R.drawable.main_1_on);
    		page_icon_4.setBackgroundResource(R.drawable.main_1_off);
    		tab_title.setBackgroundResource(R.drawable.h2_1);
    	
    	} else if ( m_viewFlipper.getCurrentView().getId() == startView+3 ) {
    		
    		page_icon_1.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_2.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_3.setBackgroundResource(R.drawable.main_1_off);
    		page_icon_4.setBackgroundResource(R.drawable.main_1_on);
    		tab_title.setBackgroundResource(R.drawable.h2_1);
    	
    	}    	
    	Log.d("flipper : ", ""+m_viewFlipper.getCurrentView().getId() );
    	
    }
    

    View.OnTouchListener MyTouchListener = new View.OnTouchListener()
    {
	    public boolean onTouch(View v, MotionEvent event)
	    {
	    	int s = (int)event.getX();
	    	Log.d("moms", s+"");
	    	
		    if (event.getAction() == MotionEvent.ACTION_DOWN)
		    {
		    	m_nPreTouchPosX = (int)event.getX();
		    }
	     
		    if (event.getAction() == MotionEvent.ACTION_UP)
		    {
		    	int nTouchPosX = (int)event.getX();
		     
			    if (nTouchPosX < m_nPreTouchPosX)
			    {
			    MoveNextView();
			    }
			    else if (nTouchPosX > m_nPreTouchPosX)
			    {
			    MovewPreviousView();
			    }
		     
			    m_nPreTouchPosX = nTouchPosX;
		    }
		    return true;
	    }
    };    
    
}
