package com.ute.ecwebapp.models;

import com.ute.ecwebapp.utills.DbUtills;
import org.sql2o.Connection;

import java.util.List;
import com.ute.ecwebapp.beans.Category;

public class CategoryModel {
    public static List<Category> findAll () {
        try (Connection con = DbUtills.getConnection()) {
            final String query = "select * from categories";
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }

    public static Category findByID (int id) {
        final String query = "select * from categories where CatID = :CatID";
        try (Connection con = DbUtills.getConnection()) {
            List<Category> list =  con.createQuery(query)
                    .addParameter("CatID", id)
                    .executeAndFetch(Category.class);

            if (list.size()==0) {
                return null;
            }
                return list.get(0);
        }
    }


    public static void add (Category c) {
        String sql = "INSERT INTO categories(CatName) VALUES (:CatName)";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatName",c.getCatName())
                    .executeUpdate();
        }
    }

    public static void update (Category c) {
        String sql = "UPDATE categories set CatName = :CatName where CatID = :CatID";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatID",c.getCatID())
                    .addParameter("CatName",c.getCatName())
                    .executeUpdate();
        }
    }

    public static void delete (int id) {
        String sql = "DELETE FROM categories where CatID = :CatID";
        try (Connection con = DbUtills.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatID",id)
                    .executeUpdate();
        }
    }
}

