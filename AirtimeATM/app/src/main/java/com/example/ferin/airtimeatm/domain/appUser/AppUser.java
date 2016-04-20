package com.example.ferin.airtimeatm.domain.appUser;

import com.example.ferin.airtimeatm.domain.network.CellphoneNetwork;

import java.io.Serializable;

/**
 * Created by Ferin on 2016-04-16.
 */
public class AppUser implements Serializable{

    private String cellphoneNumber;
    private String androidID; //pk
    private CellphoneNetwork cellphoneNetwork;
    private long id;

    private AppUser(){};

    private AppUser(Builder builder)
    {
        this.cellphoneNumber = builder.cellphoneNumber;
        this.androidID = builder.androidID;
        this.cellphoneNetwork = builder.cellphoneNetwork;
        this.id = builder.id;
    }

    public long getId() {
        return id;
    }

    public String getAndroidID() {
        return androidID;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public CellphoneNetwork getCellphoneNetwork() {
        return cellphoneNetwork;
    }

    public static class Builder
    {
        private String cellphoneNumber;
        private String androidID;
        private CellphoneNetwork cellphoneNetwork;
        private long id;

        public Builder cellphoneNumber(String cellphoneNumber)
        {
            this.cellphoneNumber = cellphoneNumber;
            return this;
        }

        public Builder androidID(String androidID)
        {
            this.androidID = androidID;
            return this;
        }

        public Builder cellphoneNetwork(CellphoneNetwork cellphoneNetwork)
        {
            this.cellphoneNetwork = cellphoneNetwork;
            return  this;
        }

        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(AppUser appUser)
        {
            this.cellphoneNetwork = appUser.cellphoneNetwork;
            this.cellphoneNumber = appUser.cellphoneNumber;
            this.androidID = appUser.androidID;
            return this;
        }

        public AppUser build()
        {
            return new AppUser(this);
        }
    }
}
