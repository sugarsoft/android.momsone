package com.example.android.momsone.inc;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.json.*;

import com.example.android.momsone.MainActivity;

import android.R.integer;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class ItemBO {
    private String name;
    private String description;
    private String time;
    private String read;
    private String img;
    private String subject;

    
    
    
    public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getName() { return name;  }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    // / --------------------

    
    public static ArrayList getItems( String code ) {
    	    	
    	String revCode = code;
    	
        Log.i("moms", "ID : " + Build.ID);
        Log.i("moms", "ID : " + Build.VERSION.RELEASE);        
        
        String ver =Build.VERSION.RELEASE.toString(); 
        ver = ver.substring(0, ver.indexOf(".",2));
        Log.d("moms",ver);
        
        if(Float.parseFloat(ver) >= 2.3) {
    	StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	StrictMode.setThreadPolicy(policy);
        }

        Handler handler = new Handler();
        TextView textview;
        String display = "";
        ItemBO item;
        ArrayList list = new ArrayList();
        
        InputStream is = null;
        
        String result = "";
        //the year data to send, warunek rok większy od 1980
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("code",revCode));
        //nameValuePairs.add(new BasicNameValuePair("no", question));
    	
    	//http post
        try{

        	    HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://m.petronet.co.kr/mw/sm/json.jsp");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();


        }catch(Exception e){
                Log.e("moms", "Error : "+e.toString());
        }

        //convert response to string
        try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                }
                is.close();
                result=sb.toString();

        }catch(Exception e){
                Log.e("log_tag", "Error converting result "+e.toString());
        }
        
        try{

            JSONArray jArray = new JSONArray(result);

            for(int i=0;i<jArray.length();i++){
                  JSONObject json_data = jArray.getJSONObject(i);
                  item = new ItemBO();
                    
                  try {
	                  if(json_data.has("TIME") == true )
	                	  item.setTime(json_data.getString("TIME"));
	                  if(json_data.has("NAME") == true )
	                	  item.setName(json_data.getString("NAME"));
	                  if(json_data.has("DESC") == true )
	                	  item.setDescription(json_data.getString("DESC"));
	                  if(json_data.has("IMG") == true )
	                	  item.setImg(json_data.getString("IMG"));
	                  if(json_data.has("SUBJECT") == true )
	                	  item.setSubject(json_data.getString("SUBJECT"));
                  //Log.d("moms",item.getTime() + "," + item.getName() + ","+item.getDescription() + "," + item.getImg() + "," + item.getSubject());
                  } catch (Exception e) {
                	  Log.d("moms",e.toString());
                  }
                  
                  
                  list.add(item);


            }


    }catch(JSONException e){
            Log.e("log_tag", "Error parsing data "+e.toString());
    }
 	    
    
        //Log.d("moms", jsonarray.getJSONObject(i).getString("NAME").toString() );
   	 
	  return list;
    }
}
