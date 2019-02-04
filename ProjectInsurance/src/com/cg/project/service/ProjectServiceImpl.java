package com.cg.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.project.dao.ProjectDao;
import com.cg.project.dao.ProjectDaoImpl;
import com.cg.project.exception.ProjectException;
import com.cg.project.presentation.Presentation;

public class ProjectServiceImpl implements ProjectService {
	List<String> list = new ArrayList<>();
	ProjectDao projectDao = new ProjectDaoImpl();

	@Override
	public boolean validateFields(Presentation presentation) {
		boolean validateFlag = false;
		if (!CheckclaimReason(presentation.getClaimReason())) {
			list.add("The claim reason should start with capital letter with minimum 4 characters and maximum of 30 characters\n");
		}
		if (!checkaccidentLocationStreet(presentation.getAccidentLocationStreet())) {
			list.add("The entered value can be both alphabets or numbers with the maximum range of 40 digits\n");
		}
		if (!checkaccidentCity(presentation.getAccidentCity())) {
			list.add("The entered value can be both alphabets or numbers with the maximum range of 15 digits\n");
		}
		if (!checkaccidentState(presentation.getAccidentState())) {
			list.add("The entered value can be both alphabets or numbers with the maximum range of 15 digits\n");
		}
		if (!checkaccidentZip(presentation.getAccidentZip())) {
			list.add("The entered value can be numbers with the maximum range of 5 digits\n");
		}
		if (!checkpolicyNumber(presentation.getPolicyNumber())) {
			list.add("The entered value can be numbers with the maximum range of 10 digits\n");
		}
		if (!list.isEmpty()) {
			System.err.println(list + "");
		}
		else {
			validateFlag = true;
		}

		return validateFlag;
	}

	private boolean checkpolicyNumber(int policyNumber) {
		String policynumberRegEx = "[0-9]{10}$";
		return Pattern.matches(policynumberRegEx, String.valueOf(policyNumber));
	}
	private boolean checkaccidentZip(int accidentZip) {
		String accidentzipRegEx = "[0-9]{5}$";
		return Pattern.matches(accidentzipRegEx, String.valueOf(accidentZip));
	}

	private boolean checkaccidentState(String accidentState) {
		String accidentstateRegEx = "[A-Z]{1}[a-zA-Z]{3,15}$";
		return Pattern.matches(accidentstateRegEx, String.valueOf(accidentState));
	}

	private boolean checkaccidentCity(String accidentCity) {
		String accidentcityRegEx = "[A-Z]{1}[a-zA-Z]{2,15}$";
		return Pattern.matches(accidentcityRegEx, String.valueOf(accidentCity));
	}

	private boolean checkaccidentLocationStreet(String accidentLocationStreet) {
		String accidentlocationstreetRegEx = "[A-Z]{1}[a-zA-Z0-9]{4,30}$";
		return Pattern.matches(accidentlocationstreetRegEx, String.valueOf(accidentLocationStreet));
	}

	public boolean CheckclaimReason(String claimReason) {
		String claimreasonRegEx = "[A-Z]{1}[a-zA-Z]{4,30}$";
		return Pattern.matches(claimreasonRegEx, String.valueOf(claimReason));
	}

	@Override
	public int addCustomerDetails(Presentation presentation) throws ProjectException {
		// TODO Auto-generated method stub
		return projectDao.addCustomerDetails(presentation);
	}

}
