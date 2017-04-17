package edu.mum.mpp.zayagerman.dao;

import java.util.List;

import edu.mum.mpp.zayagerman.campaign.Campaign;

public interface CampaignDAO {
	public void addCampaign(Campaign campaign);
    public void deleteCampaign(int campaignId);
    public void updateCampaign(Campaign campaign);
    public List<Campaign> getAllCampaigns();
    public Campaign getCampaignById(int campaignId);
}
