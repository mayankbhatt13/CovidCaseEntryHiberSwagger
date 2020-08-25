package com.covid.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cases")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Case {

	@Id
	@GeneratedValue
	@Column
	private Long countryId;
	
	@Column
	private String countryName;
	
	@Column
	private Long totalCases;
	
	@Column
	private Long newCases;
	
	@Column
	private Long totalDeaths;
	
	@Column
	private Long newDeaths;
	
	@Column
	private Long totalRecovered;
	
	@Column
	private Long activeCases;
	
	@Column
	private Long seriousCritical;
	
	@Column
	private Long totCasesMpop;
	
	@Column
	private Long deathsMpop;
	
	@Column
	private Long totalTests;
	
	@Column
	private Long testsMpop;

	public Case(Long countryId, String countryName, Long totalCases, Long newCases, Long totalDeaths, Long newDeaths,
			Long totalRecovered, Long activeCases, Long seriousCritical, Long totCasesMpop, Long deathsMpop,
			Long totalTests, Long testsMpop) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.totalCases = totalCases;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newDeaths = newDeaths;
		this.totalRecovered = totalRecovered;
		this.activeCases = activeCases;
		this.seriousCritical = seriousCritical;
		this.totCasesMpop = totCasesMpop;
		this.deathsMpop = deathsMpop;
		this.totalTests = totalTests;
		this.testsMpop = testsMpop;
	}
	
	public Case() {
		
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Long totalCases) {
		this.totalCases = totalCases;
	}

	public Long getNewCases() {
		return newCases;
	}

	public void setNewCases(Long newCases) {
		this.newCases = newCases;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Long getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Long newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Long getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public Long getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Long activeCases) {
		this.activeCases = activeCases;
	}

	public Long getSeriousCritical() {
		return seriousCritical;
	}

	public void setSeriousCritical(Long seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public Long getTotCasesMpop() {
		return totCasesMpop;
	}

	public void setTotCasesMpop(Long totCasesMpop) {
		this.totCasesMpop = totCasesMpop;
	}

	public Long getDeathsMpop() {
		return deathsMpop;
	}

	public void setDeathsMpop(Long deathsMpop) {
		this.deathsMpop = deathsMpop;
	}

	public Long getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(Long totalTests) {
		this.totalTests = totalTests;
	}

	public Long getTestsMpop() {
		return testsMpop;
	}

	public void setTestsMpop(Long testsMpop) {
		this.testsMpop = testsMpop;
	}
}
