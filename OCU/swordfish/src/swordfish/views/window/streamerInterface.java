package swordfish.views.window;

import javax.swing.JPanel;

/**
 *
 * @author sabertooth
 */
public interface streamerInterface {
    public JPanel getMediaPlayer();
    public void setVideoFlag(boolean state);
    public void set_button_states();      
}
