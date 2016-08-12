package me.fanjie.thanks01.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloat;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.User;

public class UserContentActivity extends ChildActivity implements View.OnClickListener {


    public static final String USER = "user";

    private User user;
    private boolean isFollowed;

    private ImageView userImage;
    private TextView userResume;
    private TextView thanksCount;
    private TextView evenCount;
    private TextView localHot;
    private TextView followUser;
    private TextView likeUser;
    private TextView groupUserCount;
    private com.gc.materialdesign.views.ButtonFloat addFollow;

    public static void startMyActivity(Context context,User user){
        Intent i = new Intent(context,UserContentActivity.class);
        i.putExtra(USER,user);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_content);
        initToolbar();
        userImage = (ImageView) findViewById(R.id.userImage);
        userResume = (TextView) findViewById(R.id.userResume);
        thanksCount = (TextView) findViewById(R.id.thanksCound);
        followUser = (TextView) findViewById(R.id.followUser);
        likeUser = (TextView) findViewById(R.id.likeUser);
        evenCount = (TextView) findViewById(R.id.eventCount);
        groupUserCount = (TextView) findViewById(R.id.groupUserCount);
        localHot = (TextView) findViewById(R.id.userCity);
        addFollow = (ButtonFloat) findViewById(R.id.addFollow);

        user = (User) getIntent().getSerializableExtra(USER);
        isFollowed = t.getB();

        u.setHttpImage(userImage, userImage.getLayoutParams().width);
        addFollow.setOnClickListener(this);
        setAddFollow(isFollowed);

        getSupportActionBar().setTitle(user.getName());
        userResume.setText(user.getResume());
        thanksCount.setText(t.getN(10, 50) + "");
        followUser.setText(t.getN(10, 50) + "");
        likeUser.setText(t.getN(10, 50) + "");
        localHot.setText(t.getN(10, 50) + "");
        evenCount.setText(t.getN(10, 50) + "");
        groupUserCount.setText(t.getN(3,10) + "");
    }

    private void setAddFollow(boolean isFollowed) {
        if(isFollowed){
            addFollow.setDrawableIcon(getResources().getDrawable(R.drawable.ic_favorite_white_48dp));
            addFollow.setBackgroundColor(Color.parseColor("#ff33b5e5"));
        }else{
            addFollow.setDrawableIcon(getResources().getDrawable(R.drawable.ic_favorite_border_white_48dp));
            addFollow.setBackgroundColor(Color.parseColor("#ffff4444"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_content, menu);
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
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.addFollow){
            if(isFollowed){
                isFollowed = false;
            }else {
                isFollowed = true;
            }
            setAddFollow(isFollowed);
            Toast.makeText(this, isFollowed ? "已关注" : "取消关注", Toast.LENGTH_SHORT).show();
        }
    }

    public void onFunctionClick(View view) {
        switch (view.getId()){
            case R.id.funUsersPanel:

                break;
            case R.id.funUsersThanks:
                startActivity(new Intent(this,ThanksListActivity.class));
                break;
            case R.id.funIssueEvent:
                startActivity(new Intent(this,EventListActivity.class));
                break;
            case R.id.funFollowsUser:
                UserListActivity.startMyActivity(this,user.getName()+" 的关注");
                break;
            case R.id.funLikeUser:
                UserListActivity.startMyActivity(this,user.getName()+" 的粉丝");
                break;
            case R.id.funUsersParty:
                UserListActivity.startMyActivity(this,user.getName()+"的组织");
                break;
            case R.id.funUserCity:
                startActivity(new Intent(this,EventListActivity.class));
                break;

        }
    }
}
