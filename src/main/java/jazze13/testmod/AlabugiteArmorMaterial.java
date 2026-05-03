package jazze13.testmod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class AlabugiteArmorMaterial implements ArmorMaterial {
    public static final AlabugiteArmorMaterial INSTANCE = new AlabugiteArmorMaterial();

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        int DURABILITY_MULTIPLIER = 12;

        return switch (type) {
            case BOOTS -> 13 * DURABILITY_MULTIPLIER;
            case LEGGINGS -> 15 * DURABILITY_MULTIPLIER;
            case CHESTPLATE -> 16 * DURABILITY_MULTIPLIER;
            case HELMET -> 11 * DURABILITY_MULTIPLIER;
            default -> 0;
        };
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS, HELMET -> 5;
            case LEGGINGS -> 8;
            case CHESTPLATE -> 10;
            default -> 0;
        };
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    @NotNull
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    @NotNull
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ALABUGITE);
    }

    @Override
    public String getName() {
        return "alabugite";
    }

    @Override
    public float getToughness() {
        return 4;
    }

    @Override
    public float getKnockbackResistance() {
        return 1.0f;
    }
}
