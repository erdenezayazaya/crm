package edu.mum.mpp.zayagerman.dao;

import java.util.List;

import edu.mum.mpp.zayagerman.activity.Activity;

public interface ActivityDAO {
	public void addActivity(Activity activity);
    public void deleteActivity(int activityId);
    public void updateActivity(Activity activity);
    public List<Activity> getAllActivitys();
    public Activity getActivityById(int activityId);
}
