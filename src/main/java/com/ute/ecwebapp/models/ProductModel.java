package com.ute.ecwebapp.models;

import com.ute.ecwebapp.beans.Product;
import com.ute.ecwebapp.utills.DbUtills;
import org.sql2o.Connection;

import java.util.List;

public class ProductModel {
    public static List<Product> findAll () {
        try (Connection con = DbUtills.getConnection()) {
            final String query = "select * from products";
            return con.createQuery(query)
                    .executeAndFetch(Product.class);
        }
    }

    public static Product findByID (int id) {
        final String query = "select * from products where ProID = :ProID";
        try (Connection con = DbUtills.getConnection()) {
            List<Product> list =  con.createQuery(query)
                    .addParameter("ProID", id)
                    .executeAndFetch(Product.class);

            if (list.size()==0) {
                return null;
            }
                return list.get(0);
        }
    }

    public static List<Product> findByCatId(int catId) {
        final String query = "select * from products where CatID = :CatID";
        try (Connection con = DbUtills.getConnection()) {
            return con.createQuery(query)
                    .addParameter("CatID", catId)
                    .executeAndFetch(Product.class);
        }
    }

    public static void add (Product p) {
        String sql = "INSERT INTO products ( ProName, TinyDes, FullDes, Price, CatID, Quantity) VALUES (:proname,:tinydes,:fulldes,:price,:catid,:quantity)";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("proname",p.getProName())
                    .addParameter("tinydes",p.getTinyDes())
                    .addParameter("fulldes",p.getFullDes())
                    .addParameter("price",p.getPrice())
                    .addParameter("catid",p.getCatID())
                    .addParameter("quantity",p.getQuantity())
                    .executeUpdate();
        }
    }

    public static void update (Product p) {
        String sql = "UPDATE products SET  ProName = :proname, TinyDes = :tinydes, FullDes = :fulldes, Price = :price, CatID = :catid, Quantity = :quantity WHERE ProID = :proid ";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("proname",p.getProName())
                    .addParameter("tinydes",p.getTinyDes())
                    .addParameter("fulldes",p.getFullDes())
                    .addParameter("price",p.getPrice())
                    .addParameter("catid",p.getCatID())
                    .addParameter("quantity",p.getQuantity())
                    .addParameter("proid",p.getProID())
                    .executeUpdate();
        }
    }

    public static void delete (int id) {
        String sql = "DELETE FROM products where ProID = :ProID";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("ProID",id)
                    .executeUpdate();
        }
    }
}

