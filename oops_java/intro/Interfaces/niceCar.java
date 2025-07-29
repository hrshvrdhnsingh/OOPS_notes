package oops_java.intro.Interfaces;
// To use methods with same name but in different packages.
// niceCar contains a media object (CDPlayer object).
// CDPlayer must implement media because player is declared as media.

public class niceCar {
    // niceCar "has-a" media player. So it's lifetime is tied to the object of niceCar.
    private media ob = new CDPlayer();
    public void startMusic(){
        ob.start();
    }
    public void stopMusic(){
        ob.stop();
    }

}
