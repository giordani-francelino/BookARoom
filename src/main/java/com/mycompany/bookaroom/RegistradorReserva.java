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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class RegistradorReserva {

    private Reserva reserva = new Reserva();
    private ItemEquipamento itemEquipamento = new ItemEquipamento();

    public Reserva getReserva() {
        return reserva;

    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ItemEquipamento getItemEquipamento() {
        return itemEquipamento;
    }

//<editor-fold defaultstate="collapsed" desc="geters and setters">
    public void setItemEquipamento(ItemEquipamento itemEquipamento) {
        this.itemEquipamento = itemEquipamento;
    }

//</editor-fold>
    public boolean gerarReserva() throws Exception {
        if (!BancoDeDados.consultaSalaReuniao(reserva.getSalaReuniao())) {
            throw new Exception("Sala não cadastrada.");
        }

//data1.compareTo(date2); //data1 < data2, retorna um valor menor que 0
//data2.compareTo(date1); //data2 > data1, retorna um valor maior que 0
//data1.compareTo(date3); //data1 = data3, então um 0 será mostrado no console
        ArrayList<Reserva> reservas
                = BancoDeDados.listaReserva(reserva.getSalaReuniao().getPredio().getCampus().getCodigo());
        for (Reserva c : reservas) {
            if (c.getSalaReuniao() == reserva.getSalaReuniao()) {
                if (reserva.getDataReserva().compareTo(c.getDataReserva()) == 0) {
                    if ((reserva.getHoraInicio().compareTo(c.getHoraInicio()) >= 0
                            && reserva.getHoraInicio().compareTo(c.getHoraFim()) <= 0)
                            || (reserva.getHoraFim().compareTo(c.getHoraInicio()) >= 0
                            && reserva.getHoraFim().compareTo(c.getHoraFim()) <= 0)) {
                        throw new Exception("Sala já reserva nesse horário");
                    }
                }
            }
        }
        BancoDeDados.gravaReserva(reserva);
        return true;
    }

    public boolean cancelarReserva() throws Exception {
//ArrayList<ItemEquipamento> listaItemEquipamento(int codigoCampus)
        ArrayList<ItemEquipamento> itemEquipamentos
                = BancoDeDados.listaItemEquipamento(reserva.getSalaReuniao().getPredio().getCampus().getCodigo());
        for (ItemEquipamento c : itemEquipamentos) {
            if (c.getSalaReuniao() == reserva.getSalaReuniao()) {
                if (c.getEquipamento()==itemEquipamento.getEquipamento()){
                    
                }
                if (reserva.getDataReserva().compareTo(c.getDataReserva()) == 0) {
                    if ((reserva.getHoraInicio().compareTo(c.getHoraInicio()) >= 0
                            && reserva.getHoraInicio().compareTo(c.getHoraFim()) <= 0)
                            || (reserva.getHoraFim().compareTo(c.getHoraInicio()) >= 0
                            && reserva.getHoraFim().compareTo(c.getHoraFim()) <= 0)) {
                        throw new Exception("Sala já reserva nesse horário");
                    }
                }
            }
        }

        return BancoDeDados.excluiReserva(reserva);
    }
//
//    public boolean gerarReservaEquipamento(Equipamento equipamento, int codigoPredio, int codigoSalaReuniao, LocalDate dataReserva,
//            LocalTime horaInicio, LocalTime horaFim) throws Exception {
//        if (!BancoDeDados.consultaEquipamento(equipamento)) {
//            throw new Exception("Equipamento não cadastrado.");
//        }
//
//        ItemEquipamento ItemEquipamento = new ItemEquipamento();
//        ItemEquipamento.setCodigoEquipamento(equipamento.getCodigo());
//        ItemEquipamento.setDataReserva(dataReserva);
//        ItemEquipamento.setHoraInicio(horaInicio);
//        ItemEquipamento.setHoraFim(horaFim);
//        ItemEquipamento.setCodigoSalaReuniao(codigoSalaReuniao);
//        ItemEquipamento.setCodigoPredio(codigoPredio);
//        ItemEquipamento.setCodigoCampus(equipamento.getCodigoCampus());
//
////data1.compareTo(date2); //data1 < data2, retorna um valor menor que 0
////data2.compareTo(date1); //data2 > data1, retorna um valor maior que 0
////data1.compareTo(date3); //data1 = data3, então um 0 será mostrado no console
//        ArrayList<ItemEquipamento> ItemEquipamentos = BancoDeDados.listaItemEquipamento(equipamento.getCodigoCampus());
//        for (ItemEquipamento c : ItemEquipamentos) {
//            if (c.getCodigoEquipamento() == equipamento.getCodigo()
//                    && c.getCodigoSalaReuniao() == codigoSalaReuniao
//                    && c.getCodigoPredio() == codigoPredio && c.getCodigoCampus() == equipamento.getCodigoCampus()) {
//                if (ItemEquipamento.getDataReserva().compareTo(c.getDataReserva()) == 0) {
//                    if ((ItemEquipamento.getHoraInicio().compareTo(c.getHoraInicio()) == 0
//                            && ItemEquipamento.getHoraFim().compareTo(c.getHoraFim()) == 0)) {
//                        throw new Exception("Equipamento já incluido nessa reserva");
//                    }
//                }
//            }
//        }
//        BancoDeDados.gravaItemEquipamento(ItemEquipamento);
//        return true;
//
//    }
//
//    public boolean cancelarReservaEquipamento(Equipamento equipamento, int codigoPredio, int codigoSalaReuniao,
//            LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) throws Exception {
//
//        ItemEquipamento ItemEquipamento = new ItemEquipamento();
//        ItemEquipamento.setCodigoEquipamento(equipamento.getCodigo());
//        ItemEquipamento.setDataReserva(dataReserva);
//        ItemEquipamento.setHoraInicio(horaInicio);
//        ItemEquipamento.setHoraFim(horaFim);
//        ItemEquipamento.setCodigoSalaReuniao(codigoSalaReuniao);
//        ItemEquipamento.setCodigoPredio(codigoPredio);
//        ItemEquipamento.setCodigoCampus(equipamento.getCodigoCampus());
//        return BancoDeDados.excluiItemEquipamento(ItemEquipamento);
//    }

//    
}
