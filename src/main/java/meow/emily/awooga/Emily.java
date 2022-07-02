package meow.emily.awooga;

import com.google.gson.JsonObject;
import meow.emily.awooga.Misc.CountHelper;
import meow.emily.awooga.Misc.IconList;
import meow.emily.awooga.modules.Beleidigung;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.KeyElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.user.util.UserActionEntry;
import net.labymod.utils.ModColor;

import java.util.List;

public class Emily extends LabyModAddon {

    private static Emily instance;
    private LabyModAddon addon;
    private LabyMod labymod;
    private int key;
    private int oldCount;

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

    private UserActionEntry NameMCCopy() {
        return new UserActionEntry(
                "Copy NameMC Link",
                UserActionEntry.EnumActionType.CLIPBOARD,
                "https://namemc.com/profile/" + "{uuid}",
                (UserActionEntry.ActionExecutor) null
        );
    }

    private UserActionEntry LabyNETCopy() {
        return new UserActionEntry(
                "Copy LabyNET Link",
                UserActionEntry.EnumActionType.CLIPBOARD,
                String.format("https://laby.net/@%s", "{name}"),
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
        api.getEventManager().register(
                (user, entityPlayer, networkPlayerInfo, list) ->
                        list.add(NameMCCopy())
        );
        api.getEventManager().register(
                (user, entityPlayer, networkPlayerInfo, list) ->
                        list.add(LabyNETCopy())
        );
        api.registerModule(new Beleidigung());
        api.registerForgeListener(new CountHelper());
        System.out.println("[NMC] Started...");
    }

    @Override
    public void loadConfig() {
        JsonObject config = getConfig();
        this.key = config.has("key") ? config.get("key").getAsInt() : -1;
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
        subSettings.add(
                new KeyElement(
                        "Beleidigungscounter",
                        new ControlElement.IconData(IconList.MiscIcon), this.key, integer -> {
                    this.key = integer;
                    getConfig().addProperty("key", integer);
                    saveConfig();
                }));
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}