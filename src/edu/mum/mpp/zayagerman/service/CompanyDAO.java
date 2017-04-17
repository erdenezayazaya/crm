package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Company;

public interface CompanyDAO {
	public void addCompany(Company company);
    public void deleteCompany(int companyId);
    public void updateCompany(Company company);
    public List<Company> getAllCompanys();
    public Company getCompanyById(int companyId);
}
