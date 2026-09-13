package com.annotation.test;

public class TestClient {

    public static void main(String[] args) {

        EmployeDAO dao = new EmployeDAO();
       // dao.save();
        dao.findById(5);

    }


}
