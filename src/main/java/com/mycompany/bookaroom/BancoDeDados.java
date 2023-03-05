/*
 * Copyright (C) 2023 Your Name &lt;francelino at ifnmg&gt;
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.mycompany.bookaroom;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class BancoDeDados {

    public BancoDeDados() {
        if (primeiroObjeto) {
            return;
        }
        for (int codigoCampus = 1; codigoCampus < 4; codigoCampus++) {
            Campus campus = new Campus();
            campus.setCodigo(codigoCampus);
            campus.setNome("Campus " + codigoCampus);
            campus.setEndereco("Endereco " + codigoCampus);
            try {
                BancoDeDados.gravaCampus(campus);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            for (int codigoPredio = 1; codigoPredio < 6; codigoPredio++) {
                Predio predio = new Predio();
                predio.setCodigo(codigoPredio);
                predio.setCodigoCampus(codigoCampus);
                predio.setNome("Prédio" + codigoPredio + " - Campus " + codigoCampus);
                try {
                    BancoDeDados.gravaPredio(predio);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
                for (int codigoSalaReuniao = 1; codigoSalaReuniao < 11; codigoSalaReuniao++) {
                    SalaReuniao salaReuniao = new SalaReuniao();
                    salaReuniao.setNumero(codigoSalaReuniao);
                    salaReuniao.setCodigoPredio(codigoPredio);
                    salaReuniao.setCodigoCampus(codigoCampus);
                    predio.setNome("Sala Reunião " + codigoSalaReuniao + " - Prédio" + codigoPredio + " - Campus " + codigoCampus);

                    try {
                        BancoDeDados.gravaSalaReuniao(salaReuniao);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }
            for (int codigoFuncionario = 1; codigoFuncionario < 11; codigoFuncionario++) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(codigoFuncionario);
                funcionario.setCodigoCampus(codigoCampus);
                funcionario.setNome("Funcioánrio " + codigoFuncionario + " - Campus " + codigoCampus);
                try {
                    BancoDeDados.gravaFuncionario(funcionario);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            for (int codigoEquipamento = 1; codigoEquipamento < 100; codigoEquipamento++) {
                Equipamento equipamento = new Equipamento();
                equipamento.setCodigo(codigoEquipamento);
                equipamento.setCodigoCampus(codigoCampus);
                equipamento.setNome("Equipamento " + codigoEquipamento + " - Campus " + codigoCampus);
                try {
                    BancoDeDados.gravaEquipamento(equipamento);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }

        }
        primeiroObjeto = true;
    }
    private static boolean primeiroObjeto = false;
    private static ArrayList<Campus> campuss = new ArrayList<Campus>();
    private static ArrayList<Predio> predios = new ArrayList<Predio>();
    private static ArrayList<SalaReuniao> salaReuniaos = new ArrayList<SalaReuniao>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private static ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private static ArrayList<ItemEquipamentoReserva> itemEquipamentoReservas;

//<editor-fold defaultstate="collapsed" desc="crud campus">
    public static boolean consultaCampus(Campus campus) {
        for (Iterator<Campus> iterator = campuss.iterator(); iterator.hasNext();) {
            Campus c = iterator.next();

            if (campus.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public static void gravaCampus(Campus campus) throws Exception {
        if (consultaCampus(campus)) {
            throw new Exception("Campus já cadastrado.");
        }
        campuss.add(campus);
    }

    public static void excluiCampus(Campus campus) throws Exception {
        if (!consultaCampus(campus)) {
            throw new Exception("Campus não cadastrado.");
        }
        for (Iterator<Campus> iterator = campuss.iterator(); iterator.hasNext();) {
            Campus c = iterator.next();
            if (campus.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud predio">
    public static boolean consultaPredio(Predio predio) {
        for (Iterator<Predio> iterator = predios.iterator(); iterator.hasNext();) {
            Predio p = iterator.next();
            if (predio.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaPredio(Predio predio) throws Exception {
        if (consultaPredio(predio)) {
            throw new Exception("Predio já cadastrado.");
        }
        predios.add(predio);
    }

    public static void excluiPredio(Predio predio) throws Exception {
        if (!consultaPredio(predio)) {
            throw new Exception("Predio não cadastrado.");
        }
        for (Iterator<Predio> iterator = predios.iterator(); iterator.hasNext();) {
            Predio c = iterator.next();
            if (predio.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

    public static ArrayList<Predio> listaPredio(int codigoCampus) {

        ArrayList<Predio> p = new ArrayList<Predio>();
        for (Predio c : predios) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud salaReuniao">
    public static boolean consultaSalaReuniao(SalaReuniao salaReuniao) {
        for (Iterator<SalaReuniao> iterator = salaReuniaos.iterator(); iterator.hasNext();) {
            SalaReuniao c = iterator.next();
            if (salaReuniao.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaSalaReuniao(SalaReuniao salaReuniao) throws Exception {
        if (consultaSalaReuniao(salaReuniao)) {
            throw new Exception("SalaReuniao já cadastrado.");
        }
        salaReuniaos.add(salaReuniao);
    }

    public static void excluiSalaReuniao(SalaReuniao salaReuniao) throws Exception {
        if (!consultaSalaReuniao(salaReuniao)) {
            throw new Exception("SalaReuniao não cadastrado.");
        }
        for (Iterator<SalaReuniao> iterator = salaReuniaos.iterator(); iterator.hasNext();) {
            SalaReuniao c = iterator.next();
            if (salaReuniao.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

    public static ArrayList<SalaReuniao> listaSalaReuniao(int codigoCampus) {

        ArrayList<SalaReuniao> p = new ArrayList<SalaReuniao>();
        for (SalaReuniao c : salaReuniaos) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud funcionario">
    public static boolean consultaFuncionario(Funcionario funcionario) {
        for (Iterator<Funcionario> iterator = funcionarios.iterator(); iterator.hasNext();) {
            Funcionario c = iterator.next();
            if (funcionario.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaFuncionario(Funcionario funcionario) throws Exception {
        if (consultaFuncionario(funcionario)) {
            throw new Exception("Funcionario já cadastrado.");
        }
        funcionarios.add(funcionario);
    }

    public static void excluiFuncionario(Funcionario funcionario) throws Exception {
        if (!consultaFuncionario(funcionario)) {
            throw new Exception("Funcionario não cadastrado.");
        }
        for (Iterator<Funcionario> iterator = funcionarios.iterator(); iterator.hasNext();) {
            Funcionario c = iterator.next();
            if (funcionario.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

    
    public static ArrayList<Funcionario> listaFuncionario(int codigoCampus) {

        ArrayList<Funcionario> p = new ArrayList<Funcionario>();
        for (Funcionario c : funcionarios) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }

    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud equipamento">
    public static boolean consultaEquipamento(Equipamento equipamento) {
        for (Iterator<Equipamento> iterator = equipamentos.iterator(); iterator.hasNext();) {
            Equipamento c = iterator.next();
            if (equipamento.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaEquipamento(Equipamento equipamento) throws Exception {
        if (consultaEquipamento(equipamento)) {
            throw new Exception("Equipamento já cadastrado.");
        }
        equipamentos.add(equipamento);
    }

    public static void excluiEquipamento(Equipamento equipamento) throws Exception {
        if (!consultaEquipamento(equipamento)) {
            throw new Exception("Equipamento não cadastrado.");
        }
        for (Iterator<Equipamento> iterator = equipamentos.iterator(); iterator.hasNext();) {
            Equipamento c = iterator.next();
            if (equipamento.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

       
    public static ArrayList<Equipamento> listaEquipamento(int codigoCampus) {

        ArrayList<Equipamento> p = new ArrayList<Equipamento>();
        for (Equipamento c : equipamentos) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud reserva">
    public static boolean consultaReserva(Reserva reserva) {
        for (Iterator<Reserva> iterator = reservas.iterator(); iterator.hasNext();) {
            Reserva c = iterator.next();
            if (reserva.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaReserva(Reserva reserva) throws Exception {
        if (consultaReserva(reserva)) {
            throw new Exception("Reserva já cadastrado.");
        }
        reservas.add(reserva);
    }

    public static void excluiReserva(Reserva reserva) throws Exception {
        if (!consultaReserva(reserva)) {
            throw new Exception("Reserva não cadastrado.");
        }
        for (Iterator<Reserva> iterator = reservas.iterator(); iterator.hasNext();) {
            Reserva c = iterator.next();
            if (reserva.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }
       
    public static ArrayList<Reserva> listaReserva(int codigoCampus) {

        ArrayList<Reserva> p = new ArrayList<Reserva>();
        for (Reserva c : reservas) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }

    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="crud itemEquipamentoReserva">
    public static boolean consultaItemEquipamentoReserva(ItemEquipamentoReserva itemEquipamentoReserva) {
        for (Iterator<ItemEquipamentoReserva> iterator = itemEquipamentoReservas.iterator(); iterator.hasNext();) {
            ItemEquipamentoReserva c = iterator.next();
            if (itemEquipamentoReserva.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static void gravaItemEquipamentoReserva(ItemEquipamentoReserva itemEquipamentoReserva) throws Exception {
        if (consultaItemEquipamentoReserva(itemEquipamentoReserva)) {
            throw new Exception("ItemEquipamentoReserva já cadastrado.");
        }
        itemEquipamentoReservas.add(itemEquipamentoReserva);
    }

    public static void excluiItemEquipamentoReserva(ItemEquipamentoReserva itemEquipamentoReserva) throws Exception {
        if (!consultaItemEquipamentoReserva(itemEquipamentoReserva)) {
            throw new Exception("ItemEquipamentoReserva não cadastrado.");
        }
        for (Iterator<ItemEquipamentoReserva> iterator = itemEquipamentoReservas.iterator(); iterator.hasNext();) {
            ItemEquipamentoReserva c = iterator.next();
            if (itemEquipamentoReserva.equals(c)) {
                iterator.remove();
                return;
            }
        }
    }

        public static ArrayList<ItemEquipamentoReserva> listaItemEquipamentoReserva(int codigoCampus) {

        ArrayList<ItemEquipamentoReserva> p = new ArrayList<ItemEquipamentoReserva>();
        for (ItemEquipamentoReserva c : itemEquipamentoReservas) {
            if (c.getCodigoCampus() == codigoCampus) {
                p.add(c);
            }
        }
        return p;
    }


    
//</editor-fold>
}
