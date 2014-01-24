package ca.xef6.firecamp;

import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

// Second commit test.
class TabListener implements android.app.ActionBar.TabListener
{
	public TabListener(Fragment fragment) {
		fragment_ = fragment;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction transaction) {
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction transaction) {
		transaction.add(0, fragment_, null);
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
		transaction.remove(fragment_);
	}
	
	private final Fragment fragment_;
}