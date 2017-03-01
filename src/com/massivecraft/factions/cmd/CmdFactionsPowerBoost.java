package com.massivecraft.factions.cmd;

import org.bukkit.command.CommandSender;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.Perm;
import com.massivecraft.factions.PowerBoosted;
import com.massivecraft.factions.RelationParticipator;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

public class CmdFactionsPowerBoost extends FactionsCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoostPlayer cmdFactionsPowerBoostPlayer = new CmdFactionsPowerBoostPlayer();
	public CmdFactionsPowerBoostFaction cmdFactionsPowerBoostFaction = new CmdFactionsPowerBoostFaction();
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoost()
	{
		// Aliases
		this.addAliases("powerboost");
		
		// Child
		this.addChild(this.cmdFactionsPowerBoostPlayer);
		this.addChild(this.cmdFactionsPowerBoostFaction);

		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POWERBOOST));
	}

	// -------------------------------------------- //
	// INFORM
	// -------------------------------------------- //
	
	public static boolean canSet(CommandSender sender, PowerBoosted boosted, double power)
	{
		// Check set permissions
		if (!Perm.POWERBOOST_SET.has(sender, true)) return false;
		
		// Set
		boosted.setPowerBoost(power);
		return true;
	}
	
	public static void informPowerBoost(String target, boolean update, RelationParticipator rp, double power, MPlayer sender)
	{
		// Prepare
		target += " " + rp.describeTo(sender, true);
		String description = power > 0D ? "bonus" : "penalty";
		String when = update ? "now " : " ";
		
		sender.msg("<i>%s %shas a power %s of %.2f to min and max power levels.", target, when, description, power);
		if (update) Factions.get().log(String.format("%s has set the power %s for %s to %.2f.", sender.getName(), description, target, power));
	}
	
}
