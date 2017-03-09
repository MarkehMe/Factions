package com.massivecraft.factions.entity.migration;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.massivecore.store.migration.NotDowngradeableException;
import com.massivecraft.massivecore.store.migration.VersionMigratorAbstract;
import com.massivecraft.massivecore.xlib.gson.JsonElement;
import com.massivecraft.massivecore.xlib.gson.JsonObject;

public class VersionMigratorFaction001 extends VersionMigratorAbstract
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //

	private static VersionMigratorFaction001 i = new VersionMigratorFaction001();
	public static VersionMigratorFaction001 get() { return i; }
	public VersionMigratorFaction001() { super(Faction.class); }

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	public void migrateInner(JsonObject entity, boolean upgrade) throws NotDowngradeableException
	{
		// We simulate updating a field by prefixing the description with ABC
		if (upgrade)
		{
			JsonElement element = entity.get("description");
			String desc = element == null ? "" : element.getAsString();
			desc = "ABC".concat(desc);
			entity.addProperty("description", desc);
		}
		else
		{
			JsonElement element = entity.get("description");
			String desc = element == null ? "ABC" : element.getAsString();
			desc = desc.substring(3);
			entity.addProperty("description", desc);
		}
	}

}
