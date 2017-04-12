package edu.mum.mpp.zayagerman.services;

import java.util.List;

import edu.mum.mpp.zayagerman.activity.Activity;
import edu.mum.mpp.zayagerman.businessLogic.ActivityLogic;
import edu.mum.mpp.zayagerman.settings.Settings;

public class ActivityService {
	
	public static boolean createActivities(int clientId, Activity activity)
	{
		return ActivityLogic.createActivities(clientId, activity);	
	}
	
	public static Activity getAcitivity(int id)
	{
		return ActivityLogic.getAcitivity(id);
	}

	public static List<Activity> getActivityList()
	{
		return ActivityLogic.getActivityList();
	}
	
}
