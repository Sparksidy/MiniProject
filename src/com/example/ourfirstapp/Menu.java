package com.example.ourfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	
	String classes[] = {"News","Live Scores","Champions League","FIFA Ranking"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1,classes));
		this.setTitle("Menu");
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String optionClicked = classes[position];
		switch(optionClicked){
		case "News"            :optionClicked = "MainActivity";
								break;
		case "Live Scores"     :optionClicked="LiveScores"; 
							    break;
		case "Champions League":optionClicked="ChampionsLeague";
								break;
		case "FIFA Ranking"    :optionClicked = "FIFARanking";
							    break;
		}
		try{
			Class ourClass = Class.forName("com.example.ourfirstapp."+optionClicked);
			Intent ourIntent = new Intent(Menu.this,ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	
}
