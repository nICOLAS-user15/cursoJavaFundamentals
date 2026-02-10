public class Carro {
    private boolean ligado = false;
    private int velocidade = 0;
    private boolean pontoMorto = true;
    private int marcha = 0;
    private String marcaCarro = "";
    
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public boolean isPontoMorto() {
        return pontoMorto;
    }
    public void setPontoMorto(boolean pontoMorto) {
        this.pontoMorto = pontoMorto;
    }  
    public String getMarcaCarro() {
        return marcaCarro;
    }
    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }
    public int getMarcha() {
        return marcha;
    }
    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }
}

