package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedprefrences.HelperClasses.FeaturedAdapter;
import com.example.sharedprefrences.HelperClasses.FeaturedHelperClass;

import java.util.ArrayList;

import static com.example.sharedprefrences.App.CHANNEL_1_ID;
import static com.example.sharedprefrences.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    EditText editText_name,editText_email;
    Button button_save;
SharedPreferences sharedPreferences;


private static final String SHARED_PREF_NAME="my_pref";
private static final String KEY_NAME="name";
private static final String KEY_EMAIL="email.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager =NotificationManagerCompat.from(this);

        editText_name=findViewById(R.id.edit_text_name);
        editText_email=findViewById(R.id.edit_text_email);
        button_save=findViewById(R.id.button_save);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

String name= sharedPreferences.getString(KEY_NAME,null);
if (name!=null){
    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
    startActivity(intent);





}




        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_EMAIL,editText_email.getText().toString());
                editor.apply();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();

            }
        });


    }


public void sendOnChannel1(View v){

    Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID).setSmallIcon(R.drawable.ic_baseline_looks_one_24).setContentTitle(KEY_NAME).setContentText(KEY_EMAIL).setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).build();


    notificationManager.notify(1,notification);
}
//public void sendOnChannel2(View v){

  //  Notification notification=new NotificationCompat.Builder(this,CHANNEL_2_ID).setSmallIcon(R.drawable.ic_baseline_looks_two_24).setContentTitle(KEY_NAME).setContentText(KEY_EMAIL).setPriority(NotificationCompat.PRIORITY_LOW).build();


    //notificationManager.notify(2,notification);

//}


}