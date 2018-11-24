package com.mb.validate;

import org.apache.spark.sql.catalyst.*;

import java.util.HashMap;
import java.util.Map;

public class SQLValidator {

    public static Map<String, Object> validate(String query) {
       Map<String, Object> retVal = new HashMap<String, Object>();

        try{
            SqlParser.parse(query);
            retVal.put("state", "valid");
            retVal.put("message", "");
            return retVal;
        }
        catch (Exception ex) {
            retVal.put("state", "error");
            retVal.put("message", ex.getMessage());
            return retVal;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> retVal = validate("Select * from employee");
    }
}
