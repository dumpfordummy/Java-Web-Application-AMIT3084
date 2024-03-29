/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findAllDesc", query = "SELECT p FROM Product p ORDER BY p.productid DESC"),
    @NamedQuery(name = "Product.findAllCategory", query = "SELECT DISTINCT p.category FROM Product p"),
    @NamedQuery(name = "Product.findFirstProductImageByCategory", query = "SELECT p FROM Product p WHERE p.productid IN (SELECT MIN(p2.productid) FROM Product p2 WHERE p2.category = :category GROUP BY p2.category)"),
    @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByNamePattern", query = "SELECT p FROM Product p WHERE p.name LIKE :namePattern"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByPriceRange", query = "SELECT p FROM Product p WHERE p.price <= :priceRange"),
    @NamedQuery(name = "Product.findByCategoryAndPriceRange", query = "SELECT p FROM Product p WHERE p.category = :category AND p.price <= :priceRange"),
    @NamedQuery(name = "Product.findMaxPrice", query = "SELECT MAX(p.price) FROM Product p"),
    @NamedQuery(name = "Product.findByStockqty", query = "SELECT p FROM Product p WHERE p.stockqty = :stockqty")

})
public class Product implements Serializable {

    @Size(max = 256)
    @Column(name = "NAME")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 256)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 256)
    @Column(name = "IMAGE")
    private String image;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTID")
    private Integer productid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "STOCKQTY")
    private Integer stockqty;

    public Product() {
    }

    public Product(String name, String description, String category, String image, Integer productid, Double price, Integer stockqty) {
        this.name = name.toUpperCase();
        this.description = description.toUpperCase();
        this.category = category.toUpperCase();
        this.image = image;
        this.productid = productid;
        this.price = price;
        this.stockqty = stockqty;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Double getPrice() {
        return (double) Math.round(price * 100) / 100;
    }

    public void setPrice(Double price) {
        this.price = (double) Math.round(price * 100) / 100;
    }

    public Integer getStockqty() {
        return stockqty;
    }

    public void setStockqty(Integer stockqty) {
        this.stockqty = stockqty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ productid=" + productid + " ]";
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getDescription() {
        return description.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description.toUpperCase();
    }

    public String getCategory() {
        return category.toUpperCase();
    }

    public void setCategory(String category) {
        this.category = category.toUpperCase();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
