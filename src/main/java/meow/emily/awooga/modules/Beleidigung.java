package meow.emily.awooga.modules;

import meow.emily.awooga.Misc.CountHelper;
import meow.emily.awooga.Misc.IconList;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;

public class Beleidigung extends SimpleModule {

    @Override
    public String getDisplayName() {
        return "Beleidigungen";
    }

    @Override
    public String getDisplayValue() {
        return CountHelper.count + " today";
    }

    @Override
    public String getDefaultValue() {
        return "Nothing yet";
    }

    @Override
    public ControlElement.IconData getIconData() {
        // get as ressoucelocation
        return new ControlElement.IconData(IconList.MiscIcon);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Count Beleidigungen";
    }

    @Override
    public String getDescription() {
        return "Counts the Beleiodgungen";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
}
