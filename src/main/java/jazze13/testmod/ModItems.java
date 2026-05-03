package jazze13.testmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
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

    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(Testmod.MOD_ID, "item_group"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ALABUGITE_SWORD))
            .title(Component.translatable("itemGroup.example-mod"))
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModItems.ALABUGITE);
            itemGroup.accept(ModItems.ALABUGITE_SWORD);
            itemGroup.accept(ModItems.GUIDITE_HELMET);
            itemGroup.accept(ModItems.GUIDITE_CHESTPLATE);
            itemGroup.accept(ModItems.GUIDITE_LEGGINGS);
            itemGroup.accept(ModItems.GUIDITE_BOOTS);
            itemGroup.accept(ModItems.ALABUGITE_AXE);
            itemGroup.accept(ModItems.ALABUGITE_HOE);
            itemGroup.accept(ModItems.ALABUGITE_PICKAXE);
            itemGroup.accept(ModItems.ALABUGITE_SHOVEL);
        });
        
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

    // weapons
    public static final Item ALABUGITE_SWORD = register(new SwordItem(AlabugiteMaterial.INSTANCE, 2, 0.5F, new FabricItemSettings()), "alabugite_sword");

    // tools
    public static final Item ALABUGITE_AXE = register(new AxeItem(AlabugiteMaterial.INSTANCE, 1, 0.2F, new FabricItemSettings()), "alabugite_axe");
    public static final Item ALABUGITE_PICKAXE = register(new PickaxeItem(AlabugiteMaterial.INSTANCE, 0, 1F, new FabricItemSettings()), "alabugite_pickaxe");
    public static final Item ALABUGITE_SHOVEL = register(new ShovelItem(AlabugiteMaterial.INSTANCE, 4, 0.1F, new FabricItemSettings()), "alabugite_shovel");
    public static final Item ALABUGITE_HOE = register(new HoeItem(AlabugiteMaterial.INSTANCE, 2, 0, new FabricItemSettings()), "alabugite_hoe");

    // armor
    public static final Item GUIDITE_HELMET = register(new ArmorItem(AlabugiteArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Properties()), "alabugite_helmet");
    public static final Item GUIDITE_BOOTS = register(new ArmorItem(AlabugiteArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Properties()), "alabugite_boots");
    public static final Item GUIDITE_LEGGINGS = register(new ArmorItem(AlabugiteArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Properties()), "alabugite_leggings");
    public static final Item GUIDITE_CHESTPLATE = register(new ArmorItem(AlabugiteArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "alabugite_chestplate");
}
