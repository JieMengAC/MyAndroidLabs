package algonquin.cst2335.meng0048;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algonquin.cst2335.meng0048.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    // change the profile picture
    ActivityResultCallback callback = new ActivityResultCallback<ActivityResult>() {

        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Bitmap thumbnail = data.getParcelableExtra("data");
//                binding.imageView.setImageBitmap(thumbnail);
                FileOutputStream fOut = null;
                try {
                    fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);

                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), callback);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String number = prefs.getString("PhoneNumber", "");



        // change the textview content
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        binding.textViewSecondPage.setText("Welcome back  " + emailAddress);
        binding.editTextPhone.setText(number);

        //phone call
        binding.buttonPhone.setOnClickListener(click -> {
            Intent call = new Intent(Intent.ACTION_DIAL);
            String phoneNumber = binding.editTextPhone.getText().toString();
            call.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(call);

        });

        // change the profile picture
        binding.buttonPicture.setOnClickListener(click -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraResult.launch(cameraIntent);
        });
        File file = new File(getFilesDir(), "Picture.png");
        if (file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile(getFilesDir() + "/Picture.png");
            binding.imageView.setImageBitmap(theImage);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("PhoneNumber", binding.editTextPhone.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("MainActivity", "In Resume() - Responding to user input");
        File file = new File(getFilesDir(),"Picture.png" );
        if (file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile(getFilesDir() +"/Picture.png");
            binding.imageView.setImageBitmap(theImage);
        }
    }


}
