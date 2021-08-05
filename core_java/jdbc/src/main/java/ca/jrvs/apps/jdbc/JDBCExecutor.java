package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {
  final static Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

  public static void main(String args[]){
    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
        "hplussport", "postgres", "password");
    try{
      Connection connection = dcm.getConnection();
      OrderDAO orderDAO = new OrderDAO(connection);
      Order order = orderDAO.findById(1000);
      Order order1 = orderDAO.findById(1001);
      Order order2 = orderDAO.findById(1002);
      System.out.println(order);
      System.out.println(order1);
      System.out.println(order2);
    }catch(SQLException e){
      logger.error(e.getMessage() + "Unable to select order", e);
      throw new RuntimeException();
    }
  }
}
