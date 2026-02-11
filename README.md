# 🏎️ BoardPro Desktop

> Um gerenciador de tarefas robusto desenvolvido em Java, aplicando conceitos de Engenharia de Software e Arquitetura em Camadas.

## 🛠️ Tecnologias Utilizadas
- **Java 17/25**: Linguagem base.
- **Swing**: Interface Gráfica (GUI) nativa.
- **SQLite**: Banco de dados relacional embarcado.
- **Maven**: Gerenciamento de dependências e build.
- **JDBC**: Conectividade de banco de dados de baixo nível.

## ⚙️ Arquitetura
O projeto segue o padrão **MVC (Model-View-Controller)** adaptado com **DAO (Data Access Object)**:
1.  **Model**: Representação das entidades (`Tarefa`).
2.  **DAO**: Abstração das regras SQL e persistência, prevenindo SQL Injection com `PreparedStatement`.
3.  **View**: Interface construída com Swing, desacoplada da lógica de banco via `TableModel`.

## 🚀 Como Rodar
1. Clone o repositório:
   ```bash
   git clone [https://github.com/renatoyx/board-desktop.git](https://github.com/renatoyx/board-desktop.git)