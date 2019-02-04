package com.cg.project.dao;

public interface QueryMapper {

	public static final String insertCustomerDetails = "insert into claim values(claim_seq.nextval,?,?,?,?,?,?,?)";

}
