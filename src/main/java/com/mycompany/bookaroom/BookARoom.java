/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bookaroom;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//        System.out.print("Digite o codigo do Campus:\n");
//        s = sc.next();
//        campus = Integer.parseInt(s);
//        System.out.print("Digite o codigo do Funcionário:\n");
//        s = sc.next();
//        funcionario = Integer.parseInt(s);
        Funcionario f = new Funcionario();
        f.setCodigo(funcionario);
        f.setCodigoCampus(campus);
        try {
            f = BancoDeDados.recuperaFuncionario(funcionario, campus);
        } catch (Exception ex) {
            System.out.println("Funcionário não cadstrado.");
            return;
        }
        System.out.println(f.getNome());

//        if (!BancoDeDados.consultaFuncionario(f)) {
//            System.out.println("Funcionário não cadstrado.");
//            return;
//        }
// valida funcionário
//</editor-fold>
        System.out.print("Selecione uma das opções abaixo:\n");
        System.out.print("1 - Salas livres\n");
        System.out.print("2 - Salas ocupadas\n");
        System.out.print("3 - Efetuar reserva\n");
        System.out.print("4 - Cancelar reserva\n");
        System.out.print("0 - Sair\n");
        while (sc.hasNext()) {
            s = sc.next();
            String i;

            if (Integer.parseInt(s) == 0) {
                break;
            } else if (Integer.parseInt(s) == 1) {

            } else if (Integer.parseInt(s) == 2) {
                // incluir e excluir reserva
            } else if (Integer.parseInt(s) == 3 || (Integer.parseInt(s) == 4)) {
                int codigoPredio = 0;
                int codigoSalaReuniao = 0;
                LocalDate dataReserva = LocalDate.now();
                LocalTime horaInicio = LocalTime.now();
                LocalTime horaFim = LocalTime.now();
                System.out.print("Digite o predio:\n");
                i = sc.next();
                codigoPredio = Integer.parseInt(i);
                System.out.print("Digite a sala:\n");
                i = sc.next();
                codigoSalaReuniao = Integer.parseInt(i);
                System.out.print("Digite a data da reserva no formato 'aaaa-mm-dd':\n");
                i = sc.next();
                dataReserva = LocalDate.parse(i);
                System.out.print("Digite a hora de início no formato 'hh:mm':\n");
                i = sc.next();
                horaInicio = LocalTime.parse(i);
                System.out.print("Digite a hora final no formato 'hh:mm':\n");
                i = sc.next();
                horaFim = LocalTime.parse(i);
                // efetuar reserva
                boolean b = false;
                if (Integer.parseInt(s) == 3) {
                    String assunto;
                    System.out.print("Digite o assunto da reserva:\n");
                    assunto = sc.next();
                    try {
                        f.efetuaReserva(codigoPredio, codigoSalaReuniao, dataReserva,
                                horaInicio, horaFim, assunto);
                        System.out.print("Reserva gravada com sucesso.\n");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    // cancelar reserva    
                } else {
                    try {
                        f.cancelaReserva(codigoPredio, codigoSalaReuniao, dataReserva,
                                horaInicio, horaFim);
                        System.out.println("Reserva cancelada com sucesso\n");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            } else {
                break;
            }
            System.out.print("Selecione uma das opções abaixo:\n");
            System.out.print("1 - Salas livres\n");
            System.out.print("2 - Salas ocupadas\n");
            System.out.print("3 - Efetuar reserva\n");
            System.out.print("4 - Cancelar reserva\n");
            System.out.print("0 - Sair\n");

        }
        sc.close(); //Encerra o programa

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
//Date data = formato.parse("23/11/2015");
    }
}
