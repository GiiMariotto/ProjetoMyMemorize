package modelo;

import dao.FlashcardDAO;
import java.util.List;

public class GerenciadorFlashcard {

    //  ATRIBUTOS (estavam faltando)
    private List<Flashcard> cartoes;
    private int indiceAtual = 0;
    private boolean mostrandoResposta = false;

    private FlashcardDAO dao = new FlashcardDAO();

    // CONSTRUTOR
    public GerenciadorFlashcard() {
        cartoes = dao.listarTodos();

        System.out.println("TOTAL DE FLASHCARDS CARREGADOS: " + cartoes.size());

        if (cartoes.isEmpty()) {
            System.out.println("Nenhum flashcard encontrado no banco!");
        }
    }

    //  MÉTODOS
    public void adicionarFlashcard(Flashcard flashcard) {
        if (dao.salvar(flashcard)) {
            cartoes = dao.listarTodos(); // recarrega a lista
            indiceAtual = cartoes.size() - 1;
            mostrandoResposta = false;
        }
    }

    public boolean temProximo() {
        return !cartoes.isEmpty() && indiceAtual < cartoes.size() - 1;
    }

    public boolean temAnterior() {
        return !cartoes.isEmpty() && indiceAtual > 0;
    }

    public void mostrarProximo() {
        if (temProximo()) {
            indiceAtual++;
            mostrandoResposta = false;
        }
    }

    public void mostrarAnterior() {
        if (temAnterior()) {
            indiceAtual--;
            mostrandoResposta = false;
        }
    }

    public void alternarVirada() {
        if (!cartoes.isEmpty()) {
            mostrandoResposta = !mostrandoResposta;
        }
    }

    public Flashcard obterFlashcardAtual() {
        if (cartoes.isEmpty()) return null;
        return cartoes.get(indiceAtual);
    }

    public int obterIndiceAtual() {
        return indiceAtual;
    }

    public int obterTotalCartoes() {
        return cartoes.size();
    }

    public boolean estaMostrandoResposta() {
        return mostrandoResposta;
    }

    public boolean estaVazio() {
        return cartoes.isEmpty();
    }
}
