package com.example.mob_lab1;

import android.os.Parcel;
import android.os.Parcelable;

public class Water implements Parcelable {
    public Water(String name_of_point, String level_of_water, String coordinates, String date_of_test, String img) {
        this.name_of_point = name_of_point;
        this.level_of_water = level_of_water;
        this.coordinates = coordinates;
        this.date_of_test = date_of_test;
        this.img = img;
    }

    protected Water(Parcel in) {
        name_of_point = in.readString();
        level_of_water = in.readString();
        coordinates = in.readString();
        date_of_test = in.readString();
        img = in.readString();
    }

    public static final Creator<Water> CREATOR = new Creator<Water>() {
        @Override
        public Water createFromParcel(Parcel in) {
            return new Water(in);
        }

        @Override
        public Water[] newArray(int size) {
            return new Water[size];
        }
    };

    public String getImg() {
        return img;
    }

    private String name_of_point, level_of_water, coordinates, date_of_test, img;

    public String getName() {
        return name_of_point;
    }

    public void setName(String name_of_point) {
        this.name_of_point = name_of_point;
    }

    public String getlevel_of_water() {
        return level_of_water;
    }

    public void setlevel_of_water(String level_of_water) {
        this.level_of_water = level_of_water;
    }

    public String getcoordinates() {
        return coordinates;
    }

    public void setcoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getdate_of_test() {
        return date_of_test;
    }

    public void sedate_of_test(String date_of_test) {
        this.date_of_test = date_of_test;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_of_point);
        dest.writeString(level_of_water);
        dest.writeString(coordinates);
        dest.writeString(date_of_test);
        dest.writeString(img);
    }
}
