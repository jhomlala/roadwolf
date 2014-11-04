package com.jhomlala.spring.controller;

import java.io.IOException;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.jhomlala.spring.config.MvcConfiguration;


public class StatsGenerator {
 /*
	public static void createStatsForPlayer(ModelAndView model,String receivedSteamID) 
	{
		
		MvcConfiguration config = new MvcConfiguration();
		DataSource dataForDAO = config.getDataSource();
		PlayerDAOImpl PlayerDBInterface = new PlayerDAOImpl(dataForDAO);
		Player statsPlayer = PlayerDBInterface.get(receivedSteamID);
		if (statsPlayer==null)
		{  
			HomeController.processForm();
		} 
		else
		{
			int storedKills = statsPlayer.getTotalkills();
			int storedDeaths = statsPlayer.getTotaldeaths(); 
			int storedAssists = statsPlayer.getTotaldeaths();
			int storedTotalcount = statsPlayer.getTotalcount();
			int storedScoutCount = statsPlayer.getScoutcount();
			int storedSoldierCount = statsPlayer.getSoldiercount();
			int storedPyroCount = statsPlayer.getSoldiercount();
			int storedDemomanCount = statsPlayer.getSoldiercount();
			int storedHeavyCount = statsPlayer.getSoldiercount();
			int storedEngineerCount = statsPlayer.getSoldiercount();
			int storedMedicCount = statsPlayer.getSoldiercount();
			int storedSniperCount = statsPlayer.getSoldiercount();
			int storedSpyCount = statsPlayer.getSoldiercount();
			
			int totalCountAllClasses = storedScoutCount+storedSoldierCount+storedPyroCount+storedDemomanCount+
					+storedEngineerCount+storedHeavyCount+storedMedicCount+storedSniperCount+storedSpyCount;
			//because sometimes storedTotalCount is not equal to sum of all classes times
			model.addObject("Kills",storedKills);
			model.addObject("Deaths",storedDeaths);
			model.addObject("Assists",storedAssists);
			model.addObject("TotalCount",storedTotalcount);
			
			model.addObject("Scout",storedScoutCount);
			model.addObject("Soldier",storedSoldierCount);
			model.addObject("Pyro",storedPyroCount);
			model.addObject("Demoman",storedDemomanCount);
			model.addObject("Heavy",storedHeavyCount);
			model.addObject("Engineer",storedEngineerCount);
			model.addObject("Medic",storedMedicCount);
			model.addObject("Sniper",storedSniperCount);
			model.addObject("Spy",storedSpyCount);
			model.addObject("Total",totalCountAllClasses);
			
			model.addObject("ScoutPercent",(float)storedScoutCount/totalCountAllClasses*100);
			model.addObject("SoldierPercent",(float)storedSoldierCount/totalCountAllClasses*100);
			model.addObject("PyroPercent",(float)storedPyroCount/totalCountAllClasses*100);
			model.addObject("DemoPercent",(float)storedDemomanCount/totalCountAllClasses*100);
			model.addObject("HeavyPercent",(float)storedHeavyCount/totalCountAllClasses*100);
			model.addObject("EngPercent",(float)storedEngineerCount/totalCountAllClasses*100);
			model.addObject("MedicPercent",(float)storedMedicCount/totalCountAllClasses*100);
			model.addObject("SniperPercent",(float)storedSniperCount/totalCountAllClasses*100);
			model.addObject("SpyPercent",(float)storedSpyCount/totalCountAllClasses*100);
			
			loadDataFromSteam(model,receivedSteamID);
		}
		
		
	}

	private static void loadDataFromSteam(ModelAndView model, String receivedSteamID) 
	{
		long steamCommunityID = SteamID.convertSteamIdToCommunityId(receivedSteamID);
		model.addObject("sid2",steamCommunityID);
		try {
			JSONObject SteamData = JsonReader.readJsonFromUrl("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=CB9354376743E197C965C8F39D284434&steamids="+steamCommunityID );
			JSONObject SteamDataResponse = SteamData.getJSONObject("response");
			JSONArray SteamDataPlayerData = SteamDataResponse.getJSONArray("players");
			JSONObject SteamDataPlayerDataFinal = SteamDataPlayerData.getJSONObject(0);
			
			model.addObject("playerName",SteamDataPlayerDataFinal.getString("personaname"));
			model.addObject("playerProfile",SteamDataPlayerDataFinal.getString("profileurl"));
			model.addObject("playerAvatar",SteamDataPlayerDataFinal.getString("avatarfull"));
			model.addObject("playerState",getPersonaState(SteamDataPlayerDataFinal.getInt("personastate")));
			model.addObject("playerLogoff",SteamDataPlayerDataFinal.getString("lastlogoff"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
	}

	private static String getPersonaState(int state)
	{
		switch (state)
		{
		case 0:
		{
			return "Offline";
		}
		case 1:
		{
			return "Online";
		}
		case 2:
		{
			return "Busy";
		}
		case 3:
		{
			return "Away";
				
		}
		case 4:
		{
			return "Snooze";
		}
		case 5:
		{
			return "Looking for trade";
		}
		case 6:
		{
			return "Looking for play";
		}
		
		}
		return "Uknown";
	}*/

}
