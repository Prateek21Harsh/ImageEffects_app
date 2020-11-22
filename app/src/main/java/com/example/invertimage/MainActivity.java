package com.example.invertimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImage;
    Drawable picture;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = (ImageView) findViewById(R.id.myImage);
        picture = ResourcesCompat.getDrawable(getResources(),R.drawable.mypic,null);
        bitmapImage = ((BitmapDrawable) picture).getBitmap();

        myImage.setImageBitmap(bitmapImage);
        //Bitmap newphoto = invertImage(bitmapImage);
        //myImage.setImageBitmap(newphoto);

    }

    public void invertImage(View view){

        myImage = (ImageView) findViewById(R.id.myImage);
        picture = ResourcesCompat.getDrawable(getResources(),R.drawable.mypic,null);
        bitmapImage = ((BitmapDrawable) picture).getBitmap();

        Bitmap finalImage  = Bitmap.createBitmap(bitmapImage.getWidth(),bitmapImage.getHeight(),bitmapImage.getConfig());

        int A,R,G,B;
        int pixelcolor;
        int height = bitmapImage.getHeight();
        int width = bitmapImage.getWidth();

        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                pixelcolor = bitmapImage.getPixel(x,y);
                A = Color.alpha(pixelcolor);
                R = 255 - Color.red(pixelcolor);
                G = 255 - Color.green(pixelcolor);
                B = 255 - Color.blue(pixelcolor);

                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
            }
        }
        myImage.setImageBitmap(finalImage);
    }

    public void contrastImg(View view){
        myImage = (ImageView) findViewById(R.id.myImage);
        Drawable [] layers = new Drawable[2];

        layers[0] = ResourcesCompat.getDrawable(getResources(),R.drawable.mypic,null);
        layers[1] = ResourcesCompat.getDrawable(getResources(),R.drawable.phototwo,null);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        myImage.setImageDrawable(layerDrawable);
    }

}