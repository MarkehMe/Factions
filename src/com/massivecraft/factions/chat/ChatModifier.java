package com.massivecraft.factions.chat;

import java.util.Map;

import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.collections.MassiveMap;

public abstract class ChatModifier extends ChatActive
{
	// -------------------------------------------- //
	// MODIFIER REGISTER
	// -------------------------------------------- //
	
	private final static Map<String, ChatActive> idToModifier = new MassiveMap<>();
	public static ChatModifier getModifier(String modifierId) { return (ChatModifier) idToModifier.get(modifierId); }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ChatModifier(final String id)
	{
		super(id);
	}
	
	// -------------------------------------------- //
	// OVERRIDES
	// -------------------------------------------- //
	
	@Override
	protected Map<String, ChatActive> getAll()
	{
		return idToModifier;
	}
	
	// -------------------------------------------- //
	// ABSTRACT
	// -------------------------------------------- //
	
	public abstract String getModified(String subject, CommandSender sender, CommandSender recipient);
}
