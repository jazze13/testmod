package jazze13.testmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;


public class ModItems {
    public static <T extends Item> T register(T item, String id) {
        ResourceLocation itemID = new ResourceLocation(Testmod.MOD_ID, id);

        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE_SWORD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE_AXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE_HOE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(itemGroup -> itemGroup.accept(ModItems.ALABUGITE_SHOVEL));

        CompostingChanceRegistry.INSTANCE.add(ModItems.ALABUGITE, 0.3f);

        FuelRegistry.INSTANCE.add(ModItems.ALABUGITE, 60 * 20);
    }


    public static final AlabugiteItem ALABUGITE = register(
        new AlabugiteItem(
            new FabricItemSettings()
                .food(
                    new FoodProperties.Builder()
                        .alwaysEat()
                        .fast()
                        .saturationMod(6)
                        .nutrition(2)
                        .effect(new MobEffectInstance(MobEffects.HARM, 3, 1), 1.0f)
                        .build()
                )
        ),
        "alabugite"
    );

    public static final Item ALABUGITE_SWORD = register(new SwordItem(AlabugiteMaterial.INSTANCE, 2, 0.5F, new FabricItemSettings()), "alabugite_sword");
    public static final Item ALABUGITE_AXE = register(new AxeItem(AlabugiteMaterial.INSTANCE, 1, 0.2F, new FabricItemSettings()), "alabugite_axe");
    public static final Item ALABUGITE_PICKAXE = register(new PickaxeItem(AlabugiteMaterial.INSTANCE, 0, 1F, new FabricItemSettings()), "alabugite_pickaxe");
    public static final Item ALABUGITE_SHOVEL = register(new ShovelItem(AlabugiteMaterial.INSTANCE, 4, 0.1F, new FabricItemSettings()), "alabugite_shovel");
    public static final Item ALABUGITE_HOE = register(new HoeItem(AlabugiteMaterial.INSTANCE, 2, 0, new FabricItemSettings()), "alabugite_hoe");
}
