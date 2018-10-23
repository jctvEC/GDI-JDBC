public static void viewTable(Connection con, String CPFent, String dbName) throws SQLException {
    //nao sei exatamente como funcionara o resultado da pesquisa, mas eh coisa simples de corrigir (colocando como retorno ou colocando no parametro)
    int salario;
    String CPF_supervisionador;
    String CPF_p;
    String nome;
    char genero;
    String c;
    String CEP;
    String pais;
    String rua;
    String estado;
    String bairro;
    String complemento;
    int numero;

    Statement stmt = null;
    String query1 = "SELECT CPF_p, CPF_supervisionador, salario FROM " + dbName + ".Funcionario WHERE CPF_p = \"" + CPFent + "\"";
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query1);
        while(rs.next()){
            CPF_p = rs.getString("CPF_p");
            CPF_supervisionador = rs.getString("CPF_supervisionador");
            salario = rs.getInt("salario");
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
    } finally {
        if (stmt != null) { stmt.close(); }
    }

    stmt = null;
    String query2 = "SELECT nome, genero, data_de_nascimento_inauguracao, CEP FROM " + dbName + ".Pessoa WHERE CPF_CNPJ = \"" + CPF_p + "\"";
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query2);
        while(rs.next()){
            nome = rs.getString("nome");
            genero = rs.getChar("genero");
            data_de_nascimento_inauguracao = rs.getString("data_de_nascimento_inauguracao");
            CEP = rs.getString("CEP");
        }
    }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
    } finally {
        if (stmt != null) { stmt.close(); }
    }

    stmt = null;
    String query3 = "SELECT pais, estado, bairro, rua, complemento, numero FROM " + dbName + ".Endereco  WHERE CEP = \"" + CEP + "\"";
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query3);
        while(rs.next()){
            pais = rs.getString("pais");
            estado = rs.getString("estado");
            bairro = rs.getString("bairro");
            rua = rs.getString("rua");
            complemento = rs.getString("complemento");
            numero = rs.getInt("numero");
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
}
