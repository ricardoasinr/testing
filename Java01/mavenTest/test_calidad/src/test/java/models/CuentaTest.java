package models;

import org.junit.jupiter.api.Test;
import org.testing.exceptions.DineroInsuficienteException;
import org.testing.models.Banco;
import org.testing.models.Cuenta;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Ricardo Asin", new BigDecimal("7864.78"));
        String esperado = "Ricardo ";
        String real = cuenta.getPersona();
        assertEquals(esperado, real);

        //assertTrue(real.equals(esperado));

    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Ricardo Asin", new BigDecimal("-7864.78"));
        assertEquals(7864.78, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO)<0);

        //No puede ser 0
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);

    }

    @Test
    void testDebito(){
        Cuenta cuenta = new Cuenta("Ricardo Asin", new BigDecimal("1000.00"));
        //Que no sea nulo
        assertNotNull(cuenta.getSaldo());
        //Que no sea negativa
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO)<0);
        cuenta.debitoCuenta(new BigDecimal(100));
        //Solo la parte entera
        assertEquals(900, cuenta.getSaldo().intValue());
        //Solo la parte decimal

    }

    @Test
    void testCredito(){
        Cuenta cuenta = new Cuenta("Ricardo Asin", new BigDecimal("1000.00"));
        BigDecimal monto =  new BigDecimal(10);
        //Que no sea nulo
        assertNotNull(cuenta.getSaldo());
        assertNotNull(monto);
        cuenta.creditoCuenta(monto);
        //Solo la parte entera
        assertEquals(1010, cuenta.getSaldo().intValue());
        //Solo la parte decimal

    }

    @Test
    void testTransferirDineroCuentas(){
        Cuenta cuenta1 = new Cuenta("Ricardo Asin", new BigDecimal("3500"));
        Cuenta cuenta2 = new Cuenta("Carola Asin", new BigDecimal("6500"));
        Banco banco = new Banco();
        banco.setNombre("Nubank");
        BigDecimal saldoCuenta1 = cuenta1.getSaldo();
        BigDecimal monto = BigDecimal.valueOf(200.14);
//        if(saldoCuenta1 => monto) {
//
//        }

        banco.transferir(cuenta1, cuenta2, new BigDecimal("200.14"));


        assertEquals("3299.86", cuenta1.getSaldo().toPlainString());

    }

    @Test
    void testDineroInsuficienteException(){
        Cuenta cuenta = new Cuenta("Ana", new BigDecimal("1000"));

                Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
                    cuenta.debitoCuenta(new BigDecimal(1100));
        });

                String actual = exception.getMessage();
                String esperado = "Dinero insuficiente";

                assertEquals(esperado, actual);
    }

    @Test
    void testRelacionBancoCuentas(){

        Cuenta cuenta = new Cuenta("Ana", new BigDecimal("1000"));
        Cuenta cuenta1 = new Cuenta("Victoria", new BigDecimal("1000"));

        Banco banco = new Banco();
        banco.adicionarCuenta(cuenta);
        banco.adicionarCuenta(cuenta1);
        banco.setNombre("Mercantil Santa Cruz");
        banco.transferir(cuenta, cuenta1, new BigDecimal("800"));

        assertEquals("200", cuenta.getSaldo().toPlainString());
        assertEquals("1800", cuenta1.getSaldo().toPlainString());
        assertEquals(2, banco.getCuentaList().size());
        assertEquals("Mercantil Santa Cruz", cuenta1.getBanco().getNombre());
        assertEquals("Ana", banco.getCuentaList().stream().filter(c -> c.getPersona().equals("Ana")).findFirst().get().getPersona());
        assertTrue(banco.getCuentaList().stream().filter(c->c.getPersona().equals("Ana")).findFirst().isPresent());
        assertTrue(banco.getCuentaList().stream().anyMatch(c->c.getPersona().equals("Ana")));

        assertAll(
                ()->assertEquals("200", cuenta.getSaldo().toPlainString()),
                ()->assertEquals("1800", cuenta1.getSaldo().toPlainString()),
                ()->assertEquals(2, banco.getCuentaList().size()),
                ()->assertEquals("Mercantil Santa Cruz", cuenta1.getBanco().getNombre()),
                ()->assertEquals("Ana", banco.getCuentaList().stream().filter(c -> c.getPersona().equals("Ana")).findFirst().get().getPersona()),
                ()->assertTrue(banco.getCuentaList().stream().filter(c->c.getPersona().equals("Ana")).findFirst().isPresent()),
                ()->assertTrue(banco.getCuentaList().stream().anyMatch(c->c.getPersona().equals("Ana"))));

    }

}