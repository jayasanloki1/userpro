package com.example.lokeshkumar.userpro;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Button btnpic;
    ImageView imgTakenPic;
    ImageView imgTakenPic2;
    private static final int CAM_REQUEST=133;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpic = (Button) findViewById(R.id.button);
        imgTakenPic =(ImageView) findViewById(R.id.imageView);
        imgTakenPic2 =(ImageView) findViewById(R.id.imageView2);
        Matrix matrix =new Matrix();
        imgTakenPic2.setScaleType(ImageView.ScaleType.MATRIX);

        matrix.postRotate(180f);
        btnpic.setOnClickListener(new btnTakePhotoClicker());



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAM_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
            imgTakenPic2.setImageBitmap(bitmap);



        }

    }


    class btnTakePhotoClicker implements Button.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);

        }
    }



    }



