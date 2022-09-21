package algonquin.cst2335.meng0048.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        myButton.setOnClickListener(v->{model.editString1.postValue(variableBinding.myEditText.getText().toString());});
        model.editString1.observe(this, s ->{myText.setText("Your edit test has" + s);});

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


    }
}