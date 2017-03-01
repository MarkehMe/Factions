package com.massivecraft.factions.chat;

import java.util.Map;

import com.massivecraft.massivecore.Active;
import com.massivecraft.massivecore.Identified;
import com.massivecraft.massivecore.MassivePlugin;

public abstract class ChatActive implements Active, Identified
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private MassivePlugin activePlugin;
	
	private final String id;
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ChatActive(final String id)
	{
		this.id = id.toLowerCase();
	}
	
	// -------------------------------------------- //
	// OVERRIDE > IDENTIFIED
	// -------------------------------------------- //
	
	@Override
	public String getId()
	{
		return this.id;
	}
	
	// -------------------------------------------- //
	// OVERRIDE > ACTIVE
	// -------------------------------------------- //
	
	@Override
	public MassivePlugin setActivePlugin(MassivePlugin plugin)
	{
		this.activePlugin = plugin;
		return plugin;
	}
	
	@Override
	public MassivePlugin getActivePlugin()
	{
		return this.activePlugin;
	}
	
	@Override
	public void setActive(MassivePlugin plugin)
	{
		this.setActive(plugin != null);
		this.setActivePlugin(plugin);
	}
	
	@Override
	public boolean isActive()
	{
		return this.getAll().containsKey(this.getId());
	}
	
	@Override
	public void setActive(boolean active)
	{
		if (active)
		{
			this.getAll().put(this.getId(), this);
		}
		else
		{
			this.getAll().remove(this.getId());
		}
	}
	
	// -------------------------------------------- //
	// ABSTRACT
	// -------------------------------------------- //
	
	protected abstract Map<String, ChatActive> getAll();
	
}
