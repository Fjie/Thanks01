package me.fanjie.thanks01.view;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import me.fanjie.thanks01.R;

public class IssueHelpActivity extends ChildActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_help);
        initToolbar();
        getSupportActionBar().setTitle("求帮助");
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
            Toast.makeText(this, "发布成功！", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    public void choseTime(final View view) {
        Calendar c = Calendar.getInstance();
        Dialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view2, int hourOfDay, int minute) {
                ((TextView)view).setText("时间:"+hourOfDay + "点" + minute + "分");
            }
        },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false);
        dialog.show();
    }
}
