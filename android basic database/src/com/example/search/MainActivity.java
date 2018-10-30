package com.example.search;

import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity {
	
	TextView t1;
	EditText e1,e2,e3;
	Button b1,b2;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        t1=(TextView)findViewById(R.id.tv1);
        t1.setMovementMethod(new ScrollingMovementMethod());
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        
       
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				    String a=e1.getText().toString();
				    String b=e2.getText().toString();
				    String c=e3.getText().toString();
				    DatabaseHelper dbhelper=new DatabaseHelper(MainActivity.this);
			        dbhelper.addinfo(new Userinfo(a,b));
			        		        
			        List<Userinfo> user=dbhelper.getUser();
			        String msg="";
			        for(Userinfo in:user)
			        {
			        	msg=msg+"Id = "+in.getId()+" Name = "+in.getName()+" Phone = "+in.getPhone_number()+"\n\n";
			        	//Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
			        	
			        	
			             
			        }
			        
			        t1.setText(msg);
				
			}
		});
        
        b2.setOnClickListener(new View.OnClickListener() {
			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				   
 				    String c=e3.getText().toString();
 				    DatabaseHelper dbhelper=new DatabaseHelper(MainActivity.this);
 			        
 			        List<Userinfo> user=dbhelper.getUser(c);
 			        String msg="";
 			        for(Userinfo in:user)
 			        {
 			        	msg=msg+"Id = "+in.getId()+" Name = "+in.getName()+" Phone = "+in.getPhone_number()+"\n\n";
 			        	//Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
 			        	
 			        	
 			             
 			        }
 			        
 			        t1.setText(msg);
 				
 			}
 		});
        
        
        
        
      
       
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
