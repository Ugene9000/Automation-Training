package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by eugene_z on 9/1/16.
 */
public class MyKeyListener extends KeyAdapter {
    private int keyCode;

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if (e.getKeyCode()==keyCode)
            System.out.println("keycode pressed: " + keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
