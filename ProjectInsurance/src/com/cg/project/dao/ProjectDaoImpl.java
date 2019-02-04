package com.cg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.project.exception.ProjectException;
import com.cg.project.jdbc.JDBCUtility;
import com.cg.project.presentation.Presentation;

public class ProjectDaoImpl implements ProjectDao {
	Connection connection = null;

	PreparedStatement statement = null;
	ResultSet resultSet = null;
	static Logger logger = Logger.getLogger(ProjectDaoImpl.class);

	@Override
	public int addCustomerDetails(Presentation presentation) throws ProjectException {
		logger.info("in add Customer method");
		/**
		 * method : addCustomerDetails 
		 * argument : it's taking model object as an argument 
		 * return type : this method return the generated id to the user 
		 * Author : Capgemini 
		 * Date : 04 - Feb - 2019
		 * 
		 **/

		connection = JDBCUtility.getConnection();
		logger.info("connection object created");

		/* String str=String.valueOf(mobile.getMobileNumber()); */
		int generatedId = 0;
	
		try {

			statement = connection.prepareStatement(QueryMapper.insertCustomerDetails);
			logger.debug("statement object created");
			statement.setString(1, presentation.getClaimReason());
			statement.setString(2, presentation.getAccidentLocationStreet());
			statement.setString(3, presentation.getAccidentCity());
			statement.setString(4, presentation.getAccidentState());
			statement.setInt(5, presentation.getAccidentZip());
			statement.setString(6, presentation.getClaimType());
			statement.setInt(7, presentation.getPolicyNumber());
			generatedId = statement.executeUpdate();
			logger.info("execute update called");

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new ProjectException("problem occured while creating the statement object");
		}
		return generatedId;
	}

}
