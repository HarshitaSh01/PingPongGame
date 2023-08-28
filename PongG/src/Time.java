public class Time {
    public static double timeStarted = System.nanoTime();

    public static double getTime(){ //nano time since the game engine has started.
        return (System.nanoTime() - timeStarted) * 1E-9; //convert to sec and determine the value,power of 10. (1E-9)
    }
}
