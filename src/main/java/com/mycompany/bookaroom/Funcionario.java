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

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class Funcionario {

    private int codigo;
    private int codigoCampus;
    private String nome;

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

//</editor-fold>
    public boolean efetuaReserva(int codigoPredio, int codigoSala, LocalDate dataEvento,
            LocalTime horaInicio, LocalTime horaFim) {
        boolean b = false;
        SalaReuniao salaReuniao = new SalaReuniao();
        salaReuniao.setNumero(codigoSala);
        salaReuniao.setCodigoPredio(codigoPredio);
        salaReuniao.setCodigoCampus(this.getCodigoCampus());
        if(!BancoDeDados.consultaSalaReuniao(salaReuniao)){
            return false;
        }
            
        return b;

    }

    public boolean cancelaReserva(int codigoPredio, int codigoSala, LocalDate dataEvento,
            LocalTime horaInicio, LocalTime horaFim) {
        boolean b = false;

        return b;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + this.codigoCampus;
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
//        final Funcionario other = (Funcionario) obj;
//        if (this.codigo != other.codigo) {
//            return false;
//        }
//        return this.codigoCampus == other.codigoCampus;
        return hashCode() == obj.hashCode();

    }

}
