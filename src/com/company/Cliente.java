package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.lang.Math;

public class Cliente {
    private static final float valorHoraAdicional = 0.5f;
    private static final float tarifaMinima = 2;
    private static final long tempoTarifaMinimaEmHoras = 3;
    private static final float valorMaximo = 10;

    public Cliente(String placa, String descricaoCarro, LocalDateTime horaEntrada) {
        setPlaca(placa);
        setDescricaoCarro(descricaoCarro);
        setHoraEntrada(horaEntrada);
    }

    public Cliente(String placa, String descricaoCarro, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        setPlaca(placa);
        setDescricaoCarro(descricaoCarro);
        setHoraEntrada(horaEntrada);
        setHoraSaida(horaSaida);
    }

    private String placa;
    private String descricaoCarro;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescricaoCarro() {
        return descricaoCarro;
    }

    public void setDescricaoCarro(String descricaoCarro) {
        this.descricaoCarro = descricaoCarro;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }


    public long getTotalHorasEstacionadas() {
        if (horaSaida == null)
            return 0;
        long nanoSegundosEstacionados = ChronoUnit.NANOS.between(horaEntrada, horaSaida);
        long horasEstacionadas = (long)Math.ceil((double)nanoSegundosEstacionados/ Duration.of(1, ChronoUnit.HOURS).toNanos());
        return horasEstacionadas;
    }

    public float getValorTotalAPagar() {
        if (horaSaida == null) {
            return tarifaMinima;
        }
        float valorAPagar = tarifaMinima;

        long totalHoras = getTotalHorasEstacionadas();
        long totalHorasAcimaMinimo = Math.max(totalHoras - tempoTarifaMinimaEmHoras, 0);
        valorAPagar += Math.min(totalHorasAcimaMinimo * valorHoraAdicional, valorMaximo - valorAPagar);

        return valorAPagar;
    }

    @Override
    public String toString() {
        return "Placa: " + getPlaca() + ", descricao do carro: " + getDescricaoCarro() + ", hora de entrada: "
                + getHoraEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))
                + (getHoraSaida() == null ? ", hora de saida: nao definido, total de horas: nao definido, valor a pagar: nao definido" :
                (", hora de saida: " + getHoraSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))
                        + ", total de horas: " + getTotalHorasEstacionadas()
                        + ", valor a pagar: R$" + String.format("%.2f", getValorTotalAPagar())));
    }
}
