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
public class Equipamento {

    private int codigo;
    private int codigoCampus;
    private String nome;
    private int patrimonio;

//<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCampus() {
        return codigoCampus;
    }

    public void setCodigoCampus(int codigoCampus) {
        this.codigoCampus = codigoCampus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

//</editor-fold>

 
    public boolean gerarItemEquipamento(LocalDate dataReserva,
            LocalTime horaInicio, LocalTime horaFim, int codigoFuncionario) throws Exception {
        if (!BancoDeDados.consultaEquipamento(this)) {
            throw new Exception("Equipamento não cadastrada.");
        }

        ItemEquipamento ItemEquipamento = new ItemEquipamento();
        ItemEquipamento.setDataReserva(dataReserva);
        ItemEquipamento.setHoraInicio(horaInicio);
        ItemEquipamento.setHoraFim(horaFim);
        ItemEquipamento.setCodigoSalaReuniao(SalaReuniao);
        ItemEquipamento.setCodigoPredio(codigoPredio);
        ItemEquipamento.setCodigoCampus(codigoCampus);
        ItemEquipamento.setCodigoFuncionario(codigoFuncionario);

//data1.compareTo(date2); //data1 < data2, retorna um valor menor que 0
//data2.compareTo(date1); //data2 > data1, retorna um valor maior que 0
//data1.compareTo(date3); //data1 = data3, então um 0 será mostrado no console
        ArrayList<ItemEquipamento> ItemEquipamentos = BancoDeDados.listaItemEquipamento(codigoCampus);
        for (ItemEquipamento c : ItemEquipamentos) {
            if (c.getCodigoSalaReuniao() == codigo && c.getCodigoPredio() == codigoPredio && c.getCodigoCampus() == codigoCampus) {
                if (ItemEquipamento.getDataReserva().compareTo(c.getDataReserva()) == 0) {
                    if ((ItemEquipamento.getHoraInicio().compareTo(c.getHoraInicio()) >= 0
                            && ItemEquipamento.getHoraInicio().compareTo(c.getHoraFim()) <= 0)
                            || (ItemEquipamento.getHoraFim().compareTo(c.getHoraInicio()) >= 0
                            && ItemEquipamento.getHoraFim().compareTo(c.getHoraFim()) <= 0)) {
                        throw new Exception("Sala já ItemEquipamento nesse horário");
                    }
                }
            }
        }
        BancoDeDados.gravaItemEquipamento(ItemEquipamento);
        return true;

    }

    public boolean cancelarItemEquipamento(LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) throws Exception  {

        ItemEquipamento ItemEquipamento = new ItemEquipamento();
        ItemEquipamento.setDataReserva(dataReserva);
        ItemEquipamento.setHoraInicio(horaInicio);
        ItemEquipamento.setHoraFim(horaFim);
        ItemEquipamento.setCodigoSalaReuniao(codigo);
        ItemEquipamento.setCodigoPredio(codigoPredio);
        ItemEquipamento.setCodigoCampus(codigoCampus);
        return BancoDeDados.excluiItemEquipamento(ItemEquipamento);
//        throw new Exception("Sala não ItemEquipamento nesse horário");

    }
   
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + this.codigoCampus;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
//        final Equipamento other = (Equipamento) obj;
//        if (this.codigo != other.codigo) {
//            return false;
//        }
//        return this.codigoCampus == other.codigoCampus;
        return hashCode() == obj.hashCode();

    }
    
}
