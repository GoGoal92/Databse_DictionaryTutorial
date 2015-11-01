package com.example.databse_dictionarytutorial;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	Database_sql mdb;
	ListView lv;
	ArrayList<get> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mdb = new Database_sql(getApplicationContext());
		mdb.copying();
		lv = (ListView) findViewById(R.id.listView1);
		final EditText ed=(EditText) findViewById(R.id.editText1);
		Button b=(Button) findViewById(R.id.button1);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				list = mdb.getselect_all_data(ed.getText().toString());
				My_list_adapter adapter = new My_list_adapter(getApplicationContext(),
						list);
				lv.setAdapter(adapter);
			}
		});
	
	}
}
