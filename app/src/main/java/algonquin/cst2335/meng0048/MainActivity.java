package algonquin.cst2335.meng0048;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import algonquin.cst2335.meng0048.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    ActivityMainBinding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginButton.setOnClickListener(click->{
                Intent nextPage =new Intent(MainActivity.this, SecondActivity.class);// show where you want to go

                nextPage.putExtra("EmailAddress",binding.editTextEmailAddress.getText().toString());

                startActivity(nextPage);

        });
        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"The application is now visible on screen");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"The application is now responding to user input");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"The application no longer responds to user input");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG,"The application is no longer visible.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"Any memory used by the application is freed.");
    }


}