package meow.emily.awooga;

import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.user.util.UserActionEntry;
import net.labymod.utils.ModColor;

import java.util.List;

public class Emily extends LabyModAddon {

    private static Emily instance;
    private LabyModAddon addon;
    private LabyMod labymod;

    public static Emily getInstance() {
        return instance;
    }

    private UserActionEntry NameMC() {
        return new UserActionEntry(
                "Open in NameMC",
                UserActionEntry.EnumActionType.OPEN_BROWSER,
                "https://namemc.com/profile/" + "{uuid}",
                (UserActionEntry.ActionExecutor) null
        );
    }

    @Override
    public void onEnable() {

        instance = this;
        api.getEventManager().register(
                (user, entityPlayer, networkPlayerInfo, list) ->
                        list.add(NameMC())
        );
        System.out.println("[NMC] Started...");
    }

    @Override
    public void loadConfig() {
        return;
    }

    @Override
    protected void fillSettings(List<SettingsElement> subSettings) {
        subSettings.add(
                new HeaderElement(ModColor.cl('a') + "Welcome to OpenInNameMC"));
        subSettings.add(
                new ButtonElement("GitHub", () -> LabyMod.getInstance().openWebpage(
                        "https://github.com/PrincessAkira/NameMC-1.8", false)));
        subSettings.add(
                new ButtonElement("Creator", () -> LabyMod.getInstance().openWebpage(
                        "https://laby.net/@liebesschwur", false)));
    }

}
