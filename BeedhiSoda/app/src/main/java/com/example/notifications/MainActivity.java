package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notifications.StreetSoda.CHANNEL_1_ID;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;

    private NotificationManagerCompat notifManger;
    private EditText editTextTitle;
    private EditText editTextMessage;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifManger = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
        viewPager= findViewById(R.id.pager);
        db = new DatabaseHelper(this);
        SwipeAdapter sa = new SwipeAdapter(getSupportFragmentManager(),db);

        viewPager.setAdapter(sa);



    }

    public void sendOnChannel1(View v){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            String title = editTextTitle.getText().toString();

            String message = editTextMessage.getText().toString();

            Intent activityIntent = new Intent(this, Activity2.class);


            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addNextIntentWithParentStack(activityIntent);

            PendingIntent actPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


            SharedPreferences pref = this.getSharedPreferences("Share", Context.MODE_PRIVATE);
            int count = pref.getInt("NotifCount", 1); //0 is default value.
            count++;

            SharedPreferences.Editor edit = pref.edit();
            edit.putInt("NotifCount", count);
            edit.commit();

            Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle(title)
                    .setContentText(message + " " + count)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setContentIntent(actPendingIntent)
                    .setAutoCancel(true)
                    .build();

            notifManger.notify(1, notification);
        }

    }

    public void sendOnChannel2 (View v){
        String title = editTextTitle.getText().toString();

        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, StreetSoda.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notifManger.notify(2, notification) ;
    }
}
