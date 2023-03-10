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
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class SalaReuniao implements Comparable<SalaReuniao> {

    private int codigo;
    private Predio predio = new Predio();
    private int numLugares;
//<editor-fold defaultstate="collapsed" desc="getters and setters">

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public void setNumLugares(int numLugares) {
        this.numLugares = numLugares;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "SalaReuniao{" + "codigo=" + codigo + ", predio=" + predio + ", numLugares=" + numLugares + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigo;
        hash = 71 * hash + this.predio.getCodigo();
        hash = 71 * hash + this.predio.getCampus().getCodigo();
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
//        return Objects.equals(this.predio, other.predio);
        return hashCode() == obj.hashCode();
    }

    @Override
    public int compareTo(SalaReuniao outraSala) {
        if (this.getPredio().getCampus().getCodigo() > outraSala.getPredio().getCampus().getCodigo()){
            return 1;
        }
        if (this.getPredio().getCampus().getCodigo() < outraSala.getPredio().getCampus().getCodigo()){
            return -1;
        }
        if (this.getPredio().getCodigo() > outraSala.getPredio().getCodigo()){
            return 1;
        }
        if (this.getPredio().getCodigo() < outraSala.getPredio().getCodigo()){
            return -1;
        }
        if (this.getCodigo() > outraSala.getCodigo()){
            return 1;
        }
        if (this.getCodigo() < outraSala.getCodigo()){
            return -1;
        }
        return 0;
    }

}
