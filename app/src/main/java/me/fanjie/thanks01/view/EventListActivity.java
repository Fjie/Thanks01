package me.fanjie.thanks01.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.view.adapter.EventAdapter;

public class EventListActivity extends ChildActivity implements EventAdapter.OnItemClickCallBack {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        initToolbar();
        listView = (ListView) findViewById(R.id.eventList);
        EventAdapter adapter = new EventAdapter(this,s.getEvents(t.getN(10,20)));
        adapter.setOnItemClickCallBack(this);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_request_list, menu);
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
    public void onMessageItemClick(Event event) {
        EventContentActivity.startMyActivity(this,event);
    }
}
