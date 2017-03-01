package com.massivecraft.factions.util;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.collections.MassiveList;

import static com.massivecraft.factions.util.AsciiCompassDirection.*;

public class AsciiCompass
{
	// -------------------------------------------- //
	// COMPASS
	// -------------------------------------------- //
	
	public static List<String> getAsciiCompass(double degrees)
	{
		return getAsciiCompass(AsciiCompassDirection.getByDegrees(degrees));
	}
	
	private static List<String> getAsciiCompass(AsciiCompassDirection directionFacing)
	{
		// Create
		ArrayList<String> ret = new MassiveList<>();
		
		// Fill
		ret.add(AsciiCompass.visualizeRow(directionFacing, NW, N, NE));
		ret.add(AsciiCompass.visualizeRow(directionFacing, W, NONE, E));
		ret.add(AsciiCompass.visualizeRow(directionFacing, SW, S, SE));
		
		// Return
		return ret;
	}
	
	// -------------------------------------------- //
	// VISUALIZE ROW
	// -------------------------------------------- //
	
	private static String visualizeRow(AsciiCompassDirection directionFacing, AsciiCompassDirection... cardinals)
	{
		// Catch
		if (cardinals == null) return "";
		
		// Create
		StringBuilder ret = new StringBuilder(cardinals.length);
		
		// Fill
		for (AsciiCompassDirection asciiCardinal : cardinals)
		{
			ret.append(asciiCardinal.visualize(directionFacing));
		}
		
		// Return
		return ret.toString();
	}
	
}
