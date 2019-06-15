package com.example.vnpchallenge.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class AssetHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "myorder.db";
    private static final int DATABASE_VERSION = 2;

    public AssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }
}

