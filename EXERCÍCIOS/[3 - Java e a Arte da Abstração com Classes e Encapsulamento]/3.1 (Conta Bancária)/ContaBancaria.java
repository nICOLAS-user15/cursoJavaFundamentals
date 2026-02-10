public class ContaBancaria {
    private double saldo = 0;
    private double limiteChequeEspecial = 0;
    private double valorUsadoChequeEspecial = 0;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }

    public void setValorUsadoChequeEspecial(double valorUsadoChequeEspecial) {
        this.valorUsadoChequeEspecial = valorUsadoChequeEspecial;
    }
}