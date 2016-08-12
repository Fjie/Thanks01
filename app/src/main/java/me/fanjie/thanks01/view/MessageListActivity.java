package me.fanjie.thanks01.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.User;
import me.fanjie.thanks01.view.adapter.MessageAdapter;

public class MessageListActivity extends ChildActivity implements MessageAdapter.OnItemClickCallBack{

    private ListView messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        initToolbar();
        messageList = (ListView) findViewById(R.id.messageList);
        MessageAdapter adapter = new MessageAdapter(this,s.getMessages(15));
        adapter.setOnItemClickCallBack(this);
        messageList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message_list, menu);
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

    @Override
    public void onMessageItemTitleClick(User user) {
        UserContentActivity.startMyActivity(this,user);
    }

}
