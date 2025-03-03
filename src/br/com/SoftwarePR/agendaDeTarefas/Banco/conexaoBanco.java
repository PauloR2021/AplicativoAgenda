/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SoftwarePR.AgendaDeTarefas.Banco;


import br.com.SoftwarePR.AgendaDeTarefas.Construtor.construtorCadastro;
import br.com.SoftwarePR.AgendaDeTarefas.Construtor.construtorCriarTarefa;
import br.com.SoftwarePR.AgendaDeTarefas.Construtor.construtorNomeLogin;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Paulo
 */
public class conexaoBanco {
    public static Connection conexao() {
       
       String url = "jdbc:sqlserver://localhost:1433;databaseName=PROJETOS_JAVA;encrypt=true;trustServerCertificate=true;";
       String usuario = "SA";
       String senha = "@Rt_16112001";
       
       Connection conn = null;

       try {
           
           conn = DriverManager.getConnection(url, usuario, senha);
           System.out.println("Conectado com sucesso!");
       } catch (SQLException e) {
           System.out.println("Erro na conexão: " + e.getMessage());
        }
        return conn;
    }
    
    public void AdicionarTarefa(construtorCriarTarefa Tarefa) throws SQLException{
        
        String sql = "INSERT INTO PROJETOS_JAVA.dbo.CRIAR_TAREFA (NOME, DESCRICAO, DATA, STATUS) VALUES(?,?,?,?)";
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, Tarefa.getNome());
            stmt.setString(2, Tarefa.getDescricao());
            stmt.setString(3, Tarefa.getData());
            stmt.setInt(4, Tarefa.getStatus());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Tarefa Cadastrada com Sucesso !!");
            conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conexao().close();
            
        }
        
    }
    

    public List<construtorCriarTarefa>ListarTarefas(){
        
        List<construtorCriarTarefa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM PROJETOS_JAVA.dbo.CRIAR_TAREFA; ";
        
        try(Connection conn = conexaoBanco.conexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                construtorCriarTarefa linha = new construtorCriarTarefa();
                linha.setId(rs.getInt("ID"));
                linha.setNome(rs.getString("NOME"));
                linha.setDescricao(rs.getString("DESCRICAO"));
                linha.setData(rs.getString("DATA"));
                linha.setStatus(rs.getInt("STATUS"));
                
                lista.add(linha);
            }
            
            return lista;
            
        }catch (SQLException e){
            
        }
        
        return null;
        
    }
    
    public List<construtorCriarTarefa>ListarTarefasBuscar(String Busca){
        
        List<construtorCriarTarefa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM PROJETOS_JAVA.dbo.CRIAR_TAREFA WHERE NOME LIKE ? OR DESCRICAO LIKE ? OR DATA LIKE ?";
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            
            stmt.setString(1, "%" +Busca + "%");
            stmt.setString(2, "%" +Busca + "%");
            stmt.setString(3, "%" +Busca + "%");
          
            
            ResultSet rs=stmt.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Consulta Vazia","Consulta Vazia",JOptionPane.ERROR_MESSAGE);
                
            }else{
                do{
                    construtorCriarTarefa linha = new construtorCriarTarefa();
                    linha.setId(rs.getInt("ID"));
                    linha.setNome(rs.getString("NOME"));
                    linha.setDescricao(rs.getString("DESCRICAO"));
                    linha.setData(rs.getString("DATA"));
                    linha.setStatus(rs.getInt("STATUS"));

                    lista.add(linha);
                }while(rs.next());
            }
            
            
            return lista;
            
        }catch (SQLException e){
                       
        }
        
        return null;
        
    }
    
    
    public void AlterarTarefa(construtorCriarTarefa Tarefa) throws SQLException{
        
        String sql = """
                     UPDATE PROJETOS_JAVA.dbo.CRIAR_TAREFA
                     SET NOME=?, DESCRICAO=?, [DATA]=?, STATUS=?
                     WHERE ID=?;""";
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, Tarefa.getNome());
            stmt.setString(2, Tarefa.getDescricao());
            stmt.setString(3, Tarefa.getData());
            stmt.setInt(4, Tarefa.getStatus());
            stmt.setInt(5, Tarefa.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Tarefa Alterarda com Sucesso !!");
            conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conexao().close();
            
        }
        
    }
    
    public void DeletarTarefa(construtorCriarTarefa Tarefa) throws SQLException{
        
        String sql = """
                     DELETE FROM PROJETOS_JAVA.dbo.CRIAR_TAREFA
                     WHERE ID=?; """;
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, Tarefa.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Tarefa Excluida com Sucesso !!");
            conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conexao().close();
            
        }
        
    }
    
    public List<construtorNomeLogin> Login(String usuario,String senha) throws SQLException{
       List<construtorNomeLogin> lista = new ArrayList<>();
       String sql = "SELECT * FROM PROJETOS_JAVA.dbo.USUARIO_LOGIN WHERE USUARIO = ? AND SENHA = ?";
        
        try (Connection conn = conexaoBanco.conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
                construtorNomeLogin linha = new construtorNomeLogin ();
                linha.setNome(rs.getString("NOME"));
                linha.setPrimeiroAcesso(rs.getInt("PRIMEIRO_LOGIN"));
                
                lista.add(linha);
                
                return lista;
           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    public void AlterarLogin(construtorNomeLogin Login) throws SQLException{
        
        String sql = """
                     UPDATE PROJETOS_JAVA.dbo.USUARIO_LOGIN
                     SET SENHA=?,EMAIL=?, PRIMEIRO_LOGIN=1
                     WHERE USUARIO=?;""";
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, Login.getSenha());
            stmt.setString(2, Login.getEmail());
            stmt.setString(3, Login.getUsuario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Senha Alterada com Sucesso !!");
            conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conexao().close();
            
        }
        
    }
        
    public void AdicionarCadastro(construtorCadastro Cadastro) throws SQLException{
        
        String sql = """
                     INSERT INTO PROJETOS_JAVA.dbo.USUARIO_LOGIN
                     (NOME, USUARIO, SENHA, CPF, EMAIL, PRIMEIRO_LOGIN)
                     VALUES(?,?,?,?,?,?);
                     """;
        
        try(Connection conn = conexaoBanco.conexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, Cadastro.getNome());
            stmt.setString(2, Cadastro.getUsuario());
            stmt.setString(3, Cadastro.getSenha());
            stmt.setString(4, Cadastro.getCpf());
            stmt.setString(5, Cadastro.getEmail());
            stmt.setInt(6, Cadastro.getLogin());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso !");
            conn.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            conexao().close();
            
        }
        
    }
    
   
}
    


