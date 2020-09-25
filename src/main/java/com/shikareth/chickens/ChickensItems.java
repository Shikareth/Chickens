package com.shikareth.chickens;

import com.shikareth.chickens.item.ItemBase;
import com.shikareth.chickens.item.ItemCatcher;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChickensItems {

	public static final Properties DEFAULT_ITEM_PROPERTIES = new Properties().group(ChickensMod.TAB);
	
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ChickensMod.MODID);
	
	public static final RegistryObject<Item> ITEM_CATCHER =  REGISTRY.register("catcher", () -> new ItemCatcher());
	public static final RegistryObject<Item> ITEM_CHICKEN =  REGISTRY.register("chicken", () -> new ItemBase());
	
}
