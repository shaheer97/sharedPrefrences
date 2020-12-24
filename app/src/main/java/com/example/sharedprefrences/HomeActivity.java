package com.example.sharedprefrences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedprefrences.HelperClasses.FeaturedAdapter;
import com.example.sharedprefrences.HelperClasses.FeaturedHelperClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

   TextView textview_name,textview_email,textview_tool;
    Button button_logout;
Context context;
    SharedPreferences sharedPreferences;

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    private static final String SHARED_PREF_NAME="my_pref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


    textview_name=(TextView)findViewById(R.id.text_full_name);
    textview_email=(TextView)findViewById(R.id.text_email);
    textview_tool=(TextView)findViewById(R.id.toolbar_text);
    button_logout=(Button)findViewById(R.id.button_logout);


    sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

    String name=sharedPreferences.getString(KEY_NAME,null);
    String email=sharedPreferences.getString(KEY_EMAIL,null);

    if (name!=null||email!=null){
        textview_name.setText("Full Name - "+name);
        textview_email.setText("Email ID - "+email);
textview_tool.setText("HI - "+name);
    }

    button_logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.commit();
            Toast.makeText(HomeActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    });

        featuredRecycler = findViewById(R.id.recycler_view);
        featuredRecycler();




    }

    private void featuredRecycler() {


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.new3, "TODAY NEWS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tristique ex vel quam feugiat iaculis. Nunc vel molestie libero, vitae feugiat est. Aenean in sodales risus, ut viverra lacus."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.new2, "TODAY NEWS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tristique ex vel quam feugiat iaculis. Nunc vel molestie libero, vitae feugiat est. Aenean in sodales risus, ut viverra lacus."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.new1, "TODAY NEWS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tristique ex vel quam feugiat iaculis. Nunc vel molestie libero, vitae feugiat est. Aenean in sodales risus, ut viverra lacus."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener   navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.nav_home:
                    Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_history:
                    Toast.makeText(HomeActivity.this, "History", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_profile:
                    Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_setting:
                    Toast.makeText(HomeActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                    break;





            }
            return true;
        }
        };



}