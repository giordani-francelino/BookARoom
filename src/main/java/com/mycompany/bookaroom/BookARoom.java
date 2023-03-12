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
    private static Equipamento equipamento = new Equipamento();
    private static Funcionario funcionario = new Funcionario();
    private static SalaReuniao salaReuniao = new SalaReuniao();
    private static RegistradorReserva registradorReserva = new RegistradorReserva();
    private static Reserva reserva = new Reserva();
    private static int codigoPredio = 0;
    private static int codigoSalaReuniao = 0;
    private static LocalDate dataReserva = LocalDate.now();
    private static LocalTime horaInicio = LocalTime.now();
    private static LocalTime horaFim = LocalTime.now();
    private static int campus = 1;
    private static int codigoEquipamento = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        funcionario.setCodigo(1);

        String s;
//        Scanner sc = new Scanner(System.in);
//<editor-fold defaultstate="collapsed" desc="valida funcionário">

// valida funcionario
//        System.out.print("Digite o codigo do Campus:\n");
//        s = sc.next();
//        campus = Integer.parseInt(s);
//        System.out.print("Digite o codigo do Funcionário:\n");
//        s = sc.next();
//        funcionario.setCodigo(Integer.parseInt(s));
        funcionario.getCampus().setCodigo(campus);
        try {
            funcionario = BancoDeDados.recuperaFuncionario(funcionario.getCodigo(), campus);
        } catch (Exception ex) {
            System.out.println("Funcionário não cadstrado.");
            return;
        }
        System.out.println(funcionario.getNome());

//        if (!BancoDeDados.consultaFuncionario(f)) {
//            System.out.println("Funcionário não cadstrado.");
//            return;
//        }
// valida funcionário
//</editor-fold>
        menuPrincipal();
        while (sc.hasNext()) {
            s = sc.next();

            if (Integer.parseInt(s) == 0) {
                break;
            } else if (Integer.parseInt(s) == 1) {

            } else if (Integer.parseInt(s) == 2) {

            } else if (Integer.parseInt(s) == 3) {
                // efetuar reserva
                obterDadosReserva();
                String assunto;
                System.out.print("Digite o assunto da reserva:\n");
                assunto = sc.next();
                reserva.setAssunto(assunto);
                try {
                    registradorReserva.setReserva(reserva);
                    registradorReserva.gerarReserva();
                    System.out.print("Reserva gravada com sucesso.\n");
                    System.out.println(reserva + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (Integer.parseInt(s) == 4) {
                // cancelar reserva 
                obterDadosReserva();

                try {
                    registradorReserva.setReserva(reserva);
                    registradorReserva.cancelarReserva();
                    System.out.println("Reserva cancelada com sucesso\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (Integer.parseInt(s) == 5) {

            } else if (Integer.parseInt(s) == 6) {

            } else {
                break;
            }
            menuPrincipal();

        }

        sc.close(); //Encerra o programa

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
//Date data = formato.parse("23/11/2015");
    }

    public static void menuPrincipal() {
        System.out.print("Selecione uma das opções abaixo:\n");
        System.out.print("1 - Salas livres\n");
        System.out.print("2 - Salas ocupadas\n");
        System.out.print("3 - Efetuar reserva\n");
        System.out.print("4 - Cancelar reserva\n");
        System.out.print("5 - Reservar equipamento\n");
        System.out.print("6 - Cancelar reserva de equipamento\n");
        System.out.print("0 - Sair\n");

    }

    public static void obterDadosReserva() {
        String s;

        System.out.print("Digite o predio:\n");
        s = sc.next();
        codigoPredio = Integer.parseInt(s);
        System.out.print("Digite a sala:\n");
        s = sc.next();
        codigoSalaReuniao = Integer.parseInt(s);
        System.out.print("Digite a data da reserva no formato 'aaaa-mm-dd':\n");
        s = sc.next();
        dataReserva = LocalDate.parse(s);
        System.out.print("Digite a hora de início no formato 'hh:mm':\n");
        s = sc.next();
        horaInicio = LocalTime.parse(s);
        System.out.print("Digite a hora final no formato 'hh:mm':\n");
        s = sc.next();
        horaFim = LocalTime.parse(s);
        salaReuniao.setCodigo(codigoSalaReuniao);
        salaReuniao.getPredio().setCodigo(codigoPredio);
        salaReuniao.getPredio().getCampus().setCodigo(campus);
        reserva.setSalaReuniao(salaReuniao);
        reserva.setDataReserva(dataReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setFuncionario(funcionario);
    }

    public static void obterDadosEquipamento() {
        String s;

        System.out.print("Digite o código do equipamento:\n");
        s = sc.next();
        codigoEquipamento = Integer.parseInt(s);
        equipamento.setCodigo(codigoEquipamento);
        equipamento.getCampus().setCodigo(campus);
    }

}
