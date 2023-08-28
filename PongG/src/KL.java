import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {
    private boolean KeyPressed[] = new boolean[128]; //key event calls from ASCII character code.

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyPressed[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyPressed[e.getKeyCode()] = false;

    }

    public boolean isKeyPressed(int KeyCode){
        return KeyPressed[KeyCode];
    }
}
