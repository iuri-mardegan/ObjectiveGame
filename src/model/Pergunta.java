package model;

public class Pergunta {
    private String pergunta;
    private String prato;
    private Pergunta respSim;
    private Pergunta respNao;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public Pergunta getRespSim() {
        return respSim;
    }

    public void setRespSim(Pergunta respSim) {
        this.respSim = respSim;
    }

    public Pergunta getRespNao() {
        return respNao;
    }

    public void setRespNao(Pergunta respNao) {
        this.respNao = respNao;
    }

    public Pergunta(String pergunta, String prato, Pergunta respSim, Pergunta respNao) {
        this.pergunta = pergunta;
        this.prato = prato;
        this.respSim = respSim;
        this.respNao = respNao;
    }
}
