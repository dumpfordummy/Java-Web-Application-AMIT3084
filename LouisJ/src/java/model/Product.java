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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByNamePattern", query = "SELECT p FROM Product p WHERE p.name LIKE :namePattern"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByType", query = "SELECT p FROM Product p WHERE p.type = :type"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByStockqty", query = "SELECT p FROM Product p WHERE p.stockqty = :stockqty")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Size(max = 256)
    @Column(name = "NAME")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 256)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 256)
    @Column(name = "CATEGORY")
    private String category;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "STOCKQTY")
    private Integer stockqty;
    @Lob
    @Column(name = "IMAGE")
    private Serializable image;

    public Product() {
    }

    public Product(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockqty() {
        return stockqty;
    }

    public void setStockqty(Integer stockqty) {
        this.stockqty = stockqty;
    }

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        this.image = image;
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
    
}
