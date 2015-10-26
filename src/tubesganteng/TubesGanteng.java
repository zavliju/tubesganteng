/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesganteng;

import java.util.Scanner;

/**
 *
 * @author risol_000
 */
public class TubesGanteng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n = new Scanner(System.in);
        System.out.println("========TUBES TEKOM=========");
        System.out.println("Silahkan masukkan sesuatu!");
        System.out.print("String : ");
        String x = n.nextLine();
        Analyze analyze = new Analyze(x);
    }
    
}
