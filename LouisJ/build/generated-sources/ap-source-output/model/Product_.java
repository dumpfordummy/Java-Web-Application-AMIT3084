package model;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-30T14:24:49")
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-29T15:24:49")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Serializable> image;
    public static volatile SingularAttribute<Product, Integer> productid;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> stockqty;
    public static volatile SingularAttribute<Product, String> type;
    public static volatile SingularAttribute<Product, String> category;

}