package com.cg.project.service;

import com.cg.project.exception.ProjectException;
import com.cg.project.presentation.Presentation;

public interface ProjectService {

	boolean validateFields(Presentation presentation) throws ProjectException;

	int addCustomerDetails(Presentation presentation) throws ProjectException;

	boolean CheckclaimReason(String claimReason);

}
