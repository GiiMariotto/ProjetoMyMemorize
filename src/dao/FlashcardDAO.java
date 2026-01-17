package dao;


import conexao.ConexaoBanco;
import modelo.Flashcard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashcardDAO {

    // SALVAR (INSERT)
    public boolean salvar(Flashcard f) {
        String sql = "INSERT INTO flashcard (pergunta, resposta) VALUES (?, ?)";

        try (Connection c = ConexaoBanco.abrirConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, f.getPergunta());
            ps.setString(2, f.getResposta());
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar flashcard: " + e.getMessage());
            return false;
        }
    }

    // LISTAR TODOS (SELECT)
    public List<Flashcard> listarTodos() {
        List<Flashcard> lista = new ArrayList<>();
        String sql = "SELECT * FROM flashcard ORDER BY id";

        try (Connection c = ConexaoBanco.abrirConexao();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Flashcard f = new Flashcard(
                        rs.getInt("id"),
                        rs.getString("pergunta"),
                        rs.getString("resposta")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar flashcards: " + e.getMessage());
        }

        return lista;
    }

    // ATUALIZAR (UPDATE)
    public boolean atualizar(Flashcard f) {
        String sql = "UPDATE flashcard SET pergunta = ?, resposta = ? WHERE id = ?";

        try (Connection c = ConexaoBanco.abrirConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, f.getPergunta());
            ps.setString(2, f.getResposta());
            ps.setInt(3, f.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar flashcard: " + e.getMessage());
            return false;
        }
    }

    // EXCLUIR (DELETE)
    public boolean excluir(int id) {
        String sql = "DELETE FROM flashcard WHERE id = ?";

        try (Connection c = ConexaoBanco.abrirConexao();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir flashcard: " + e.getMessage());
            return false;
        }
    }
}