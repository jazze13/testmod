package jazze13.testmod;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class AlabugiteMaterial implements Tier {
    public static final AlabugiteMaterial INSTANCE = new AlabugiteMaterial();

    @Override
    public int getUses() {
        return 3072;
    }

    @Override
    public float getSpeed() {
        return 10;
    }

    @Override
    public float getAttackDamageBonus() {
        return 10;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    @NotNull
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ALABUGITE);
    }
}
