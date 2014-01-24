package ca.xef6.firecamp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity
{
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			startActivity(new Intent(MainActivity.this, SettingsActivity.class));
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(true);
		addTabs(actionBar);
	}
	
	private void addTab(ActionBar actionBar, int labelId, Fragment fragment) {
		actionBar.addTab(actionBar.newTab().setText(getResources().getString(labelId)).setTabListener(new TabListener(fragment)));
	}
	
	private void addTabs(ActionBar actionBar) {
		addTab(actionBar, R.string.fragment_map, new MapFragment());
		addTab(actionBar, R.string.fragment_events, new EventsFragment());
		addTab(actionBar, R.string.fragment_people, new PeopleFragment());
		addTab(actionBar, R.string.fragment_profile, new ProfileFragment());
	}
}