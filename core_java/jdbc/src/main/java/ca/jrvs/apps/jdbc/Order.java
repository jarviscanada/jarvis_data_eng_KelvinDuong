package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;
import java.util.List;

public class Order implements DataTransferObject {

  private long id;
  private String customerFirstName;
  private String customerLastName;
  private String email;
  private String creationDate;
  private Float  totalDue;
  private String status;
  private String salesPersonFirstName;
  private String salesPersonLastName;
  private String salesPersonEmail;
  private List<OrderLine> orderLines;

  @Override
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCustomerFirstName() {
    return customerFirstName;
  }

  public void setCustomerFirstName(String customerFirstName) {
    this.customerFirstName = customerFirstName;
  }

  public String getCustomerLastName() {
    return customerLastName;
  }

  public void setCustomerLastName(String customerLastName) {
    this.customerLastName = customerLastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getStatus() {
    return status;
  }

  public Float getTotalDue() {
    return totalDue;
  }

  public void setTotalDue(Float totalDue) {
    this.totalDue = totalDue;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSalesPersonFirstName() {
    return salesPersonFirstName;
  }

  public void setSalesPersonFirstName(String salesPersonFirstName) {
    this.salesPersonFirstName = salesPersonFirstName;
  }

  public String getSalesPersonEmail() {
    return salesPersonEmail;
  }

  public void setSalesPersonEmail(String salesPersonEmail) {
    this.salesPersonEmail = salesPersonEmail;
  }

  public String getSalesPersonLastName() {
    return salesPersonLastName;
  }

  public void setSalesPersonLastName(String salesPersonLastName) {
    this.salesPersonLastName = salesPersonLastName;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", customerFirstName='" + customerFirstName + '\'' +
        ", customerLastName='" + customerLastName + '\'' +
        ", email='" + email + '\'' +
        ", creationDate='" + creationDate + '\'' +
        ", totalDue='" + totalDue + '\'' +
        ", status='" + status + '\'' +
        ", salesPersonFirstName='" + salesPersonFirstName + '\'' +
        ", salesPersonLastName='" + salesPersonLastName + '\'' +
        ", salesPersonEmail='" + salesPersonEmail + '\'' +
        ", orderLines=" + orderLines +
        '}';
  }
}
