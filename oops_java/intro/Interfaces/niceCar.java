package com.harsh.demo1.Interfaces;
// To use methods with same name but in different packages.
// niceCar contains a media object (CDPlayer object).
// CDPlayer must implement media because player is declared as media.

public class niceCar {
    private media ob = new CDPlayer();
    public void startMusic(){
        ob.start();
    }
    public void stopMusic(){
        ob.stop();
    }

}
