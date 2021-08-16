package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDAO extends DataAccessObject<Order> {

  final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
  private static final String SELECT = "SELECT\n"
      + "  c.first_name, c.last_name, c.email, o.order_id,\n"
      + "  o.creation_date, o.total_due, o.status,\n"
      + "  s.first_name, s.last_name, s.email,\n"
      + "  ol.quantity,\n"
      + "  p.code, p.name, p.size, p.variety, p.price\n"
      + "from orders o\n"
      + "  join customer c on o.customer_id = c.customer_id\n"
      + "  join salesperson s on o.salesperson_id=s.salesperson_id\n"
      + "  join order_item ol on ol.order_id=o.order_id\n"
      + "  join product p on ol.product_id = p.product_id\n"
      + "where o.order_id = ?;";

  public OrderDAO(Connection connection) {
    super(connection);
  }

  @Override
  public Order findById(long id) {
    Order order = new Order();
    try (PreparedStatement statement = this.connection.prepareStatement(SELECT);) {
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      List<OrderLine> orderLines = new ArrayList<>();
      Boolean isFirst = true;
      while (resultSet.next()) {
        // Only set order information once, but keep on adding orderLines to the list
        if (isFirst) {
          order.setCustomerFirstName(resultSet.getString(1));
          order.setCustomerLastName(resultSet.getString(2));
          order.setEmail(resultSet.getString(3));
          order.setId(resultSet.getLong(4));
          order.setCreationDate(resultSet.getString(5));
          order.setTotalDue(resultSet.getFloat(6));
          order.setStatus(resultSet.getString(7));
          order.setSalesPersonFirstName(resultSet.getString(8));
          order.setSalesPersonLastName(resultSet.getString(9));
          order.setSalesPersonEmail(resultSet.getString(10));
          isFirst = false;
        }
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(resultSet.getInt(11));
        orderLine.setProductCode(resultSet.getString(12));
        orderLine.setProductName(resultSet.getString(13));
        orderLine.setProductSize(resultSet.getInt(14));
        orderLine.setProductVariety(resultSet.getString(15));
        orderLine.setProductPrice(resultSet.getFloat(16));
        orderLines.add(orderLine);
      }
      order.setOrderLines(orderLines);
    } catch (SQLException e) {
      logger.error(e.getMessage() + ": Unable to select ID", e);
      throw new RuntimeException();
    }
    return order;
  }

  // Methods below are not implemented

  @Override
  public List<Order> findAll() {
    return null;
  }

  @Override
  public Order update(Order dto) {
    return null;
  }

  @Override
  public Order create(Order dto) {
    return null;
  }

  @Override
  public void delete(long id) {

  }
}
