package net.frezzydy.tutorialmod.item;

import net.frezzydy.tutorialmod.TutorialMod;
import net.frezzydy.tutorialmod.item.custom.ChiselItem;
import net.frezzydy.tutorialmod.item.custom.FuelItem;
import net.frezzydy.tutorialmod.item.custom.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

  public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
      () -> new ChiselItem(new Item.Properties().durability(32)));

  public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
      () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) {
        @Override
        public void appendHoverText(@NotNull ItemStack pStack, @NotNull TooltipContext pContext,
            @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pTooltipFlag) {
          pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
          super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
      });

  public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
      () -> new FuelItem(new Item.Properties(), 1200));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
