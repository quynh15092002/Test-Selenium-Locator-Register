package com.love;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Anh ơiiiiiii");
        for (int i = 0; i < 10; i++) {
            int count = i;
            String str = "Em yêu anh nhiều lắm ạ";
            if (i % 2 == 0) {
                str = "Anh cũng yêu em rấc nhìuuuuu";
            }
            for (float y = 2.5f; y > -2.0f; y -= 0.12f){
                for (float x = -2.3f; x < 2.3f; x += 0.041f){
                    float a = x*x+y*y-4f;
                    if ((a*a*a-x*x*y*y*y)<-0.0F){
                        int num =count%str.length();
                        System.err.print(str.charAt(num));
                        count++;
                    }else{
                        System.err.print(" ");
                    }
                }
                System.err.println();
                Thread.sleep(100);
            }
        }

    }
    }
