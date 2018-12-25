package com.example.chernegaeg.triangleandpoint;

import java.util.Scanner;

public class TriangleAndPoint {

    static int triangle[][] = new int[3][2];
    static int point[] = new int[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                triangle[i][j] = in.nextInt();
            }
        }
        point[0] = in.nextInt();
        point[1] = in.nextInt();

        //input finished

        double ABC = triangleArea(triangle[0][0], triangle[1][0], triangle[2][0], triangle[0][1], triangle[1][1], triangle[2][1]);
        double ABP = triangleArea(triangle[0][0], triangle[1][0], point[0], triangle[0][1], triangle[1][1], point[1]);
        double ACP = triangleArea(triangle[0][0], point[0], triangle[2][0], triangle[0][1], point[1], triangle[2][1]);
        double BCP = triangleArea(point[0], triangle[1][0], triangle[2][0], point[1], triangle[1][1], triangle[2][1]);

        if(ABP == 0 || ACP == 0 || BCP == 0){
            System.out.println("on");
        }
        else if (ABC > ABP + ACP + BCP - 0.00001 && ABC < ABP + ACP + BCP + 0.00001){
            System.out.println("in");
        }
        else{
            System.out.println("out");
        }

    }

    private static double triangleArea(int xA, int xB, int xC, int yA, int yB, int yC){
        double AB = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
        double AC = Math.sqrt(Math.pow(xC - xA, 2) + Math.pow(yC - yA, 2));
        double BC = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));
        double p = (AB + AC + BC)/2;
        return Math.sqrt(p*(p - AB)*(p - AC)*(p - BC));
    }
}
