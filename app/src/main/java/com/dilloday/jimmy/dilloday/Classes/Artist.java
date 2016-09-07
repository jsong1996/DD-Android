package com.dilloday.jimmy.dilloday.Classes;

import android.content.Intent;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by jsonh on 7/19/2016.
 */
public class Artist
{
    private String name;
    private String time;
    private int img;

    public Artist(){}

    public Artist( String _name, String _time, int _img)
    {
        this.name = _name;
        this.time = _time;
        this.img = _img;
    }

    public String getName()
    {
        return name;
    }

    public String getTime()
    {
        return time;
    }

    public int getImg() {return img;}

    public void setName (String Name)
    {
        this.name = name;
    }

    public void setTime (String Time)
    {
        this.time = time;
    }

    public void setImg(Image Img) {this.img = img;}
}
