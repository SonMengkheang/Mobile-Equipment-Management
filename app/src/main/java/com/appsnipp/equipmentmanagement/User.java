package com.appsnipp.equipmentmanagement;

import android.widget.ImageView;

public class User {

    public String Username , Email ,  Gender , PhoneNumber , Address ;
    public ImageView Profile;



    public User(String name){

    }


    public User(String username, String email, String gender, String phoneNumber, String address, ImageView profile) {
        Username = username;
        Email = email;
        Gender = gender;
        PhoneNumber = phoneNumber;
        Address = address;
        Profile = profile;
    }



}
