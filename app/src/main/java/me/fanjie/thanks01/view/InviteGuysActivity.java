package me.fanjie.thanks01.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.fanjie.thanks01.R;

public class InviteGuysActivity extends ChildActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_guys);
        initToolbar();
        getSupportActionBar().setTitle("约伙伴");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_issue_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.complete){
            finish();
            Toast.makeText(this,"发布成功！",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
