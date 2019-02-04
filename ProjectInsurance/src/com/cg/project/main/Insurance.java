package com.cg.project.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.project.exception.ProjectException;
import com.cg.project.presentation.Presentation;
import com.cg.project.service.ProjectService;
import com.cg.project.service.ProjectServiceImpl;

public class Insurance {
	static Logger logger = Logger.getLogger(Insurance.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		int choice = 0;
		boolean choiceFlag = false;
		ProjectService service = new ProjectServiceImpl();

		do {
			scanner = new Scanner(System.in);
			System.out.println("******** Insurance Claiming **********");
			System.out.println("1. Insert the details of the account holder");
			System.out.println("2. View the cliam status of the applicant");
			System.out.println("Enter choice");
			try {
				choice = scanner.nextInt();
				choiceFlag = true;
				switch (choice) {
				case 1:

					scanner.nextLine();
					System.out.println("Enter the reason of the claim: ");
					String claimReason = scanner.nextLine();
					/*
					 * boolean validateClaimReason = service.CheckclaimReason(claimReason);
					 * if(validateClaimReason) {
					 */
					System.out.println("Enter the street of the accident: ");
					String accidentLocationStreet = scanner.nextLine();
					System.out.println("Enter the city where accident occurred: ");
					String accidentCity = scanner.nextLine();
					System.out.println("Enter the state where accident occurred: ");
					String accidentState = scanner.nextLine();
					System.out.println("Enter the postal code where accident occurred: ");
					int accidentZip = scanner.nextInt();
					boolean selectClaimTypeFlag = false;
					String claimType = " ";
					do {
						scanner = new Scanner(System.in);
						System.out.println("Select the type which you want to claim: ");
						System.out.println("1. Annum ");
						System.out.println("2. Half Yearly");
						System.out.println("3. Quaterly");
						try {
							
							int selectClaimType = scanner.nextInt();
							selectClaimTypeFlag = true;
							switch (selectClaimType) {
							case 1:
								claimType = "Annum";
								break;
							case 2:
								claimType = "Half Yearly";
								break;
							case 3:

								claimType = "Quaterly";
								break;
							default:
								selectClaimTypeFlag = false;
								System.err.println("Select any options from 1 to 3");
								break;
							}
						} catch (InputMismatchException e) {
							System.err.println("Enter the valid details of integer type");
							/*selectClaimTypeFlag = false;*/

						}
					} while (!selectClaimTypeFlag);

					System.out.println("Enter the policy number of your policy: ");
					int policyNumber = scanner.nextInt();

					Presentation presentation = new Presentation();
					presentation.setClaimReason(claimReason);
					presentation.setAccidentLocationStreet(accidentLocationStreet);
					presentation.setAccidentCity(accidentCity);
					presentation.setAccidentState(accidentState);
					presentation.setAccidentZip(accidentZip);
					presentation.setClaimType(claimType);
					presentation.setPolicyNumber(policyNumber);

					try {
						boolean validateFlag = service.validateFields(presentation);
						do {
							if (validateFlag == true) {
								int rows = service.addCustomerDetails(presentation);
								/*System.out.println("successfully completed " + rows);*/
							}

						} while (validateFlag == false);
					} catch (ProjectException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					}

					break;

				case 2:
					break;
				default:
					choiceFlag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter your input again");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Enter the valid details");
				System.out.println("Enter you input again");

			}

		} while (!choiceFlag);

		/*scanner.close();*/

	}
}
