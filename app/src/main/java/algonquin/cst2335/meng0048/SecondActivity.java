package algonquin.cst2335.meng0048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent previousIntent = getIntent();
        String emailAddress = previousIntent.getStringExtra("EmailAddress");

    }
}