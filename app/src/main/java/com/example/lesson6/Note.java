package com.example.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private final String title;
    private final String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    protected Note(Parcel in) {
        title = in.readString();
        text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}