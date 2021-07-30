package me.travis.wurstplusthree.hud.components;

import me.travis.wurstplusthree.WurstplusThree;
import me.travis.wurstplusthree.hud.HudComponent;
import me.travis.wurstplusthree.setting.type.BooleanSetting;
import me.travis.wurstplusthree.setting.type.ColourSetting;
import me.travis.wurstplusthree.util.elements.Colour;

@HudComponent.Registration(name = "CurrentConfig")
public class ConfigComponent extends HudComponent {
    private ColourSetting color = new ColourSetting("Color", new Colour(30, 200, 100), this);
    private BooleanSetting customFont = new BooleanSetting("CustomFont", true, this);
    private BooleanSetting background = new BooleanSetting("Background", true, this);
    private String renderString;

    @Override
    public boolean shouldDrawBackground()  {
        return background.getValue();
    }

    @Override
    public int getHeight() {
        if (customFont.getValue())
            return WurstplusThree.GUI_FONT_MANAGER.getTextHeight() + 4;
        return mc.fontRenderer.FONT_HEIGHT + 4;
    }

    @Override
    public int getWidth() {
        if (customFont.getValue())
            return WurstplusThree.GUI_FONT_MANAGER.getTextWidth(renderString) + 5;
        return mc.fontRenderer.getStringWidth(renderString) + 5;
    }

    @Override
    public void renderComponent() {
        renderString = "Config: " + WurstplusThree.CONFIG_MANAGER.configName;
        if (customFont.getValue())
            WurstplusThree.GUI_FONT_MANAGER.drawString(renderString , getX() + 2, getY() + 2, color.getValue().hashCode(), false);
        else
            mc.fontRenderer.drawString(renderString , getX() + 2, getY() + 3, color.getValue().hashCode());
    }
}
