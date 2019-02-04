package com.cg.project.dao;

import com.cg.project.exception.ProjectException;
import com.cg.project.presentation.Presentation;

public interface ProjectDao {

	int addCustomerDetails(Presentation presentation) throws ProjectException;

}
