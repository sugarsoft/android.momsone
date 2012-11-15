package com.example.android.momsone.inc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.example.android.momsone.iOneHome.Msg_write;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;





public class SetImage {
	
	public String getRealPathFromURI(Uri contentURI,Context mContext) {
		try {
		String [] proj = {MediaStore.Images.Media.DATA};
		Cursor cursor = mContext.getContentResolver().query(contentURI, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
		} catch (Exception e) {
			Log.d("moms",e.toString());
			return "fail";
		}
		
		
	}
	
	// 이미지 리사이징
		Drawable resize( String path )
		{
			/// 비트맵 저장할 변수를 하나 생성한다.
		    Bitmap bmp ;
		    /// 이미지 불러올때 사용할 옵션을 만든다.
		    BitmapFactory.Options options2 =  new BitmapFactory.Options( );
		    /// 이미지 가져올때 샘플링할 옵션
		    /// 값이 클수록 작게 가져온다.
		    options2.inSampleSize = 4 ;
		    
		    /// 해당 옵션을 사용하여 이미지를 가져온다.
		    /// 아래 줄에서 실제 이미지를 메모리에 전부 로드하지는 않는다.
		    bmp = BitmapFactory.decodeFile( path, options2 ) ;
		    
		    /// 가져온 이미지가 Bitmap(비트맵)이라서 Drawable로 바꿔줘야한다.
		    /// Drawable형태의 Bitmap로 바꾼다.
		    /// 실제 메모리에 이미지를 로드한다.
		    BitmapDrawable dbmp = new BitmapDrawable( bmp );
		    /// Drawable 형태로 형변환 해서 반환한다.
		    return (Drawable)dbmp ;
		}
		
		/*
		 * setCameraImageBackground, setAlbumImageBackground
		 * 위 두개는 이미지뷰의 사이즈에 꽉 차게 세팅한다.
		 * 
		 * setCameraImageDrawable, setAlbumImageDrawble
		 * 위 두개는 이미지의 비율에 맞춰 세팅한다.
		 * 단 ImageView에 android:scaleType="fitStart" 옵션을 설정하는걸 잊지말자
		 */
		
		// 카메라로 찍은 사진을 이미지뷰에 세팅
		public void setCameraImageBackground( Bitmap bm, ImageView iv, String tempPictuePath )
		{
			BitmapDrawable bmd = new BitmapDrawable( bm ) ;
			
			// tempPictuePath는 사진 저장 경로를 바꾼 다음 카메라로 사진을 찍었을 때 파일의 경로이다.
			File copyFile = new File( tempPictuePath ) ;
		    try 
		    {
		    	copyFile.createNewFile( ) ;
				OutputStream out = null;
				out = new FileOutputStream(copyFile);
				bm.compress(CompressFormat.JPEG, 70, out) ;
				out.close( ) ;
				
				if( copyFile.exists( ) && copyFile.length( ) > 0 ) /// 성공적으로파일이 저장되어 존재함
				{
					//DrawaleResize resize = new DrawbleResize( ) ;
					//Drawable dr = resize.resize( tempPictuePath ) ;
					//iv.setBackgroundDrawable( dr ) ;
				}
				else
				{
					
				}
			} 
		    catch( Exception e ) 
		    {
				e.printStackTrace();
			}
		}
		
		
		
		
		// 카메라로 찍은 사진을 이미지뷰에 세팅
		public void setCameraImage( Bitmap bm, ImageView iv, String tempPictuePath )
		{
			BitmapDrawable bmd = new BitmapDrawable( bm ) ;
			
			// tempPictuePath는 사진 저장 경로를 바꾼 다음 카메라로 사진을 찍었을 때 파일의 경로이다.
			File copyFile = new File( tempPictuePath ) ;
		    try 
		    {
		    	copyFile.createNewFile( ) ;
				OutputStream out = null;
				out = new FileOutputStream(copyFile);
				bm.compress(CompressFormat.JPEG, 70, out) ;
				out.close( ) ;
				
				if( copyFile.exists( ) && copyFile.length( ) > 0 ) /// 성공적으로파일이 저장되어 존재함
				{

					//DrawbleResize resize = new DrawbleResize( ) ;
					//Drawable dr = resize.resize( tempPictuePath ) ;
					//iv.setImageDrawable( dr ) ;
					//iv.setBackgroundDrawable( dr ) ;
				}
				else
				{
					
				}
			} 
		    catch( Exception e ) 
		    {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		// 앨범에서 가져온 사진을 이미지뷰에 세팅
		public void setAlbumImageBackground( String path, ImageView iv )
		{
	        BitmapFactory.Options options = new BitmapFactory.Options( ) ; 	// 비트맵 이미지의 옵션 받을 변수 생성
	        options.inJustDecodeBounds = true;  							// 비트맴을 바로 로드하지 말고 옵션만 받아오라고 설정
	        BitmapFactory.decodeFile( path, options ); 					// 매트맵을 읽는데 윗줄에 의해 옵션만 받아오고 비트맵 다 읽지는 않음
/*
			/// 이미지의 높이를 얻음
	        int fscale = options.outHeight ;
	        int img_scale = iv.getHeight();
	        if( options.outWidth > options.outHeight )	// 이미지의 높이보다 넓이가 클 경우
	        {
	        	fscale = options.outWidth ;				// 이미지의 넓이를 스케일에 저장
	        	img_scale = iv.getWidth(); 	
	        }

	        Bitmap bmp ;	// 실제 이미지를 저장할 변수
	        
        
			/// 이미지의 넓이가 이미지 뷰보다 크면
	        if( img_scale < fscale )
	        {
	        	        // 이미지를 강제적으로 img_view에 맞춰서 변경하기
	        BitmapFactory.Options options2 = new BitmapFactory.Options();
	        options2.outHeight = iv.getHeight();
	        options2.outWidth = iv.getWidth();
				/// 이미지의 사이즈를 img_width 나눈 만큼 리사이징 할거다
	        	fscale = fscale / img_scale ;
				/// 새 비트맵 옵션 생성
		        BitmapFactory.Options options2 = new BitmapFactory.Options();
		        options2.inSampleSize = fscale ;	/// 리사이징할 비율 설정
		        bmp = BitmapFactory.decodeFile( path, options2 ) ;	/// 실제로 비트맵을 읽어온다.
	        }
	        else
	        {	/// 사이즈가 적당 하면 그냥 읽는다.
	        	bmp = BitmapFactory.decodeFile( path ) ;
	        }

	        
			/// 읽은 배트맵을 형변환해서 새로 생성
	        BitmapDrawable dbmp = new BitmapDrawable( bmp );
			Drawable dr = (Drawable)dbmp ;	/// 그걸 다시 형변환
			iv.setBackgroundDrawable( dr ) ; /// 뷰 객체의 백그라운드로 설정
			*/
		}
		
		
		
		
		
		public void setAlbumImage( String path, ImageView iv )
		{
	        BitmapFactory.Options options = new BitmapFactory.Options( ) ; 	// 비트맵 이미지의 옵션 받을 변수 생성
	        options.inJustDecodeBounds = true;  							// 비트맴을 바로 로드하지 말고 옵션만 받아오라고 설정\
	        
	        BitmapFactory.decodeFile( path, options ) ; 					// 매트맵을 읽는데 윗줄에 의해 옵션만 받아오고 비트맵 다 읽지는 않음
	        
	        int degrees = GetExifOrientation(path);
	        
	        Log.d("moms",degrees+"");
			/// 이미지의 높이를 얻음
	        int fscale = options.outHeight ;
	        int img_scale = iv.getHeight();
	        
        	fscale = options.outWidth ;				// 이미지의 넓이를 스케일에 저장
       	    img_scale= iv.getWidth(); 	
       	    
	       
	        if( options.outWidth > options.outHeight )	// 이미지의 높이보다 넓이가 클 경우
	        {
	        	fscale = options.outWidth ;				// 이미지의 넓이를 스케일에 저장
	        	 img_scale= iv.getWidth(); 				
	        }
	        
	        Bitmap bmp ;	// 실제 이미지를 저장할 변수


	        
			/// 이미지의 넓이가 img_scale 보다 크면
	        if( img_scale < fscale )
	        {
				/// 이미지의 사이즈를 img_scale 으로 나눈 만큼 리사이징 할거다
	        	fscale = fscale / img_scale ;
				/// 새 비트맵 옵션 생성
		        BitmapFactory.Options options2 = new BitmapFactory.Options();
		        options2.inSampleSize = fscale ;	/// 리사이징할 비율 설정
		        bmp = BitmapFactory.decodeFile( path, options2 ) ;	/// 실제로 비트맵을 읽어온다.
	        }
	        else
	        {	/// 사이즈가 적당 하면 그냥 읽는다.
	        	bmp = BitmapFactory.decodeFile( path );
	        }
	        
        	Log.d("moms", fscale+",위드 " + options.outWidth + ", 헤이트" + options.outHeight);
        	
		
        	if( degrees != 0 )	// 이미지의 높이보다 넓이가 클 경우
        	{
        		Matrix matrix = new Matrix();
        		iv.setScaleType(ScaleType.MATRIX);
        		matrix.postRotate(degrees, iv.getHeight() /2   , iv.getWidth() / 2);
        		iv.setImageMatrix(matrix);
        		Log.d("moms","오긴 오냐?");
        		
        	}
			/// 읽은 배트맵을 형변환해서 새로 생성
	        BitmapDrawable dbmp = new BitmapDrawable( bmp );
			Drawable dr = (Drawable)dbmp ;	/// 그걸 다시 형변환
			iv.setImageDrawable( dr ) ; /// 뷰 객체의 백그라운드로 설정
			
			//iv.setBackgroundDrawable( dr ) ; /// 뷰 객체의 백그라운드로 설정
        	
		}
		
		private int GetExifOrientation(String filepath) {
			 int degree = 0;
			 ExifInterface exif = null;
			 
			 try {
			  exif = new ExifInterface(filepath);
			 } catch (Exception e) {
			  e.printStackTrace();
			 }

			 if (exif != null) {
			  int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
			  
			  if (orientation != -1) { 
			   switch(orientation) { 
			    case ExifInterface.ORIENTATION_ROTATE_90:
			     degree = 90;
			     break;
			     
			    case ExifInterface.ORIENTATION_ROTATE_180:
			     degree = 180;
			     break;
			     
			    case ExifInterface.ORIENTATION_ROTATE_270:
			     degree = 270;
			     break;
			   }
			  }
			 }
			
		return degree;
		}
		
}