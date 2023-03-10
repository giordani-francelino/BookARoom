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

//<editor-fold defaultstate="collapsed" desc="geters and setters">
    public Reserva getReserva() {
        return reserva;

    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ItemEquipamento getItemEquipamento() {
        return itemEquipamento;
    }

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
            if (c.getReserva() == reserva) {
                BancoDeDados.excluiItemEquipamento(c);
            }
        }

        return BancoDeDados.excluiReserva(reserva);
    }

    public boolean gerarReservaEquipamento() throws Exception {
        if (!BancoDeDados.consultaEquipamento(itemEquipamento.getEquipamento())) {
            throw new Exception("Equipamento não cadastrado.");
        }
        if (!BancoDeDados.consultaReserva(itemEquipamento.getReserva())) {
            throw new Exception("Reserva não cadastrada.");
        }
        ArrayList<ItemEquipamento> itemEquipamentos
                = BancoDeDados.listaItemEquipamento(reserva.getSalaReuniao().getPredio().getCampus().getCodigo());
        for (ItemEquipamento c : itemEquipamentos) {
            if (c.getReserva().getDataReserva().compareTo(itemEquipamento.getReserva().getDataReserva()) == 0) {
                if ((itemEquipamento.getReserva().getHoraInicio().compareTo(c.getReserva().getHoraInicio()) >= 0
                        && itemEquipamento.getReserva().getHoraInicio().compareTo(c.getReserva().getHoraFim()) <= 0)
                        || (itemEquipamento.getReserva().getHoraFim().compareTo(c.getReserva().getHoraInicio()) >= 0
                        && itemEquipamento.getReserva().getHoraFim().compareTo(c.getReserva().getHoraFim()) <= 0)) {
                    throw new Exception("Equipamento já reservado nessa data/horário.");
                    
                }
            }
        }

        return BancoDeDados.gravaItemEquipamento(itemEquipamento);
    }

    public boolean cancelarReservaEquipamento() throws Exception {

        return BancoDeDados.excluiItemEquipamento(itemEquipamento);
    }

//    
}
