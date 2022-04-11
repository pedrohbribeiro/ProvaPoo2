package com.company;

import java.time.LocalDateTime;
import java.time.Month;

public class ClientesTest {

    public static void main(String[] args) {
        Cliente clienteValorMinimo = new Cliente("1234-123", "Carro top",
                LocalDateTime.of(2022, Month.APRIL, 28, 14, 33, 48), LocalDateTime.of(2022, Month.APRIL, 28, 15, 33, 48));

        Cliente cliente1minutoAcimaMinimo = new Cliente("7652-136", "Carro Feio",
                LocalDateTime.of(2022, Month.APRIL, 28, 14, 33, 48), LocalDateTime.of(2022, Month.APRIL, 28, 17, 34, 48));

        Cliente clienteValorMaximo = new Cliente("7652-136", "Carro que ta aqui a um ano, alguem tira ele pelo amor de deus",
                LocalDateTime.of(2022, Month.APRIL, 28, 14, 33, 48), LocalDateTime.of(2023, Month.APRIL, 28, 17, 34, 48));

        Cliente clienteSemHoraSaida = new Cliente("8574-999", "Nao saiu ainda",
                LocalDateTime.of(2022, Month.APRIL, 11, 15, 22, 11));

        Clientes clientes = new Clientes();

        clientes.inserirCliente(clienteValorMinimo);
        clientes.inserirCliente(cliente1minutoAcimaMinimo);
        clientes.inserirCliente(clienteValorMaximo);
        clientes.inserirCliente(clienteSemHoraSaida);

        clientes.exibirClientes();
    }
}