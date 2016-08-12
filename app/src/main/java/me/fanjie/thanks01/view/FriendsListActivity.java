package me.fanjie.thanks01.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.User;
import me.fanjie.thanks01.view.adapter.UserAdapter;

public class FriendsListActivity extends ChildActivity implements UserAdapter.OnItemClickCallBack{

    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        initToolbar();
        userList = (ListView) findViewById(R.id.userList);
        userList.setAdapter(new UserAdapter(this,s.getUsers(t.getN(10,15))));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friends_list, menu);
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
    public void onUserItemClick(User user) {

    }
}
