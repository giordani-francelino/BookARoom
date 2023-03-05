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
import java.util.Objects;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class ItemEquipamentoReserva {

    private int codigoEquipamento;
    private LocalDate horaInicio;
    private LocalDate horaFim;
    private int numeroSala;
    private int codigoPredio;
    private int codigoCampus;

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getCodigoEquipamento() {
        return codigoEquipamento;
    }

    public void setCodigoEquipamento(int codigoEquipamento) {
        this.codigoEquipamento = codigoEquipamento;
    }

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDate horaFim) {
        this.horaFim = horaFim;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCodigoPredio() {
        return codigoPredio;
    }

    public void setCodigoPredio(int codigoPredio) {
        this.codigoPredio = codigoPredio;
    }

    public int getCodigoCampus() {
        return codigoCampus;

    }

    public void setCodigoCampus(int codigoCampus) {
        this.codigoCampus = codigoCampus;
    }

//</editor-fold>
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigoEquipamento;
        hash = 97 * hash + Objects.hashCode(this.horaInicio);
        hash = 97 * hash + Objects.hashCode(this.horaFim);
        hash = 97 * hash + this.numeroSala;
        hash = 97 * hash + this.codigoPredio;
        hash = 97 * hash + this.codigoCampus;
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
//        final ItemEquipamentoReserva other = (ItemEquipamentoReserva) obj;
//        if (this.codigoEquipamento != other.codigoEquipamento) {
//            return false;
//        }
//        if (this.numeroSala != other.numeroSala) {
//            return false;
//        }
//        if (this.codigoPredio != other.codigoPredio) {
//            return false;
//        }
//        if (this.codigoCampus != other.codigoCampus) {
//            return false;
//        }
//        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
//            return false;
//        }
//        return Objects.equals(this.horaFim, other.horaFim);
        return hashCode() == obj.hashCode();

    }

}
