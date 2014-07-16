package com.example.todoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public void closeApp(View v){
		finish();
		System.exit(0);
	}
	protected void fire_alert(){
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Alert!");
		alertDialog.setIcon(R.drawable.ic_launcher);
		alertDialog.setMessage("Please enter email address!");		
		alertDialog.show();
	}
	protected void init(){
		this.fire_alert();
	}
	public void addEmail(View v){
		final EditText new_email_field = (EditText) findViewById(R.id.text_field);
		final TextView all_email_field = (TextView) findViewById(R.id.all_email);
		
		String new_email = new_email_field.getText().toString();
		String all_old_email = (String) all_email_field.getText();
		
		if(new_email.length() > 0){
			all_email_field.setText(new_email.concat("\n").concat(all_old_email));
			new_email_field.setText("");
		}else{
			this.fire_alert();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		this.init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
