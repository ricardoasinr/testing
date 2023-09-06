package org.testing.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    public Banco ( ){
        cuentaList = new ArrayList<>();
    }

    String nombre;



    List<Cuenta> cuentaList;

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, BigDecimal monto){
        cuentaOrigen.debitoCuenta(monto);
        cuentaDestino.creditoCuenta(monto);

    }

    public void adicionarCuenta(Cuenta cuenta){
        cuentaList.add(cuenta);
        cuenta.setBanco(this);
    }
}
