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
public class SalaReuniao {

    private int codigo;
    private int codigoPredio;
    private int codigoCampus;
    private int numLugares;
//<editor-fold defaultstate="collapsed" desc="getters and setters">

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getNumLugares() {
        return numLugares;
    }

    public void setNumLugares(int numLugares) {
        this.numLugares = numLugares;
    }
//</editor-fold>

    public boolean gerarReserva(LocalDate dataReserva,
            LocalTime horaInicio, LocalTime horaFim, String assunto, int codigoFuncionario) {
        boolean b = false;
        if (!BancoDeDados.consultaSalaReuniao(this)) {
            return false;
        }

        Reserva reserva = new Reserva();
        reserva.setDataReserva(dataReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setCodigoSala(codigo);
        reserva.setCodigoPredio(codigoPredio);
        reserva.setCodigoCampus(codigoCampus);
        reserva.setAssunto(assunto);
        reserva.setCodigoFuncionario(codigoFuncionario);

        ArrayList<Reserva> reservas = BancoDeDados.listaReserva(codigoCampus);
        for (Reserva c : reservas) {
            if (c.getCodigoSala() == codigo && c.getCodigoPredio() == codigoPredio && c.getCodigoCampus() == codigoCampus) {
                if (c.getDataReserva().compareTo(reserva.getDataReserva())==0){
                    
                }
            }
        }
        try {
            BancoDeDados.gravaReserva(reserva);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return true;

    }

    public void cancelarReserva(LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim) {

        Reserva reserva = new Reserva();
        reserva.setDataReserva(dataReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setCodigoSala(codigo);
        reserva.setCodigoPredio(codigoPredio);
        reserva.setCodigoCampus(codigoCampus);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigo;
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
//        final SalaReuniao other = (SalaReuniao) obj;
//        if (this.codigo != other.codigo) {
//            return false;
//        }
//        if (this.codigoPredio != other.codigoPredio) {
//            return false;
//        }
//        return this.codigoCampus == other.codigoCampus;
        return hashCode() == obj.hashCode();

    }

}
