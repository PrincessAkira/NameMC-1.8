package meow.emily.awooga.Misc;

import meow.emily.awooga.Emily;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class CountHelper {

    public static int count = 0;

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        Emily instance = Emily.getInstance();
        if (instance.getKey() > -1)
            if (Keyboard.isKeyDown(instance.getKey())) {
                count++;
            }
    }

}