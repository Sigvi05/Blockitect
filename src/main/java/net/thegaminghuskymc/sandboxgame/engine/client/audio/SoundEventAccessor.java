package net.thegaminghuskymc.sandboxgame.engine.client.audio;

import com.google.common.collect.Lists;
import net.thegaminghuskymc.sandboxgame.engine.util.ResourceLocation;
import net.thegaminghuskymc.sandboxgame.engine.util.text.ITextComponent;
import net.thegaminghuskymc.sandboxgame.engine.util.text.TextComponentTranslation;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class SoundEventAccessor implements ISoundEventAccessor<Sound>
{
    private final List<ISoundEventAccessor<Sound>> accessorList = Lists.newArrayList();
    private final Random rnd = new Random();
    private final ResourceLocation location;
    private final ITextComponent subtitle;

    public SoundEventAccessor(ResourceLocation locationIn, @Nullable String subtitleIn)
    {
        this.location = locationIn;
        this.subtitle = subtitleIn == null ? null : new TextComponentTranslation(subtitleIn);
    }

    public int getWeight()
    {
        int i = 0;

        for (ISoundEventAccessor<Sound> isoundeventaccessor : this.accessorList)
        {
            i += isoundeventaccessor.getWeight();
        }

        return i;
    }

    @Override
    public Sound cloneEntry() {
        return null;
    }

    /*public Sound cloneEntry()
    {
        int i = this.getWeight();

        if (!this.accessorList.isEmpty() && i != 0)
        {
            int j = this.rnd.nextInt(i);

            for (ISoundEventAccessor<Sound> isoundeventaccessor : this.accessorList)
            {
                j -= isoundeventaccessor.getWeight();

                if (j < 0)
                {
                    return isoundeventaccessor.cloneEntry();
                }
            }

            return SoundHandler.MISSING_SOUND;
        }
        else
        {
            return SoundHandler.MISSING_SOUND;
        }
    }*/

    public void addSound(ISoundEventAccessor<Sound> p_188715_1_)
    {
        this.accessorList.add(p_188715_1_);
    }

    public ResourceLocation getLocation()
    {
        return this.location;
    }

    @Nullable
    public ITextComponent getSubtitle()
    {
        return this.subtitle;
    }
}