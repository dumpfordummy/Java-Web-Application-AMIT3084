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
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findAllDesc", query = "SELECT c FROM Cart c ORDER BY c.cartid DESC"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByCustomerid", query = "SELECT c FROM Cart c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Cart.findByProductid", query = "SELECT c FROM Cart c WHERE c.productid = :productid"),
    @NamedQuery(name = "Cart.findByQty", query = "SELECT c FROM Cart c WHERE c.qty = :qty"),
    @NamedQuery(name = "Cart.findByPaymentid", query = "SELECT c FROM Cart c WHERE c.paymentid = :paymentid"),
    @NamedQuery(name = "Cart.findAllOrderByProductid", query = "SELECT c FROM Cart c ORDER BY c.productid ASC"),
    @NamedQuery(name = "Cart.findAllPaid", query = "SELECT c FROM Cart c WHERE c.paymentid IS NOT NULL"),
    @NamedQuery(name = "Cart.findCountByProductCategory", query = "SELECT COUNT(c) FROM Cart c, Product p WHERE c.productid = p.productid AND p.category = :category"),
    @NamedQuery(name = "Cart.findAllByProductCategory", query = "SELECT c FROM Cart c, Product p WHERE c.productid = p.productid AND p.category = :category"),
    @NamedQuery(name = "Cart.findCountByDate", query = "SELECT COUNT(c) FROM Cart c, Payment p WHERE c.paymentid = p.paymentid AND p.orderDate = :orderdate")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARTID")
    private Integer cartid;
    @Size(max = 36)
    @Column(name = "CUSTOMERID")
    private String customerid;
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Column(name = "QTY")
    private Integer qty;
    @Column(name = "PAYMENTID")
    private Integer paymentid;

    public Cart() {
    }

    public Cart(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartid != null ? cartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartid == null && other.cartid != null) || (this.cartid != null && !this.cartid.equals(other.cartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cart[ cartid=" + cartid + " ]";
    }
    
}
