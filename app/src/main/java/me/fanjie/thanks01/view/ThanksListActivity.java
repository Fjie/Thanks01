package me.fanjie.thanks01.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.User;
import me.fanjie.thanks01.view.adapter.ThanksAdapter;

public class ThanksListActivity extends ChildActivity implements ThanksAdapter.OnItemClickCallBack {

    private ListView thanksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_list);
        initToolbar();
        thanksList = (ListView) findViewById(R.id.thanksList);
        ThanksAdapter adapter = new ThanksAdapter(this,s.getThanks(t.getN(10,20)));
        adapter.setOnItemClickCallBack(this);
        thanksList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thanks_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMessageItemClick(User user) {
        UserContentActivity.startMyActivity(this,user);
    }
}
