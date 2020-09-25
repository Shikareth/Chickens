package com.shikareth.chickens.item;

import com.shikareth.chickens.ChickensItems;

import net.minecraft.item.Item;

public class ItemBase extends Item{

	public ItemBase() {
		super(ChickensItems.DEFAULT_ITEM_PROPERTIES);
	}
	
	public ItemBase(Properties properties) {
		super(properties);
	}

}
