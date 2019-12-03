package cafe.adriel.androidaudioconverter.sample;

import android.app.Application;
import android.os.Environment;

import cafe.adriel.androidaudioconverter.AndroidAudioConverter;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidAudioConverter.load(this, Environment.getExternalStorageDirectory() + "/audio_test/recorded_audio.wav");
    }
}