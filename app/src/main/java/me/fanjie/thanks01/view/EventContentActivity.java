package me.fanjie.thanks01.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.User;

public class EventContentActivity extends ChildActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_REQUEST_CONTENT = 2212;
    public static final int RESULT_CODE_NOT_LIKE_THIS_REQUEST = 8888;

    private static final String EVENT = "event";
    private static final String TAG = "RequestContentActivity";

    private Toolbar toolbar;
    private ImageView userImage;
    private com.gc.materialdesign.views.ButtonFloat float_i_willing,float_add_people;
    private TextView userName,userResume, eventTitle, eventTime, eventDesc;

    private Event event;
    private User user;

    private boolean isIWilling = false;
    private boolean hasPeopleWilling = false;

    public static void startMyActivity(Activity activity, Event event){
        Intent i = new Intent(activity,EventContentActivity.class);
        i.putExtra(EVENT, event);
//        activity.startActivityForResult(i, REQUEST_CODE_REQUEST_CONTENT);
        activity.startActivity(i);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_content);
        toolbar = super.initToolbar();
        event = (Event) getIntent().getSerializableExtra(EVENT);
        user = event.getUser();
        userImage = (ImageView) findViewById(R.id.userImage);
        float_i_willing = (ButtonFloat) findViewById(R.id.float_i_willing);
        float_add_people = (ButtonFloat) findViewById(R.id.float_add_people);
        userName = (TextView) findViewById(R.id.userName);
        userResume = (TextView) findViewById(R.id.userResume);
        eventTitle = (TextView) findViewById(R.id.eventTitle);
        eventTime = (TextView) findViewById(R.id.eventTime);
        eventDesc = (TextView) findViewById(R.id.eventDesc);
        hasPeopleWilling = t.getB();

        u.setHttpImage(userImage, userImage.getLayoutParams().width);
        toolbar.setTitle(event.getType());
        float_i_willing.setOnClickListener(this);
        float_add_people.setOnClickListener(this);
        setFloatIWilling(isIWilling);
        setFloatAddPeople(hasPeopleWilling);

        userName.setText(user.getName());
        userResume.setText(user.getResume());
        eventTitle.setText(event.getTitle());
        eventTime.setText(t.getEventDate()+";"+t.getEventTime());
        eventDesc.setText(t.getEventDesc());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_request_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.float_i_willing){
            if(isIWilling){
                isIWilling = false;
            }else {
                isIWilling = true;
            }
            setFloatIWilling(isIWilling);
            Toast.makeText(this, isIWilling ? "我愿意" : "我不愿意", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.float_add_people){
            if (hasPeopleWilling){
                Intent i = new Intent(this,GoodManListActivity.class);
                startActivity(i);
            }else {
                Intent i = new Intent(this,FriendsListActivity.class);
                startActivity(i);
            }
        }
    }

    private void setFloatIWilling(boolean b){
        if(isIWilling){
            float_i_willing.setDrawableIcon(getResources().getDrawable(R.drawable.ic_mood_white_48dp));
            float_i_willing.setBackgroundColor(Color.parseColor("#ff33b5e5"));
        }else{
            float_i_willing.setDrawableIcon(getResources().getDrawable(R.drawable.ic_mood_bad_white_48dp));
            float_i_willing.setBackgroundColor(Color.parseColor("#ffff4444"));
        }

    }

    private void setFloatAddPeople(boolean b){
        if(hasPeopleWilling){
            float_add_people.setDrawableIcon(getResources().getDrawable(R.drawable.ic_group_white_48dp));
            float_add_people.setBackgroundColor(Color.parseColor("#ff33b5e5"));
        } else {
            float_add_people.setDrawableIcon(getResources().getDrawable(R.drawable.ic_group_add_white_48dp));
            float_add_people.setBackgroundColor(Color.parseColor("#ffff4444"));
        }
    }

    public void onSmallUserPanelClick(View view) {
        UserContentActivity.startMyActivity(this,user);
    }
}
