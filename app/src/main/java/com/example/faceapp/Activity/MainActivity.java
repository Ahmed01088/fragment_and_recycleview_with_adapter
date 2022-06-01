package com.example.faceapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.faceapp.Fragment.GroupFragment;
import com.example.faceapp.Fragment.HomeFragment;
import com.example.faceapp.Fragment.NotificationFragment;
import com.example.faceapp.Fragment.PersonFragment;
import com.example.faceapp.Fragment.VideoFragment;
import com.example.faceapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
  BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,new HomeFragment());
        fragmentTransaction.commit();
        navigationView=findViewById(R.id.bottom_nav);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    case R.id.homeM:
                        fragmentTransaction.replace(R.id.fragmentContainerView,new HomeFragment());
                        break;
                    case R.id.friends:
                        fragmentTransaction.replace(R.id.fragmentContainerView,new GroupFragment());
                        break;
                    case R.id.notifications:
                        fragmentTransaction.replace(R.id.fragmentContainerView,new NotificationFragment());
                        break;
                    case R.id.me:
                        fragmentTransaction.replace(R.id.fragmentContainerView,new PersonFragment());
                        break;
                    case R.id.video:
                        fragmentTransaction.replace(R.id.fragmentContainerView,new VideoFragment());
                        break;
                }
                fragmentTransaction.commit();
                return true;
            }
        });


    }
}