package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                
                // Insert Code here
                
                
                ResultSetMetaData meta = rs.getMetaData();
                
                
                while (rs.next()) {
                    JsonObject record = new JsonObject();
                    for (int k = 1; k <= meta.getColumnCount(); k++) {
                        String column = meta.getColumnName(k);
                        String value = rs.getString(column);
                        record.put(column, value);
                    }
                    records.add(record);
                }
               
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}