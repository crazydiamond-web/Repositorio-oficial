class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Popular");

        CuentaBancaria cuenta1 = new CuentaBancaria("Yordany Vargas", 5000, 1234, 100001);
        CuentaBancaria cuenta2 = new CuentaBancaria("Yohandy Vargas", 8000, 5678, 100002);

        banco.agregarCuenta(cuenta1);
        banco.agregarCuenta(cuenta2);

        CajeroAutomatico cajero = new CajeroAutomatico("ATM-001", banco);

        System.out.println(" ________Prueba de cajero-Automatico_________");

        cajero.iniciarSesion(100001, 1234);
        cajero.consultarSaldo();
        cajero.realizarRetiro(1000);
        cajero.realizarDeposito(500);
        cajero.consultarSaldo();
        cajero.cerrarSesion();

        System.out.println("Segundo usuario");
        cajero.iniciarSesion(100002, 5678);
        cajero.consultarSaldo();
        cajero.realizarRetiro(10000);
        cajero.realizarRetiro(2000);
        cajero.cerrarSesion();
    }
}
