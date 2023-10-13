package com.example.viewimages_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private int[] imageIds = {R.drawable.image1, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10};
    private int currentIndex = 0;
    private TextView textView;
    Button prev_btn;
    Button next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        updateImagesCount();

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(imageIds[currentIndex]);

        prev_btn = findViewById(R.id.prev_btn);
        prev_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(currentIndex > 0){
                    currentIndex--;
                } else if(currentIndex == 0){
                    currentIndex = imageIds.length - 1;
                }
                imageView.setImageResource(imageIds[currentIndex]);
                updateImagesCount();
            }
        });

        next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(currentIndex < imageIds.length - 1){
                    currentIndex++;
                } else if(currentIndex == imageIds.length - 1){
                    currentIndex = 0;
                }
                imageView.setImageResource(imageIds[currentIndex]);
                updateImagesCount();
            }
        });
    }

    private void updateImagesCount(){
        String text = String.format("%d/%d", currentIndex + 1, imageIds.length);
        textView.setText(text);
    }
}