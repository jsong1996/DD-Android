package com.dilloday.jimmy.dilloday.Classes;

/**
 * Created by Jimmy on 2/13/2017.
 */
public class dbArtist {

    public String Name;
    public String ID;
    public String Time;
    public String imgURL;
    public String audioURL;

    public dbArtist() {
    }

    public dbArtist( String name, String ID, String time, String imgURL, String audioURL)
    {
        this.Name = Name;
        this.ID = ID;
        this.Time = Time;
        this.imgURL = imgURL;
        this.audioURL = audioURL;
    }
}
