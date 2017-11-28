package com.example.user.texttospeech;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

public class Menu extends AppCompatActivity {

    Button btnSpeech;
    EditText edittext;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnSpeech = (Button)findViewById(R.id.btn_speech);
        edittext = (EditText)findViewById(R.id.edit_text);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edittext.getText().toString();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
                }else{
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }
}
