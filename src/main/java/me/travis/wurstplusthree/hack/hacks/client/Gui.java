package me.travis.wurstplusthree.hack.hacks.client;

import me.travis.wurstplusthree.WurstplusThree;
import me.travis.wurstplusthree.hack.Hack;
import me.travis.wurstplusthree.setting.type.*;
import me.travis.wurstplusthree.util.elements.Colour;
import org.lwjgl.input.Keyboard;

import java.util.Arrays;

/**
 * @author Madmegsox1
 * @since 29/04/2021
 */

@Hack.Registration(name = "Gui", description = "swag custom gui", category = Hack.Category.CLIENT, isListening = true, bind = Keyboard.KEY_RSHIFT, color = 0x4893AB)
public class Gui extends Hack {
    
    public static Gui INSTANCE;

    public ParentSetting colors = new ParentSetting("Colours", this);
    public ColourSetting headButtonColor = new ColourSetting("HeadButton", new Colour(255, 150, 90, 255), colors);
    public ColourSetting buttonColor = new ColourSetting("Button", new Colour(224, 156, 96, 255), colors);
    public ColourSetting fontColor = new ColourSetting("Font", new Colour(255,255,255, 255), colors);
    public ColourSetting groupColor= new ColourSetting("GroupSetting", new Colour(45,45,45,255), colors);
    public ColourSetting groupHoverColor = new ColourSetting("GroupHoverColor", new Colour(32, 32, 32, 255), colors);
    public BooleanSetting particles = new BooleanSetting("Particles", true, this);
    public ColourSetting particleColor = new ColourSetting("ParticleColor", new Colour(120, 20, 200, 200), colors, v -> particles.getValue());
    public IntSetting particleLength = new IntSetting("MaxParticleLength", 100, 0, 300, this, v -> particles.getValue());
    public IntSetting rainbowDelay = new IntSetting("RainbowDelay", 100, 0, 5000, this);
    public EnumSetting type = new EnumSetting("Type", "None", Arrays.asList("None", "Rainbow", "Sin"), this);
    public EnumSetting SinMode = new EnumSetting("SineMode", "Special", Arrays.asList("Special", "Hue", "Saturation", "Brightness"),this);
    public IntSetting scrollSpeed = new IntSetting("ScrollSpeed", 15, 1, 100, this);
    public ParentSetting gradientParent = new ParentSetting("Gradient", this);
    public BooleanSetting gradient = new BooleanSetting("Enabled", false, gradientParent);
    public ColourSetting gradientStartColor = new ColourSetting("GradientStartColor", new Colour(255, 122, 5, 100), gradientParent);
    public ColourSetting gradientEndColor = new ColourSetting("GradientEndColor", new Colour(255, 122, 5, 100), gradientParent);
    public DoubleSetting animation = new DoubleSetting("AnimationSpeed", 1.0, 0.1, 5.0, this);
    public IntSetting mouseDelay = new IntSetting("MouseDelay", 250, 100, 300, this);
    public BooleanSetting customScreen = new BooleanSetting("CustomMenu", true, this);
    public BooleanSetting customFont = new BooleanSetting("CustomFont", true, this);
    public ParentSetting toolTipsParent = new ParentSetting("ToolTips", this);
    public BooleanSetting toolTips = new BooleanSetting("ShowToolTips", true , toolTipsParent);
    public ColourSetting toolTipColor = new ColourSetting("ToolTipColour", new Colour(0,0,0,100), toolTipsParent);

    public Gui(){
        INSTANCE = this;
    }

    @Override
    public void onEnable(){
        mc.displayGuiScreen(WurstplusThree.GUI2);
        this.disable();
    }
}
