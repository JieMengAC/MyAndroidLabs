package algonquin.cst2335.meng0048.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

import algonquin.cst2335.meng0048.R;
import algonquin.cst2335.meng0048.data.MainViewModel;
import algonquin.cst2335.meng0048.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//

    private ActivityMainBinding variableBinding;
    ImageView imgView;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //loads the XML file on Screen:
//        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(variableBinding.getRoot());

        imgView = findViewById(R.id.imageView);
        sw = findViewById(R.id.spin_switch);
        sw.setOnCheckedChangeListener((btn, isChecked)->{
            if (isChecked)
            {
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setInterpolator(new LinearInterpolator());

                imgView.startAnimation(rotate);
            }
            else {
                imgView.clearAnimation();
            }
        });








    }
}