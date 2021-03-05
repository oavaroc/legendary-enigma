package com.trms.data;


public class DAOFactory {
    
    public static DepartmentsDAO getDepartmentsDAO() {
        return new DepartmentsHibernate();
    }
    
    public static EmployeeDAO getEmployeeDAO() {
    	return new EmployeeHibernate();
    }
    
    public static EventTypeDAO getEventTypeDAO() {
    	return new EventTypeHibernate();
    }
    
    public static GradingFormatDAO getGradingFormatDAO() {
    	return new GradingFormatHibernate();
    }
    
    public static MessageDAO getMessageDAO() {
    	return new MessageHibernate();
    }
    
    public static ReimbursementDAO getReimbursementDAO() {
    	return new ReimbursementHibernate();
    }
}
