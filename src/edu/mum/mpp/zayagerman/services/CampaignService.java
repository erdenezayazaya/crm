package edu.mum.mpp.zayagerman.services;

import java.util.List;

import edu.mum.mpp.zayagerman.businessLogic.CampaignLogic;
import edu.mum.mpp.zayagerman.campaign.Campaign;

public class CampaignService {
	public static boolean createCampaign(Campaign campaign)
	{
		return CampaignLogic.createCampaign(campaign);
	}
	
	public static Campaign getCampaign(int id)
	{
		return CampaignLogic.getCampaign(id);
	}
	
	public static List<Campaign> getActivityList()
	{
		return CampaignLogic.getActivityList();
	}
}
