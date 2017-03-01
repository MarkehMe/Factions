package com.massivecraft.factions.chat;

import java.util.Map;

import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.collections.MassiveMap;

public abstract class ChatTag extends ChatActive
{
	// -------------------------------------------- //
	// TAG REGISTER
	// -------------------------------------------- //
	
	private final static Map<String, ChatActive> idToTag = new MassiveMap<>();
	public static ChatTag getTag(String tagId) { return (ChatTag) idToTag.get(tagId); }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ChatTag(final String id)
	{
		super(id);
	}
	
	// -------------------------------------------- //
	// OVERRIDES
	// -------------------------------------------- //
	
	@Override
	protected Map<String, ChatActive> getAll()
	{
		return idToTag;
	}
	
	// -------------------------------------------- //
	// ABSTRACT
	// -------------------------------------------- //
	
	public abstract String getReplacement(CommandSender sender, CommandSender recipient);
	
}
