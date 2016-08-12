package me.fanjie.thanks01.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.controller.Service;
import me.fanjie.thanks01.controller.Test;
import me.fanjie.thanks01.controller.Util;

/**
 * Created by fanji on 2015/9/27.
 */
public class ChildActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected Test t = new Test();
    protected Service s = new Service();
    protected Util u = new Util();

    protected Toolbar initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
