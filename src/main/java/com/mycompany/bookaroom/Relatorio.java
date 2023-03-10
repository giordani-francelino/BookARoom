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
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class Relatorio {

    private List<SalaReuniao> salaReuniaos = new ArrayList<SalaReuniao>();
    private List<Reserva> reservas = new ArrayList<Reserva>();
    private List<ItemEquipamento> itemEquipamentos = new ArrayList<ItemEquipamento>();

    public List<Reserva> reservasAtivas(Campus campus) {
        reservas = BancoDeDados.listaReserva(campus.getCodigo());
        Collections.sort(reservas);
        List<Reserva> r = new ArrayList<Reserva>();
        for (Reserva c : reservas) {
            if ((c.getDataReserva().compareTo(LocalDate.now()) == 0
                    && c.getHoraFim().compareTo(LocalTime.now()) >= 0)
                    || c.getDataReserva().compareTo(LocalDate.now()) > 0) {
                r.add(c);
            }
        }

        return r;
    }

    public List<Reserva> reservasInativas(Campus campus) {
        reservas = BancoDeDados.listaReserva(campus.getCodigo());
        Collections.sort(reservas);

        return reservas;
    }

    public List<SalaReuniao> salasLivres(Campus campus) {
        salaReuniaos = BancoDeDados.listaSalaReuniao(campus.getCodigo());
        Collections.sort(salaReuniaos);

        return salaReuniaos;
    }

    public List<SalaReuniao> salasOcupadas(Campus campus) {
        salaReuniaos = BancoDeDados.listaSalaReuniao(campus.getCodigo());
        Collections.sort(salaReuniaos);

        return salaReuniaos;
    }

}
