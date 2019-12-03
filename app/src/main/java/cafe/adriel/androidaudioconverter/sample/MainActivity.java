package cafe.adriel.androidaudioconverter.sample;

import android.Manifest;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import cafe.adriel.androidaudioconverter.AndroidAudioConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        }

        Util.requestPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        Util.requestPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void convertAudio(View v) {
        /**
         *  Update with a valid audio file!
         *  Supported formats: {@link AndroidAudioConverter.AudioFormat}
         */

        Log.d("test", Environment.getExternalStorageDirectory().getAbsolutePath() + "/audio_test");
        File wavFile = new File(Environment.getExternalStorageDirectory(), "/audio_test/recorded_audio.wav");
        Log.e("test", wavFile.getAbsolutePath());
//        IConvertCallback callback = new IConvertCallback() {
//            @Override
//            public void onSuccess(File convertedFile) {
//                Toast.makeText(MainActivity.this, "SUCCESS: " + convertedFile.getPath(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Exception error) {
//                Toast.makeText(MainActivity.this, "ERROR: " + error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        };
        Toast.makeText(this, "Converting audio file...", Toast.LENGTH_SHORT).show();

        AndroidAudioConverter.load(this, Environment.getExternalStorageDirectory() + "/audio_test/recorded_audio.wav");

//        AndroidAudioConverter.with(this)
//                .setFile(wavFile)
//                .setFormat(AudioFormat.MP3)
//                .setCallback(callback)
//                .convert();
    }

}