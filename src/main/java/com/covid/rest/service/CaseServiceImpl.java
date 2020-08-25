package com.covid.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.rest.dao.CaseDao;
import com.covid.rest.model.Case;
@Service("caseService")
public class CaseServiceImpl implements CaseService {
	
	@Autowired
	private CaseDao caseDao;
	
	public void setCaseDao(CaseDao caseDao) {
		this.caseDao = caseDao;
	}
	
	@Override
	public List<Case> findCasesByCountryId(Long countryId) {
		return caseDao.findCasesByCountryId(countryId);
	}

	@Override
	public Case findCasesByCountryName(String countryName) {
		return caseDao.findCasesByCountryName(countryName);
	}

	@Override
	public List<Case> getAllCases() {
		return caseDao.getAllCases();
	}

	@Override
	public void addCaseByCountry(Case caseObj) {
		caseDao.addCaseByCountry(caseObj);
	}

	@Override
	public void updateCaseByCountryId(Case caseObj) {
		caseDao.updateCaseByCountryId(caseObj);
	}

	@Override
	public void deleteCaseByCountryId(Long countryId) {
		caseDao.deleteCaseByCountryId(countryId);
	}

	@Override
	public boolean isCaseExistForCountry(Case caseObj) {
		return caseDao.isCaseExistForCountry(caseObj);
	}

	@Override
	public void deleteAllCases() {
		caseDao.deleteAllCases();
	}
}
