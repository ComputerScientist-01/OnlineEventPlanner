package com.demo.BusinessRules;

import java.util.Date;

import com.demo.model.User;

public class BusinessRules {
	public static boolean isPlannedDateValid(Date plannedDate) {
        Date currentDate = new Date();
        return !plannedDate.before(currentDate);
    }

    public static boolean isNumberOfPersonsValid(int numberOfPersons) {
        return numberOfPersons > 30;
    }

    public static boolean isQuotationCreationDateValid(Date creationDate) {
        Date currentDate = new Date();
        return !creationDate.after(currentDate);
    }

    public static boolean canUserSendEventPlanRequest(User user) {
        return "active".equalsIgnoreCase(user.getStatus());
    }
}


/*

isPlannedDateValid: Checks if the planned date is not less than the current date.
isNumberOfPersonsValid: Checks if the number of persons is greater than 30.
isQuotationCreationDateValid: Checks if the quotation creation date is not greater than the current date.
canUserSendEventPlanRequest: Checks if a user is activated before allowing them to send an event plan request.

*/