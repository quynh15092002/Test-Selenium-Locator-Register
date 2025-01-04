package com.testng;

import org.junit.Assert;

public class Topic_01_Assertion {

    // Mình ko có define testcase muốn chạy được thì phải chạy Java Application
    //Nhập Main > Enter

    public static void main(String[] args) {
        //TestNG cung cấp 3 hàm chính để kiểm tra tính đúng đắn của dữ lieệu
        boolean gender = 3 < 5;
        //Kiểm tra dữ liệu nó phải ĐÚNG
        Assert.assertTrue(gender);

        //Kiểm tra dữ liệu nó phải SAI
        Assert.assertFalse(3 > 5);

        // Kiểm tra dữ liệu nó bằng với cái mong đợi (ACTUAL - EXPECTED)
        // Kiểu dữ liệu giống nhau
        // Gía trị của dữ liệu bằng nhau
        Assert.assertEquals(5, 6);
        Assert.assertEquals("Name", "NAME");
        //Assert.assertEquals(5, "NAME"); //Nếu truyền 1 bên kieu này, 1 bên kiểu khác >> KO BAO GIO KIEU NÀY
}
}
