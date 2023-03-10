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

    private SalaReuniao salaReuniao;
    private Funcionario funcionario;
    
//<editor-fold defaultstate="collapsed" desc="geters and setters">

    public SalaReuniao getSalaReuniao() {
        return salaReuniao;
    }

    public void setSalaReuniao(SalaReuniao salaReuniao) {
        this.salaReuniao = salaReuniao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
//</editor-fold>
    
    public Reserva gerarReserva(LocalDate dataReserva,
            LocalTime horaInicio, LocalTime horaFim, String assunto) throws Exception {
        if (!BancoDeDados.consultaSalaReuniao(salaReuniao)) {
            throw new Exception("Sala não cadastrada.");
        }
        Reserva reserva = new Reserva();
        reserva.setDataReserva(dataReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setCodigoSalaReuniao(salaReuniao.getCodigo());
        reserva.setCodigoPredio(salaReuniao.getCodigoPredio());
        reserva.setCodigoCampus(salaReuniao.getCodigoCampus());
        reserva.setAssunto(assunto);
        reserva.setFuncionario(funcionario);

//data1.compareTo(date2); //data1 < data2, retorna um valor menor que 0
//data2.compareTo(date1); //data2 > data1, retorna um valor maior que 0
//data1.compareTo(date3); //data1 = data3, então um 0 será mostrado no console
        ArrayList<Reserva> reservas = BancoDeDados.listaReserva(salaReuniao.getCodigoCampus());
        for (Reserva c : reservas) {
            if (c.getCodigoSalaReuniao() == salaReuniao.getCodigo()
                    && c.getCodigoPredio() == salaReuniao.getCodigoPredio()
                    && c.getCodigoCampus() == salaReuniao.getCodigoCampus()) {
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
        return reserva;

    }

    public boolean cancelarReserva(SalaReuniao salaReuniao, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) throws Exception {

        Reserva reserva = new Reserva();
        reserva.setDataReserva(dataReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setCodigoSalaReuniao(salaReuniao.getCodigo());
        reserva.setCodigoPredio(salaReuniao.getCodigoPredio());
        reserva.setCodigoCampus(salaReuniao.getCodigoCampus());
        return BancoDeDados.excluiReserva(reserva);
    }

    public boolean gerarReservaEquipamento(Equipamento equipamento, int codigoPredio, int codigoSalaReuniao, LocalDate dataReserva,
            LocalTime horaInicio, LocalTime horaFim) throws Exception {
        if (!BancoDeDados.consultaEquipamento(equipamento)) {
            throw new Exception("Equipamento não cadastrado.");
        }

        ItemEquipamento ItemEquipamento = new ItemEquipamento();
        ItemEquipamento.setCodigoEquipamento(equipamento.getCodigo());
        ItemEquipamento.setDataReserva(dataReserva);
        ItemEquipamento.setHoraInicio(horaInicio);
        ItemEquipamento.setHoraFim(horaFim);
        ItemEquipamento.setCodigoSalaReuniao(codigoSalaReuniao);
        ItemEquipamento.setCodigoPredio(codigoPredio);
        ItemEquipamento.setCodigoCampus(equipamento.getCodigoCampus());

//data1.compareTo(date2); //data1 < data2, retorna um valor menor que 0
//data2.compareTo(date1); //data2 > data1, retorna um valor maior que 0
//data1.compareTo(date3); //data1 = data3, então um 0 será mostrado no console
        ArrayList<ItemEquipamento> ItemEquipamentos = BancoDeDados.listaItemEquipamento(equipamento.getCodigoCampus());
        for (ItemEquipamento c : ItemEquipamentos) {
            if (c.getCodigoEquipamento() == equipamento.getCodigo()
                    && c.getCodigoSalaReuniao() == codigoSalaReuniao
                    && c.getCodigoPredio() == codigoPredio && c.getCodigoCampus() == equipamento.getCodigoCampus()) {
                if (ItemEquipamento.getDataReserva().compareTo(c.getDataReserva()) == 0) {
                    if ((ItemEquipamento.getHoraInicio().compareTo(c.getHoraInicio()) == 0
                            && ItemEquipamento.getHoraFim().compareTo(c.getHoraFim()) == 0)) {
                        throw new Exception("Equipamento já incluido nessa reserva");
                    }
                }
            }
        }
        BancoDeDados.gravaItemEquipamento(ItemEquipamento);
        return true;

    }

    public boolean cancelarReservaEquipamento(Equipamento equipamento, int codigoPredio, int codigoSalaReuniao,
            LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) throws Exception {

        ItemEquipamento ItemEquipamento = new ItemEquipamento();
        ItemEquipamento.setCodigoEquipamento(equipamento.getCodigo());
        ItemEquipamento.setDataReserva(dataReserva);
        ItemEquipamento.setHoraInicio(horaInicio);
        ItemEquipamento.setHoraFim(horaFim);
        ItemEquipamento.setCodigoSalaReuniao(codigoSalaReuniao);
        ItemEquipamento.setCodigoPredio(codigoPredio);
        ItemEquipamento.setCodigoCampus(equipamento.getCodigoCampus());
        return BancoDeDados.excluiItemEquipamento(ItemEquipamento);
    }

}
