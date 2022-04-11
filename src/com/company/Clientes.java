package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private List<Cliente> listClientes = new ArrayList<Cliente>();

    public void inserirCliente(Cliente cliente){
        listClientes.add(cliente);
    }

    public void exibirClientes(){
        for (var cliente: listClientes) {
            System.out.println(cliente.toString());
        }
    }
}