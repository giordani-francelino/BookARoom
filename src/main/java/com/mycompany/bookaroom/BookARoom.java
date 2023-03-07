/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bookaroom;

import java.time.LocalDate;
import java.time.LocalTime;
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
        Funcionario f = new Funcionario();
        f.setCodigo(funcionario);
        f.setCodigoCampus(campus);
        if (!BancoDeDados.consultaFuncionario(f)) {
            System.out.println("Funcionário não cadstrado.");
            return;
        }
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
                int codigoSala = 0;
                LocalDate dataEvento = LocalDate.now();
                LocalTime horaInicio = LocalTime.now();
                LocalTime horaFim = LocalTime.now();
                System.out.print("Digite o predio:\n");
                i = sc.next();
                codigoPredio = Integer.parseInt(i);
                System.out.print("Digite a sala:\n");
                i = sc.next();
                codigoSala = Integer.parseInt(i);
                System.out.print("Digite a data da reserva no formato 'aaaa-mm-dd':\n");
                i = sc.next();
                dataEvento = LocalDate.parse(i);
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
                        f.efetuaReserva(codigoPredio, codigoSala, dataEvento,
                                horaInicio, horaFim, assunto);
                        System.out.print("Reserva gravada com sucesso.\n");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    // cancelar reserva    
                } else {
                    b = f.cancelaReserva(codigoPredio, codigoSala, dataEvento,
                            horaInicio, horaFim);
                    if (b == true) {
                        System.out.println("Reserva cancelada com sucesso");
                    } else {
                        System.out.println("Data/horário imdisponivél pra essa sala");
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
