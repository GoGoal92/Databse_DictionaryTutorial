package com.example.databse_dictionarytutorial;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class My_list_adapter extends BaseAdapter {

	Context con;
	ArrayList<get> list;

	public My_list_adapter(Context applicationContext, ArrayList<get> list2) {
		// TODO Auto-generated constructor stub
		con = applicationContext;
		list = list2;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int po, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater in = (LayoutInflater) con
				.getSystemService(con.LAYOUT_INFLATER_SERVICE);
		View v = in.inflate(R.layout.row, null);
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText(list.get(po).getWord() + "\n\n" + list.get(po).getGrammar()
				+ "\n\n" + list.get(po).getDetail());
		return v;
	}

}
