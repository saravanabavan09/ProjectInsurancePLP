package com.cg.project.presentation;

public class Presentation {
	
	private String claimReason;
	private String accidentLocationStreet;
	private String accidentCity;
	private String accidentState;
	private int accidentZip;

	public Presentation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Presentation [claimReason=" + claimReason + ", accidentLocationStreet="
				+ accidentLocationStreet + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}

	public Presentation(String claimReason, String accidentLocationStreet, String accidentCity,
			String accidentState, int accidentZip, String claimType, int policyNumber) {
		super();
		this.claimReason = claimReason;
		this.accidentLocationStreet = accidentLocationStreet;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}
	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getAccidentLocationStreet() {
		return accidentLocationStreet;
	}

	public void setAccidentLocationStreet(String accidentLocationStreet) {
		this.accidentLocationStreet = accidentLocationStreet;
	}

	public String getAccidentCity() {
		return accidentCity;
	}

	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}

	public String getAccidentState() {
		return accidentState;
	}

	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}

	public int getAccidentZip() {
		return accidentZip;
	}

	public void setAccidentZip(int accidentZip) {
		this.accidentZip = accidentZip;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	private String claimType;
	private int policyNumber;

}