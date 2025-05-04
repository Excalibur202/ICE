/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefas;

import database.DBWorker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ResultSetTableModel;

/**
 *
 * @author Rui Oliveira
 */
public class RecTarefas {
//    private String descricao;
//    private Date dataIncio;
//    private Date dataFim;
//    private double valor;
//    private String estado;
//    private int cartaoCidadaoCliente;
     ResultSet rsdb;
     ResultSetTableModel rsTable;
     ArrayList<Integer> funcIDLinhaTarefas;
     ArrayList<Integer> tarefasCodLinhaTarefas;
     Random rand = new Random();
    
    public void RecolonizarTarefas() {
        try {
            String sqlCodes = "";
            String servidor = "127.0.0.1";
            String user = "root";
            String password = "";
            String baseDados = "gice";
            
            DBWorker db = new DBWorker(servidor, user, password, baseDados);
            
            sqlCodes = "ALTER TABLE tarefas auto_increment = 1;";
            db.executeUpdate(sqlCodes);
            sqlCodes = "SET FOREIGN_KEY_CHECKS = 0;"; 
            db.executeUpdate(sqlCodes);
            sqlCodes = "TRUNCATE TABLE tarefas;";
            db.executeUpdate(sqlCodes);
            sqlCodes = "SET FOREIGN_KEY_CHECKS = 1;";
            db.executeUpdate(sqlCodes);
//            sqlCodes = "DELETE FROM tarefas " + " DBCC CHECKIDENT ('tarefas', RESEED, 0);";
            
            sqlCodes = "INSERT INTO tarefas(cliente_cc,descricao,data_inicio,data_fim,valor,estado) VALUES('14386934', 'Reparar maquina de lavar roupa.', '2019-10-01 10:45:00', '2019-10-01 12:45:00', '40.00', 'terminado'),"
                    + "('14386934', 'Reparar maquina de lavar roupa.', '2022-05-24 09:00:00', '2022-05-24 11:00:00', '40.00', 'terminado'), "
                    + "('14386934', 'Instalar circuito na maquina XPTO.', '2022-04-04 12:00:00', '2022-08-10 17:00:00', '00.00', 'abandonado'), "
                    + "('14386934', 'Instalar cabos de redes.', '2019-12-12 17:00:00', '2019-12-13 15:30:00', '200.00', 'terminado'),"
                    + "('14386934', 'Reparar interruptores.', '2020-08-31 10:00:00', '2020-08-31 10:30:00', '00.00', 'desenvolver'), "
                    + "('14386934', 'Reparar maquina de lavar roupa.', '2010-09-11 20:50:00', '2010-09-12 10:30:00', '40.00', 'terminado'), "
                    + "('14386934', 'Instalar peca XX7S no aquecedor.', '2015-06-30 15:00:00', '2015-06-30 15:30:00', '55.00', 'terminado'), "
                    + "('14386934', 'Reparar maquinas de textil.', '2022-02-20 09:00:00', '2022-02-25 18:00:00', '1500.25', 'terminado'), "
                    + "('14386934', 'Reparar maquina de lavar roupa.', '2011-11-11 11:30:00', '2011-11-11 12:30:00', '40.00', 'terminado'), "
                    + "('14386934', 'Reparar maquina de lavar roupa.', '2012-10-05 14:55:00', '2012-10-06 10:00:00', '40.00', 'terminado'), "
                    + "('14386934', 'Reparar maquina de lavar roupa.', '2013-04-20 15:40:00', '2013-04-20 17:41:00', '40.00', 'terminado'), "
                    + "('14386934', 'Instalar computadores ma escola XPTO.', '2016-01-01 14:00:00', '2017-02-10 16:30:00', '1536.12', 'desenvolver'), "
                    + "('12352454', 'Instalar circuito JSP na maquina XPTO.', '2018-09-10 18:30:00', '2018-09-10 22:40:00', '100.00', 'terminado'), "
                    + "('14785656', 'Reparar processador do computador SPASA-20.', '2014-02-08 08:00:00', '2014-02-08 09:10:00', '57.50', 'terminado'), "
                    + "('12356875', 'Instalar maquina XPTO.', '2011-08-04 16:10:00', '2011-08-04 16:20:00', '00.00', 'abandonado'); ";
//                    + "('15647896', "
//                    + "('25454574', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('14785656', "
//                    + "('16547568', "
//                    + "('17896323', "
//                    + "('26458754', ";
                   
            
            db.executeUpdate(sqlCodes);
            
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(RecTarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void RecolonizarLinhaTarefas() {
        try {
            String sqlCodes = "";
            String servidor = "127.0.0.1";
            String user = "root";
            String password = "";
            String baseDados = "gice";
            
            DBWorker db = new DBWorker(servidor, user, password, baseDados);
            
            sqlCodes = "TRUNCATE TABLE linhatarefas";
            db.executeUpdate(sqlCodes);
            VerificarTarefas();
            VerificarFuncionarios();
            int[] numChosen = new int[15];
            int[] numChosenFunc = new int[15];
            
            for(int i = 0; i < 15; i++) {
                int numAleatorio = tarefasCodLinhaTarefas.get(rand.nextInt(tarefasCodLinhaTarefas.size()));
                numChosen[i] = numAleatorio;
            }
            
            for(int i = 0; i < 15; i++) {
                int numAleatorioFunc = funcIDLinhaTarefas.get(rand.nextInt(funcIDLinhaTarefas.size()));
                numChosenFunc[i] = numAleatorioFunc;
            }
            
            sqlCodes = "INSERT INTO linhatarefas(lntarefaID,funcionarioID,codigo_tarefa,avaliacao) VALUES('A1000','" + numChosenFunc[0] + "','" + numChosen[0] + "','Substituicao da peca XPTO'),"
                    + "('A1001','" + numChosenFunc[1] + "','" + numChosen[1] + "','Substituicao da peca XPTO'),"
                    + "('A1002','" + numChosenFunc[2] + "','" + numChosen[2] + "','Reparacao da peca XPTO'),"
                    + "('A1003','" + numChosenFunc[3] + "','" + numChosen[3] + "','Circuito avariado'),"
                    + "('A1004','" + numChosenFunc[4] + "','" + numChosen[4] + "','Cabos partidos'),"
                    + "('A1005','" + numChosenFunc[5] + "','" + numChosen[5] + "','Circuito avariado na peca XXS'),"
                    + "('A1006','" + numChosenFunc[6] + "','" + numChosen[6] + "','Falta de ligacao'),"
                    + "('A1007','" + numChosenFunc[7] + "','" + numChosen[7] + "','Substituicao da peca XPTO'),"
                    + "('A1008','" + numChosenFunc[8] + "','" + numChosen[8] + "','Falta de recursos'),"
                    + "('A1009','" + numChosenFunc[9] + "','" + numChosen[9]+ "','Avaria no circuito Abcd'),"
                    + "('A1010','" + numChosenFunc[10] + "','" + numChosen[10] + "','Falta de computadores'),"
                    + "('A1011','" + numChosenFunc[11] + "','" + numChosen[11] + "','Substituicao da peca XPTO'),"
                    + "('A1012','" + numChosenFunc[12] + "','" + numChosen[12]+ "','Avaria no total'),"
                    + "('A1013','" + numChosenFunc[13] + "','" + numChosen[13] + "','Instalacao completa sem problemas'),"
                    + "('A1014','" + numChosenFunc[14] + "','" + numChosen[14] +"','Instalacao completa sem problemas');";
            
            db.executeUpdate(sqlCodes);
            
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(RecTarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void RecolonizarClientes() {
        try {
            String sqlCodes = "";
            String servidor = "127.0.0.1";
            String user = "root";
            String password = "";
            String baseDados = "gice";
            
            DBWorker db = new DBWorker(servidor, user, password, baseDados);
            
            sqlCodes = "SET FOREIGN_KEY_CHECKS = 0;"; 
            db.executeUpdate(sqlCodes);
            sqlCodes = "TRUNCATE TABLE clientes";
            db.executeUpdate(sqlCodes);
            sqlCodes = "SET FOREIGN_KEY_CHECKS = 1;";
            db.executeUpdate(sqlCodes);
            
            sqlCodes = "INSERT INTO clientes(cartao_cidadao,nome,morada,telemovel) VALUES('14386934', 'Rui', 'Braga', '915490588'), "
                    + "('12352454', 'Maria', 'Vila de Prado', '923122129'), "
                    + "('14785656', 'Vitor', 'Barcelos', '931442287'), "
                    + "('12356875', 'Ana', 'Vila do Conde', '913445972');";
            
            db.executeUpdate(sqlCodes);
            
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(RecTarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VerificarTarefas() {
        try {
            //Recolonizacao das linhas de tarefas
            String sqlCodes = "";
            String servidor = "127.0.0.1";
            String user = "root";
            String password = "";
            String baseDados = "gice";
            
            DBWorker db = new DBWorker(servidor, user, password, baseDados);
            
            //Atualizacao da tabela das llinhas de tarefas
            String sql = "SELECT codigo FROM tarefas;";
            rsdb = db.executeQuery(sql);
            tarefasCodLinhaTarefas = new ArrayList<>();
            rsTable = new ResultSetTableModel(rsdb);
            
            for(int i = 0; rsTable.getRowCount() > i; i++) {
                tarefasCodLinhaTarefas.add(Integer.parseInt(rsTable.getValueAt(i, 0).toString()));
            }
            
//            tarefasCodLinhaTarefas.forEach(num -> System.out.println("Número: " + num));
           
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(RecTarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VerificarFuncionarios() {
        try {
            //Recolonizacao das linhas de tarefas
            String sqlCodes = "";
            String servidor = "127.0.0.1";
            String user = "root";
            String password = "";
            String baseDados = "gice";
            
            DBWorker db = new DBWorker(servidor, user, password, baseDados);
            
            //Atualizacao da tabela das llinhas de tarefas
            String sql = "SELECT funcID FROM funcionarios;";
            rsdb = db.executeQuery(sql);
            funcIDLinhaTarefas = new ArrayList<>();
            rsTable = new ResultSetTableModel(rsdb);
            
            for(int i = 0; rsTable.getRowCount() > i; i++) {
                funcIDLinhaTarefas.add(Integer.parseInt(rsTable.getValueAt(i, 0).toString()));
            }
            
//            tarefasCodLinhaTarefas.forEach(num -> System.out.println("Número: " + num));
           
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(RecTarefas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
