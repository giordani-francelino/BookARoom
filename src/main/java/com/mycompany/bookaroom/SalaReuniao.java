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

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class SalaReuniao {

    private int numero;
    private int codigoPredio;
    private int codigoCampus;
    private int numLugares;
//<editor-fold defaultstate="collapsed" desc="getters and setters">

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public void gerarReserva(LocalDate horaInicio, LocalDate horaFim, String assunto) {

        Reserva reserva = new Reserva();
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setNumeroSala(numero);
        reserva.setCodigoPredio(codigoPredio);
        reserva.setCodigoCampus(codigoCampus);
        reserva.setAssunto(assunto);

    }

    public void cancelarReserva(LocalDate horaInicio, LocalDate horaFim, String assunto) {

        Reserva reserva = new Reserva();
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);
        reserva.setNumeroSala(numero);
        reserva.setCodigoPredio(codigoPredio);
        reserva.setCodigoCampus(codigoCampus);

        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.numero;
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
//        if (this.numero != other.numero) {
//            return false;
//        }
//        if (this.codigoPredio != other.codigoPredio) {
//            return false;
//        }
//        return this.codigoCampus == other.codigoCampus;
        return hashCode() == obj.hashCode();


    }


}
