class CuentaBancaria {
    String titular;
    int saldo;
    int pin;
    int numeroCuenta;

    CuentaBancaria(String titular, int saldo, int pin, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.pin = pin;
        this.numeroCuenta = numeroCuenta;
    }

    boolean verificarPin(int pinIngresado) {
        return pin == pinIngresado;
    }

    void depositar(int cantidad) {
        saldo = saldo + cantidad;
    }

    boolean retirar(int cantidad) {
        if (saldo >= cantidad) {
            saldo = saldo - cantidad;
            return true;
        }
        return false;
    }

    int getSaldo() {
        return saldo;
    }
}

class Banco {
    String nombreBanco;
    CuentaBancaria[] cuentas;
    int contador;

    Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.cuentas = new CuentaBancaria[10];
        this.contador = 0;
    }

    void agregarCuenta(CuentaBancaria cuenta) {
        cuentas[contador] = cuenta;
        contador++;
    }

    CuentaBancaria buscarCuenta(int numeroCuenta) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].numeroCuenta == numeroCuenta) {
                return cuentas[i];
            }
        }
        return null;
    }
}

class CajeroAutomatico {
    String idCajero;
    CuentaBancaria cuentaActual;
    Banco banco;

    CajeroAutomatico(String idCajero, Banco banco) {
        this.idCajero = idCajero;
        this.banco = banco;
        this.cuentaActual = null;
    }

    boolean iniciarSesion(int numeroCuenta, int pin) {
        CuentaBancaria cuenta = banco.buscarCuenta(numeroCuenta);
        if (cuenta != null && cuenta.verificarPin(pin)) {
            cuentaActual = cuenta;
            System.out.println("Sesion iniciada. Bienvenido " + cuenta.titular);
            return true;
        }
        System.out.println("Numero de cuenta o PIN incorrecto");
        return false;
    }

    void consultarSaldo() {
        if (cuentaActual != null) {
            System.out.println("Tu saldo es: " + cuentaActual.getSaldo());
        } else {
            System.out.println("Debes iniciar sesion primero");
        }
    }

    void realizarRetiro(int cantidad) {
        if (cuentaActual != null) {
            if (cuentaActual.retirar(cantidad)) {
                System.out.println("Retiro exitoso. Nuevo saldo: " + cuentaActual.getSaldo());
            } else {
                System.out.println("Fondos insuficientes");
            }
        } else {
            System.out.println("Debes iniciar sesion primero");
        }
    }

    void realizarDeposito(int cantidad) {
        if (cuentaActual != null) {
            cuentaActual.depositar(cantidad);
            System.out.println("Deposito exitoso. Nuevo saldo: " + cuentaActual.getSaldo());
        } else {
            System.out.println("Debes iniciar sesion primero");
        }
    }

    void cerrarSesion() {
        if (cuentaActual != null) {
            System.out.println("Sesion cerrada. Hasta luego " + cuentaActual.titular);
            cuentaActual = null;
        }
    }

    void mostrarMenu() {
        System.out.println("\n--- Menu Cajero ---");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Cerrar sesion");
    }
}

