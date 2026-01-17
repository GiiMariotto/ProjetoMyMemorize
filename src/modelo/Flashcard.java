package modelo;


public class Flashcard {

    private int id;
    private String pergunta;
    private String resposta;

    public Flashcard() {
    }

    public Flashcard(int id, String pergunta, String resposta) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Flashcard(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
