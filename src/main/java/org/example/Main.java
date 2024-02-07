package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        System.out.println("\n=== test3: seller findALL===");

        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== test4: seller findByDepartment===");
        Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());

        System.out.println("\n=== test5: seller findByDepartment===");
        seller = sellerDao.finById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("update completed");

        System.out.println("\n=== test6: seller findByDepartment===");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();
    }



}