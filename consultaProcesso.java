public static void viewTable(Connection con, String numEnt, String dbName) throws SQLException {
    //nao sei exatamente como funcionara o resultado da pesquisa, mas eh coisa simples de corrigir (colocando como retorno ou colocando no parametro)
    String numero;
    String tipo;
    String controladoria;
    String data_de_redacao;

    Statement stmt = null;
    String query = "SELECT numero, tipo, controladoria, data_de_redacao FROM " + dbName + ".Funcionario WHERE numero = \"" + numEnt + "\"";
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            numero = rs.getString("numero");
            tipo = rs.getString("tipo");
            controladoria = rs.getString("controladoria");
            data_de_redacao = rs.getString("data_de_redacao");
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
    } finally {
        if (stmt != null) { stmt.close(); }
    }

}
