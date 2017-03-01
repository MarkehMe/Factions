package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Perm;
import com.massivecraft.factions.cmd.type.TypeFaction;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeDouble;

public class CmdFactionsPowerBoostFaction extends FactionsCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoostFaction()
	{
		// Aliases
		this.addAliases("faction");

		// Parameters
		this.addParameter(TypeFaction.get(), "faction");
		this.addParameter(TypeDouble.get(), "amount", "show");

		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POWERBOOST_FACTION));
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Parameters
		Faction faction = this.readArg();
		double powerboost = this.readArg(faction.getPowerBoost());
		boolean update = false;
		
		// Is show?
		if (this.argIsSet(2)) return;
		{
			update = CmdFactionsPowerBoost.canSet(sender, faction, powerboost);
			if (!update) return;
		}
		
		// Inform
		CmdFactionsPowerBoost.informPowerBoost("Faction", update, faction, powerboost, msender);
	}
	
}
