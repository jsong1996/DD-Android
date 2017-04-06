package com.dilloday.jimmy.dilloday.Classes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by jsonh on 7/19/2016.
 */
public class Artist
{

    private String name;
    private String time;
    private String imgURL;
    private String audioURL;
    private int img;
    private Drawable drawableImg;

    public Artist(){}

    public Artist( String name, String time, String imgURL, String audioURL)
    {
        this.name = name;
        this.time = time;
        this.imgURL = imgURL;
        this.audioURL = audioURL;
    }

    public String getName() {return name;}

    public String getTime()
    {
        return time;
    }

    public String getImgURL() {return imgURL;}

    public String getAudioURL() {return audioURL;}

    public int getImg() {return img;}

    public Drawable getDrawableImg() {return drawableImg;}

    public void setName (String Name)
    {
        this.name = Name;
    }

    public void setTime (String Time)
    {
        this.time = Time;
    }

    public void setImg(int Img) {this.img = Img;}

    public void setImgDrawable(Drawable drawableImg) {this.drawableImg = drawableImg;}

    public void setImgURL(String imgURL) {this.imgURL = imgURL;}

    public void setAudioURL(String audioURL){this.audioURL = audioURL;}
}
