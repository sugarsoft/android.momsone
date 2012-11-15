package com.example.android.momsone.iOneHome;

import com.example.android.momsone.R;
import com.example.android.momsone.inc.SetImage;
import com.example.android.momsone.inc.Upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class Msg_write extends Activity {

	final int TAKE_GALLERY = 0;
	final int TAKE_CAMERA = 1;
	final int RESULT_OK = -1;
	int img_cnt = 1;
	ImageView[] ivImage = new ImageView[4];
	String [] ivsrc = new String[4]; 
			
			/** Called when the activity is first created. */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	            
	            //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	            setContentView(R.layout.msg_write);
	            //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
	            Button button_1 = (Button)findViewById(R.id.photo_append_btn);
	            button_1.setOnClickListener(mPhotoListener);
	            
	            Button button_2 = (Button)findViewById(R.id.upload_btn);
	            button_2.setOnClickListener(mPhotoListener);
	            
	            // 배열에 넣어야하기 때문에 코드랑 이미지뷰 ID값이랑 차이가 난다.
    			ivImage[0] = (ImageView)findViewById(R.id.imageView1);
    			ivImage[1] = (ImageView)findViewById(R.id.imageView2);
    			ivImage[2] = (ImageView)findViewById(R.id.imageView3);
    			ivImage[3] = (ImageView)findViewById(R.id.imageView4);
	        }
	        
	        private OnClickListener mPhotoListener = new OnClickListener()  {
	        	 public void onClick(View v) {
	        		 Intent myIntent;
	        		 switch (v.getId()) {
	        		 // 사진 첨부하기
	        		 	case R.id.photo_append_btn:
	        		 		int ii;
	        				// 찍은 사진의 path값을 배열을 확인하여 빈 곳에 집어넣는다.
	        				for(ii=0;ii < ivsrc.length; ii++) {
	        					//Log.d("moms",ivsrc[ii]);
	        					if(ivsrc[ii] == null || ivsrc[ii].equals("")){
	        						img_cnt = ii;
	        						break;
	        					}
	        				}
	        				// 카운트를 전부 돌아도 빈 곳이 없다면 더이상 이미지를 추가할 수 없음.
	        				if(ii==ivsrc.length) {
	        					Toast.makeText(getBaseContext(), "더 이상 이미지를 추가하실 수 없습니다.", 0);
	        					return;
	        				}
	        				
	        		 		// 갤러리를 통해 이미지 가져오기
	        		 		Intent intent = new Intent();
	        		 		// 카메라 기능
	        		 		//intent.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	        		 		  intent.setAction( Intent.ACTION_GET_CONTENT );  
	        		 		  intent.setType( "image/*" );
	        		 		  startActivityForResult( intent, TAKE_GALLERY );
	        		 		 //startActivityForResult( intent, TAKE_CAMERA );
	        		 		  
	        		 		break;
	        		 	case R.id.upload_btn:
	        		 		Log.d("moms","버튼 눌림");
	        		 		Upload.setText("01","text");
	        		 		//Upload.executeMultipart(ivsrc[0]);
	        		 		break;
	        		 	
	        		 
	        		 }
	        	 }
	        };

	        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        	SetImage setImage = new SetImage( ) ;
	        	
	        	
	        	
	        		if( resultCode == RESULT_OK )
	        	 {
	    				String tempPictuePath = null;
						
						// 카메라로 찍었을 떄
	        			if( requestCode == TAKE_CAMERA ) //1
	        			{
	        				Log.d("moms","카메라입니다");
	        				if( data == null) return ;
	        				// 찍은 사진을 이미지뷰에 보여준다.
	        				Bitmap bm = (Bitmap) data.getExtras().get( "data" ); 
	        				setImage.setCameraImage( bm, ivImage[1], tempPictuePath ) ;
	        			}
	        	     
	        			// 앨범에서 가져올 때
	        			else if( requestCode == TAKE_GALLERY )
	        			{
	        				Uri currImageURI = data.getData( );
	        				String path = setImage.getRealPathFromURI( currImageURI,this ) ;
	        				//String path = data.toString();
	        				tempPictuePath = path ; 
	        				ivsrc[img_cnt] = path;
	        				// 찍은 사진을 이미지뷰에 보여준다.
	        				Log.d("moms", "코드 : " + requestCode + ", 리절트 : " + resultCode + ", 주소 : " + data.getData());
	        				Log.d("moms", "카운트 : " + img_cnt + ", 주소" + ivsrc[img_cnt]);
	        				setImage.setAlbumImage( path, ivImage[img_cnt] ) ;
	        				
	        				//setImage.setAlbumImageBackground( path, ivCardImage ) ;
	        			}
	        	 }
	        		else
	        		{
	        			System.out.println( "camera return error" ) ;
	        			return ;
	        		}
	        }
	        
}
