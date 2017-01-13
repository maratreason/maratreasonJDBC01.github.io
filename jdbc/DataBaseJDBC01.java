package com.marat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseJDBC01 {

		public static void main(String[] args) {

			/*Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;*/
			
			if(args.length == 0) {
				System.out.println("Usage: java ShowAnyData SQLSelectStatement");
				System.out.println("For example: java ShowAnyData \"select * from Employee\"");
				System.exit(1);
			}
			
			try(Connection conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/Lesson22");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(args[0]);){
				
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				int colCount = rsMeta.getColumnCount();
				
				
				for (int i = 1; i <= colCount; i++)  {
				      System.out.print(rsMeta.getColumnName(i) + " "); 
				    }
				    System.out.println();
				
				while(rs.next()){    
				for(int i = 1; i <= colCount; i++){
					System.out.println(rs.getString(i) + " ");
				}
				System.out.println("\n");
				}
			
			} catch(SQLException sqlex){
				System.out.println("SQLError:" + sqlex.getMessage() + " code: " +
						sqlex.getErrorCode());
			
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			
			}
		}
	}

