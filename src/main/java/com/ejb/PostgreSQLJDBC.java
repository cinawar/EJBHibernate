package com.ejb;

import com.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

public class PostgreSQLJDBC {

    public void listEmployees( ){
        SessionFactory factory = null;
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM tbl_users").list();

            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                User employee = (User) iterator.next();
                System.out.print("First Name: " + employee.getUserName());
            }
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5433/postgres",
                            "postgres", "admin");
            ResultSet rs =c.prepareStatement("select * from tbl_users").executeQuery();

            while (rs.next())
            {
                System.out.print(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        PostgreSQLJDBC a =new PostgreSQLJDBC();
        a.listEmployees();
    }


}