package com.vah.mobi;


import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PathPage extends Activity {
    public void onCreate(Bundle savedInstanceState) 
    {
    	setContentView(R.layout.mpath);
    	Bundle b=getIntent().getExtras();
    	final String murl=b.getString("URL");
    	Button copyc=(Button)findViewById(R.id.copyc);
    	copyc.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				 ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
				 clipboard.setText(murl);
				 Toast t=Toast.makeText(PathPage.this,"Link Copied to Clipboard",Toast.LENGTH_SHORT);
             	t.show();
			}
		});
    	ImageView iv=(ImageView)findViewById(R.id.pimg);
    	try{
        super.onCreate(savedInstanceState);
        URL u=new URL(murl);
        InputStream c=(InputStream)u.getContent();
       Drawable d=Drawable.createFromStream(c,"src");
        iv.setImageDrawable(d);
    		}
    	catch(Exception e)
    	{
    		Toast te=Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
            te.show();
    	}
    }
}