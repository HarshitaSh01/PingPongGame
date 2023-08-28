public class Main {
    public static void main(String[] args)
    {
        Window window = new Window();
        Thread t = new Thread(window);
        t.start();
    }
}