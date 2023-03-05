/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bookaroom;

import java.util.Scanner;

/**
 *
 * @author Caixa
 */
public class BookARoom {

    private static BancoDeDados bd = new BancoDeDados();
    private static BancoDeDados bd1 = new BancoDeDados();

    public static void main(String[] args) {

        int campus = 1;
        int funcionario = 1;

        String s;
        Scanner sc = new Scanner(System.in);
//<editor-fold defaultstate="collapsed" desc="valida funcionário">

// valida funcionario
//        System.out.print("Digite o codigo do Campus:");
//        s = sc.next();
//        campus = Integer.parseInt(s);
//        System.out.print("Digite o codigo do Funcionário:");
//        s = sc.next();
//        funcionario = Integer.parseInt(s);
//        Funcionario f = new Funcionario();
//        f.setCodigo(funcionario);
//        f.setCodigoCampus(campus);
//        if (!BancoDeDados.consultaFuncionario(f)) {
//            System.out.println("Funcionário não cadstrado.");
//            return;
//        }
// valida funcionário
//</editor-fold>
        System.out.print("Selecione uma das opções abaixo:\n");
        System.out.print("1 - Salas livres\n");
        System.out.print("2 - Salas ocupadas\n");
        System.out.print("0 - Sair\n");
        while (sc.hasNext()) {
            s = sc.next();
            if (Integer.parseInt(s) == 0) {
                break;
            }
            System.out.print("Selecione uma das opções abaixo:\n");
            System.out.print("1 - Salas livres\n");
            System.out.print("2 - Salas ocupadas\n");
            System.out.print("0 - Sair\n");

        }
        sc.close(); //Encerra o programa
    }
}
