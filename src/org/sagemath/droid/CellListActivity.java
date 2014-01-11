package org.sagemath.droid;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.actionbarcompat.ActionBarActivity;

public class CellListActivity 
    	extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CellCollection.initialize(getApplicationContext());
		setContentView(R.layout.cell_list_fragment);
		
		CellListFragment listFragment = (CellListFragment)
				getSupportFragmentManager().findFragmentById(R.id.cell_list_fragment);
	
		Intent intent = getIntent();
		if (intent == null)
			listFragment.switchToGroup(null);		
		else {
			String group = intent.getStringExtra(CellActivity.INTENT_SWITCH_GROUP);
			listFragment.switchToGroup(group);		
		}
		
		setTitle(CellCollection.getInstance().getCurrentGroupName());
	}

	
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case android.R.id.home:
    		finish();
    		return true;
    	}
        return super.onOptionsItemSelected(item);
    }

}
