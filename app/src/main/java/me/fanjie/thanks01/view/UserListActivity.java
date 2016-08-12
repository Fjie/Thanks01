package me.fanjie.thanks01.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.User;
import me.fanjie.thanks01.view.adapter.UserAdapter;

public class UserListActivity extends ChildActivity implements UserAdapter.OnItemClickCallBack{

    private static final String USER_LIST_TITLE = "userListTitle";
    private ListView userList;

    public static void startMyActivity(Context context, String title){
        Intent i = new Intent(context,UserListActivity.class);
        i.putExtra(USER_LIST_TITLE,title);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        initToolbar();
        getSupportActionBar().setTitle(getIntent().getStringExtra(USER_LIST_TITLE));
        userList = (ListView) findViewById(R.id.userList);
        userList.setAdapter(new UserAdapter(this, s.getUsers(t.getN(10, 15))));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_list, menu);
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
        UserContentActivity.startMyActivity(this,user);
    }
}
