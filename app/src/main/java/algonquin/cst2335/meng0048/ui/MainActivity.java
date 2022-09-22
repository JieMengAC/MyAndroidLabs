package algonquin.cst2335.meng0048.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

import algonquin.cst2335.meng0048.data.MainViewModel;
import algonquin.cst2335.meng0048.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        //loads the XML file on Screen:
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        Button myButton = variableBinding.myButton;
        TextView myText = variableBinding.myTextView;
        EditText myEdit = variableBinding.myEditText;
 //       String editString = myEdit.getText().toString();
//        myButton.setOnClickListener(v->{myText.setText("Your edit text has: " + editString); });

        myButton.setOnClickListener(v->
                {   String myEditString = myEdit.getText().toString();
                    model.editString.postValue(myEditString);
                });
        model.editString.observe(this, s ->{myText.setText("Your edit test has" + s);});

        // old method for using widgets called findViewById(R.id.myId)
//        setContentView(R.layout.activity_main);
//        Button myButton = findViewById(R.id.myButton);
//        TextView myText = findViewById(R.id.myTextView);
//        EditText myEdit = findViewById(R.id.myEditText);

//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String editString = myEdit.getText().toString();
//                myText.setText("Your edit text has: " + editString);
//
//            }
//        });

        // using compound buttons in lab2
        String str = "Do you drink coffee?";
        String strRadio = variableBinding.radioButton.getText().toString();
        String strSwitch1 = variableBinding.switch1.getText().toString();
        model.isChecked.observe(this, selected->{

            variableBinding.checkBox.setChecked(selected);
            variableBinding.checkBox.setText(str+selected);

            variableBinding.radioButton.setChecked(selected);
            variableBinding.radioButton.setText(strRadio+selected);

            variableBinding.switch1.setChecked(selected);
            variableBinding.switch1.setText(strSwitch1+selected);

            //toast
            Context context = getApplicationContext();
            CharSequence text = "The value is now: " + selected;
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context,text,duration).show();

        });


        variableBinding.checkBox.setOnCheckedChangeListener((button,checked)->{
            model.isChecked.postValue(variableBinding.checkBox.isChecked());

        });


        variableBinding.radioButton.setOnCheckedChangeListener((button,checked)->{
            model.isChecked.postValue(variableBinding.radioButton.isChecked());

        });


        variableBinding.switch1.setOnCheckedChangeListener((button,checked)->{
            model.isChecked.postValue(variableBinding.switch1.isChecked());
        });




    }
}