package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {




        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== test1: seller findById===");
        Seller seller = sellerDao.finById(3);

        System.out.println(seller);

        System.out.println("\n=== test2: seller findByDepartment===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
    }


}