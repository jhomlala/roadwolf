package com.jhomlala.spring.controller;

public class SteamID {
// edited from STEAM Condeser
// every rights to this code belong to Steam Condeser
	
	  public static String convertCommunityIdToSteamId(long communityId)
	  {
	        long steamId1 = communityId % 2;
	        long steamId2 = communityId - 76561197960265728L;

	        if(steamId2 <= 0)
	        {
	            System.out.println("ERROR WITH STEAMID");
	        }

	        steamId2 = (steamId2 - steamId1) / 2;

	        return "STEAM_0:" + steamId1 + ":" + steamId2;
	    }

	
	    public static long convertSteamIdToCommunityId(String steamId)
	    	{
	        if(steamId.equals("STEAM_ID_LAN") || steamId.equals("BOT")) {
	        	 System.out.println("ERROR WITH STEAMID");
	        }
	        if(steamId.matches("^STEAM_[0-1]:[0-1]:[0-9]+$")) {
	            String[] tmpId = steamId.substring(8).split(":");
	            return Long.valueOf(tmpId[0]) + Long.valueOf(tmpId[1]) * 2 + 76561197960265728L;
	        } else if(steamId.matches("^\\[U:[0-1]:[0-9]+\\]+$")) {
	            String[] tmpId = steamId.substring(3, steamId.length() - 1).split(":");
	            return Long.valueOf(tmpId[0]) + Long.valueOf(tmpId[1]) + 76561197960265727L;
	        } else {
	        	 System.out.println("ERROR WITH STEAMID");
	        }
			return 0; // error
	    }
	
	
	
}
