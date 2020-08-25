package com.covid.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid.rest.model.Case;
import com.covid.rest.service.CaseService;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
*/
@RestController
//@RequestMapping(value="/api")
//@Api(value = "CaseController", description = "REST Apis related to Covid-19 Cases")
public class CaseController {
	
	@Autowired
	private CaseService caseService;
	
	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}
	
	static Logger logger = Logger.getLogger(CaseController.class);
	
	@RequestMapping(value="/case", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Void> addCaseByCountry(@RequestBody Case caseObj){
		logger.info("Adding case by country functionality is invoked");
		if(caseObj == null) {
			logger.info("Data send from client side is EMPTY.");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}else if(caseService.isCaseExistForCountry(caseObj)) {
			logger.info("Case already exist for the CountryName entered");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}else {
			logger.info("Cases for Country added successfully.");
			caseService.addCaseByCountry(caseObj);
			HttpHeaders header = new HttpHeaders();
			header.add("Case Added  - ", String.valueOf(caseObj.getCountryId()));
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value="/case/{id}", method = RequestMethod.GET, produces = "application/json")
	//@ApiOperation(value = "Get Case by Country Id")
	//@ApiResponses(value= {@ApiResponse(code = 200, message = "OK", response = Case.class)})
	public ResponseEntity<List<Case>> findCasesByCountryId(@PathVariable("id") Long countryId){
		logger.info("Find case by countryId functionality is invoked");
		List<Case> dataList = caseService.findCasesByCountryId(countryId);
		//Case caseObj = caseService.findCasesByCountryId(countryId);
		if(dataList.isEmpty()) {
			logger.info("No Cases found for the given Id in database.");
			return new ResponseEntity<List<Case>>(HttpStatus.NOT_FOUND);
		}else {
			logger.info("Case retrieved successfully based on Id passed.");
			return new ResponseEntity<List<Case>>(dataList, HttpStatus.OK);
		}
	}
	
	/*@ApiOperation(value = "Get list of all Cases ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })*/
	@RequestMapping(value="/case", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Case>> getAllCases(){
		logger.info("Get All Cases functionality is invoked");
		List<Case> dataList = caseService.getAllCases();
		if(dataList.isEmpty()) {
			logger.info("No Cases found in database.");
			return new ResponseEntity<List<Case>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Cases fetched successfully.");
		return new ResponseEntity<List<Case>>(dataList,HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Update Case based on Country Id")
	@RequestMapping(value="/case/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Case> updateCaseByCountryId(@PathVariable("id") Long countryId, @RequestBody Case caseData){
		logger.info("Update functionality is invoked");
		List<Case> dataList = caseService.findCasesByCountryId(countryId);
		Case caseObj = new Case();
		if(dataList.isEmpty()) {
			logger.info("Data send from client side is EMPTY.");
			return new ResponseEntity<Case>(HttpStatus.NOT_FOUND);
		}else {
			caseObj.setCountryId(countryId);
			caseObj.setCountryName(caseData.getCountryName()); caseObj.setTotalCases(caseData.getTotalCases());
			caseObj.setNewCases(caseData.getNewCases()); caseObj.setTotalDeaths(caseData.getTotalDeaths());
			caseObj.setNewDeaths(caseData.getNewDeaths()); caseObj.setTotalRecovered(caseData.getTotalRecovered());
			caseObj.setActiveCases(caseData.getActiveCases()); caseObj.setSeriousCritical(caseData.getSeriousCritical());
			caseObj.setTotCasesMpop(caseData.getTotCasesMpop()); caseObj.setDeathsMpop(caseData.getDeathsMpop());
			caseObj.setTotalTests(caseData.getTotalTests()); caseObj.setTestsMpop(caseData.getTestsMpop());
		}
		logger.info("Case updated successfully.");
		caseService.updateCaseByCountryId(caseObj);
		return new ResponseEntity<Case>(caseObj, HttpStatus.OK);
	}

	//@ApiOperation(value = "Delete Case by Country Id ")
	@RequestMapping(value="/case/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Case> deleteCaseByCountryId(@PathVariable("id") Long countryId){
		logger.info("Delete case by countryId functionality is invoked");
		List<Case> dataList = caseService.findCasesByCountryId(countryId);
		//Case caseObj = caseService.findCasesByCountryId(countryId);
		if(dataList.isEmpty()) {
			logger.info("Data send from client side is EMPTY.");
			return new ResponseEntity<Case>(HttpStatus.NOT_FOUND);
		}
		logger.info("Case deleted successfully based on Country Id");
		caseService.deleteCaseByCountryId(countryId);
		return new ResponseEntity<Case>(HttpStatus.NO_CONTENT);
	}
	
	//@ApiOperation(value = "Delete all Cases")
	@RequestMapping(value="/case", method = RequestMethod.DELETE, produces = "applicatioin/json")
	public ResponseEntity<Case> deleteAllCases(){
		logger.info("Delete All case functionality is invoked and all cases has been deleted successfully");
		caseService.deleteAllCases();
		return new ResponseEntity<Case>(HttpStatus.NO_CONTENT);
	}
}
