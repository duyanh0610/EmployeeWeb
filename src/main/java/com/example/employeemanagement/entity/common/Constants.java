package com.example.employeemanagement.entity.common;


public class Constants {
    public interface IS_DELETED{
        Integer TRUE = 1;
        Integer FALSE = 0;
    }

    public interface ROLE{
        String ADMIN = "admin";
        String EMPLOYEE = "employee";
        String MANAGER = "MANAGER";
    }
    public interface TYPE {
        String DEV = "dev";
        String TEST = "test";
        String SCRUM_MASTER = "scum_master";
        String PM = "PM";
    }

    public interface ACCOUNT {
        String ID = "id";
        String USERNAME = "username";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String ROLE = "role";
    }
    public interface  DEPARTMENT {
        String NAME = "name";
        String TOTAL_NUMBER = "totalNumber";
        String TYPE = "type";
        String CREATED_DATE = "createdDate";
    }


    public interface OPERATOR {
        String NOT_EQUALS = "notEquals";
        String EQUALS = "equals";
        String CONTAINS = "contains";
        String NOT_CONTAINS = "notContains";
        String GREATER_THAN = "greaterThan";
        String GREATER_THAN_OR_EQUALS = "greaterThanOrEquals";
        String LESS_THAN = "lessThan";
        String LESS_THAN_OR_EQUALS = "lessThanOrEquals";
    }

    public interface AUTHENTICATION {
        String AUTHORIZATION_TOKEN = "Authorization";
    }

}
