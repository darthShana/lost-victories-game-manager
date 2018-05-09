package com.lostVictories.gameManager.core;

public enum ConfigEnum {
    DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD;


    public String get(){
        return System.getProperty(this.name());
    }
}
