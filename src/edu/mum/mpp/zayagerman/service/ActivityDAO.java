package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Activity;

public interface ActivityDAO {
	public void addActivity(Activity activity);
    public void deleteActivity(int activityId);
    public void updateActivity(Activity activity);
    public List<Activity> getAllActivitys();
    public Activity getActivityById(int activityId);
}
