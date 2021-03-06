/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author djenadi
 */
@Entity
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "supplier")
    private Collection<ResupplyOrder> resupplyOrders;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier() {
    }

    public Supplier(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Column(unique = true)
    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<ResupplyOrder> getResupplyOrders() {
        return resupplyOrders;
    }

    public void setResupplyOrders(Collection<ResupplyOrder> resupplyOrders) {
        this.resupplyOrders = resupplyOrders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", name=" + name + ", address=" + address + ", resupplyOrders=" + resupplyOrders + ", products=" + products + '}';
    }
    
    
    
    
}
