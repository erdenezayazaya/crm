package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Industry;

public interface IndustryDAO {
	public void addIndustry(Industry industry);
    public void deleteIndustry(int industryId);
    public void updateIndustry(Industry industry);
    public List<Industry> getAllIndustrys();
    public Industry getIndustryById(int IndustryId);
}
