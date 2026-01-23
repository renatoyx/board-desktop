package br.com.dio.dao;

import br.com.dio.model.Tarefa;
import br.com.dio.persistence.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void criarTabela() {
        var sql = "CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, status TEXT)";

        try (var conn = ConnectionFactory.createConnection();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar(String nome) throws SQLException {
        var sql = "INSERT INTO tarefas (nome, status) VALUES (?, 'PENDENTE')";

        try (var conn = ConnectionFactory.createConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        var sql = "DELETE FROM tarefas WHERE id = ?";

        try (var conn = ConnectionFactory.createConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Tarefa> listar() throws SQLException {
        var lista = new ArrayList<Tarefa>();
        var sql = "SELECT * FROM tarefas";

        try (var conn = ConnectionFactory.createConnection();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Tarefa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("status"))
                );
            }
        }
        return lista;
    }
}