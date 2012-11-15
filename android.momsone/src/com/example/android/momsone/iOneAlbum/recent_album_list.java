package com.example.android.momsone.iOneAlbum;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.example.android.momsone.R;
import com.example.android.momsone.R.id;
import com.example.android.momsone.R.layout;
import com.example.android.momsone.inc.Footer;
import com.example.android.momsone.inc.ItemBO;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class recent_album_list extends Activity implements OnClickListener {
 
    private ListView listview;
    private ArrayList mListItem;
    Footer footer;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.list);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header2);
        
        TextView tvText = (TextView)findViewById(R.id.sub_header_text);
        tvText.setText("실시간앨범");          
        
        listview = (ListView) findViewById(R.id.list_view);
        String code = "recent_album_list";
        mListItem = ItemBO.getItems(code);
        listview.setAdapter(new ListAdapter(recent_album_list.this, R.id.list_view,
                mListItem));
        
        footer = (Footer) findViewById(R.id.layoutFooter);
        footer.setActivity(this);

        
    }
 
    public void onClick(View v) {
    }
 
    // ***ListAdapter***
    private class ListAdapter extends ArrayAdapter { //--CloneChangeRequired
        private ArrayList mList; //--CloneChangeRequired
        private Context mContext;
 
        public ListAdapter(Context context, int textViewResourceId,
                ArrayList list) { //--CloneChangeRequired
            super(context, textViewResourceId, list);
            this.mList = list;
            this.mContext = context;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            try {
                if (view == null) {
                    LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = vi.inflate(R.layout.album_list, null); //--CloneChangeRequired(list_item)
                }
                final ItemBO listItem = (ItemBO) mList.get(position); //--CloneChangeRequired
                if (listItem != null) {
                    // setting list_item views
                	//Log.d("moms",listItem.getImg());
                	
                	//Drawable drawable = LoadImageFromWebOperations(listItem.getImg());
                	try {
                		
                		Log.d("moms","1");
                	URL url = new URL(listItem.getImg());
                	URLConnection conn = url.openConnection();
                	conn.connect();
                	BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                	Bitmap bm = BitmapFactory.decodeStream(bis);
                	bis.close();
                	((ImageView) view.findViewById(R.id.tv_image)).setImageBitmap(bm);
                	} catch (Exception e) {
                		Log.d("moms",e.toString());
                	}

                    //imgView.setImageDrawable(drawable);
                    ((TextView) view.findViewById(R.id.tv_time))
                            .setText(listItem.getTime());
                    ((TextView) view.findViewById(R.id.tv_Subject))
                    .setText(listItem.getSubject());
                    
                    view.setOnClickListener(new OnClickListener() {
                        public void onClick(View arg0) { //--clickOnListItem
                            Intent myIntent = new Intent(recent_album_list.this,
                                    recent_album_view.class);
                            myIntent.putExtra("IMG", listItem.getImg());
                            myIntent.putExtra("TIME", listItem.getTime());
                            myIntent.putExtra("SUBJECT", listItem.getSubject());
                            startActivity(myIntent);
                            //finish();
                        }
                    });
                    
                    
                }
            } catch (Exception e) {
                //Log.d("moms", e.getMessage());
            	Log.d("moms", e.toString());
            }
            return view;
        }

		
    }
}
