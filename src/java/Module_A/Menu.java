
package Module_A;

import java.io.Serializable;

public class Menu implements Serializable {
    
private double price;
private String prodId;

private String prodName;
private String restaurantName;
private boolean status=true;
private double discountRate;

public Menu(){
    this.prodId= "";
    this.prodName="";
    this.price=0.0;
    this.restaurantName="";
    this.status=true;
}


public Menu(String prodId,String prodName,Double price,String restaurantName,boolean status,double discountRate){
this.prodId=prodId;
this.prodName=prodName;
this.price=price;
this.restaurantName=restaurantName;
this.status=status;
this.discountRate=discountRate;
}


public Menu(String prodName) {
    this.prodName = prodName;
    
  }

public Double getDiscountRate(){
    return discountRate;
}

public void setDiscountRate(){
    this.discountRate=discountRate;
}

public String getRestaurantName(){
    return restaurantName;
}

public void setRestaurantName(){
    this.restaurantName=restaurantName;
}
  public boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status=status;
  }


  public String getName() {
    return prodName;
  }

  public void setName(String name) {
    this.prodName = prodName;
  }

  public String getProdId() {
    return prodId;
  }

  public void setProdId(String prodId) {
    this.prodId = prodId;
  }
  
  

  public double getPrice(){
      return price;
  }
  
  public void setPrice(double price){
      this.price = price ;
  }
  


      
  @Override
  public String toString() {
  return String.format("|%-16s | %-15s | RM %-20.2f |%-16s |%-16.2f|"+status , prodId, prodName,price,restaurantName,discountRate);

  }
  

}