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
import java.util.Objects;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class ItemEquipamento {

    private LocalDate dataReserva;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private SalaReuniao salaReuniao = new SalaReuniao();
    private Equipamento equipamento = new Equipamento();

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public SalaReuniao getSalaReuniao() {
        return salaReuniao;
    }

    public void setSalaReuniao(SalaReuniao salaReuniao) {
        this.salaReuniao = salaReuniao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    
    
//</editor-fold>
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dataReserva);
        hash = 71 * hash + Objects.hashCode(this.horaInicio);
        hash = 71 * hash + Objects.hashCode(this.horaFim);
        hash = 71 * hash + Objects.hashCode(this.salaReuniao);
        hash = 71 * hash + Objects.hashCode(this.equipamento);
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
        return hashCode() == obj.hashCode();

    }

}
