/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.LimitePrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class ControlePrincipal {

    private int codigo;   
    private String titulo;
    private String autor ;
    private int nroPaginas;
    private String editora ;
    private String categoria ;
    private String consultaAcervo;
    private LimitePrincipal lPrinc;
    
    private int codLivro;   
    private int codAssociado;
    private boolean v1,v2;
    
    private String dataRetirada;    
    private String dataEntrega;
  
    Statement stmt;

    public ControlePrincipal() {
        v1=false;
         v2=false;
        codigo=0;
        titulo="";
        autor="";
        titulo="";
        nroPaginas=0;
        editora="";
        categoria ="";
        String hostname, database, user, pass;
        hostname = "localhost";
        database = "biblioteca";
        user = "root";
        pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + database, user, pass);
            stmt = c.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Aplicativo não conectado ao banco"
                    + " de dados.");
        }
    }

    public void run() {
        
        lPrinc=new LimitePrincipal();
        
        /*codigo = 2;
        titulo = "Diario de um mago";
        autor = "Paulo Coelho";
        nroPaginas = 220;
        editora = "Atica";
        categoria = "Ficção";
             System.out.println("Start"   +codigo + "," + titulo    + "," + autor + "," + editora + "," + nroPaginas + "," + categoria );
        inserePublicacao();
        */
        
    }

    public int inserePublicacao() {
        System.out.println(codigo  + "\n "+ titulo +  "\n "+  autor+ "\n "+editora+ "\n "+nroPaginas + "\n "+ categoria);
        try {
            stmt.executeUpdate("INSERT INTO livro VALUES (" + codigo + ", '" + titulo+ "','" + autor + "', '" + editora + "', " + nroPaginas + ", '" + categoria  + "');");
            return 0;

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
            
        }
    }
    public Vector montaForm(){
        Vector novo=new Vector();
        ResultSet rs;
         try {
                rs = stmt.executeQuery("SELECT distinct categoria FROM livro;");
                if (!rs.next()) {
                   JOptionPane.showMessageDialog(null, "Erro: nenhuma categoria encontrada");
                          
                } else {
                    do{
                        novo.add(rs.getString(1));
                    }while(rs.next());
                    return novo;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
      
        
        return novo;
    }
    public String ConsultaAcervo(String item){
        String resultado=new String();
        ResultSet rs;
         try {
                rs = stmt.executeQuery("SELECT *  FROM livro WHERE categoria = "+"'"+item+"'"+";");
                
                  Vector vCod = new Vector();
                    while (rs.next()) {
                        vCod.add(rs.getInt(1));
                        for(int i=2;i<5;i++){
                            vCod.add(rs.getString(i));
                        }
                         vCod.add(rs.getInt(5));
                          vCod.add(rs.getString(6));
                    }
                    Iterator i = vCod.iterator();
                    
                    while (i.hasNext()) {
                       for(int n=1;n<7;n++){
                        resultado+=i.next()+ " - ";
                    }
                       resultado+="\n";
                    }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
         return resultado;
    }
    
    public String ValidaAssociado(){
        String nome;
        ResultSet rs;
        try {
            rs=stmt.executeQuery("SELECT nome FROM associado WHERE codigo" + "=" + codAssociado +";");
            System.out.println("CodAssociado"+codAssociado);
            this.v1=true;
            return ""+rs.getString(1);

            
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return "Erro nro: "+ex.getErrorCode();
            
        }
        
        
    }
    
    public String ValidaLivro(){
        String nome;
         ResultSet rs;
        try {
             rs=stmt.executeQuery("SELECT titulo FROM livro WHERE codigo" + "=" + codLivro +";");
             System.out.println("CodLivro"+codLivro);
            this.v2=true;
            return ""+rs.getString(1);

            
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return "Erro nro"+ex.getErrorCode();
            
        }
        
        
    }
    public String SalvaEmprestimo(){
       ResultSet rs;
       try{
          
                   
                    System.out.println(dataRetirada);
                    stmt.executeUpdate("INSERT INTO Emprestimo (Cod_Associado,Cod_Livro,Data_Retirada)VALUES ("+ codAssociado+","+codLivro+",'"+dataRetirada+"');");
                           
                 //  }
               
       } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return "Erro nro"+ex.getErrorCode();
            
        }
        
        
        return"";
    }
    
    private int calcularExibirMulta(String query, JLabel multa ) {
        ResultSet rs;
        int dia = 0;
        java.sql.Date dataR = null, dataEnt;
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                dataR = (java.sql.Date) rs.getObject(3);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            DateFormat forma = new SimpleDateFormat("yyyy-MM-dd");
            dataEnt = new java.sql.Date(forma.parse(dataEntrega).getTime());
          
            if (((dataEnt.getMonth())==(dataR.getMonth()+1))||((dataEnt.getMonth()==0)&&(dataR.getMonth()==11))) {
                dia = (30 - dataR.getDate()) + dataEnt.getDate();
            } else {
                dia = dataEnt.getDate() - dataR.getDate();
            }
            if(dia<=10)dia=0;
            else dia=dia-10;
            multa.setText("R$"+dia);

        } catch (Exception e) {
            System.out.println("Nao converteu");
        }
    return dia;    
    }

    public void devolve(JLabel multa)  {
        double totalMulta;
        try{
        String query = new String("SELECT * FROM Emprestimo WHERE Cod_Associado = '"
                + codAssociado + "' and Cod_Livro = '"
                + codLivro + "' and Data_Retirada = '"
                + dataRetirada + "'");
        totalMulta=calcularExibirMulta(query, multa);

        stmt.executeUpdate("UPDATE emprestimo SET Data_Devolucao='" + dataEntrega + "',Valor_Multa='" + totalMulta + "' where Cod_Livro='" + codLivro + "'and Data_Retirada='" + dataRetirada + "'and Cod_Associado='" + codAssociado + "';");
        }catch(Exception e) {
            System.out.println("Deu pau");
        }
    }
    //Geters e Seters
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(int nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro= codLivro;
    }

    public int getCodAssociado() {
        return codAssociado;
    }

    public void setCodAssociado(int codAssociado) {
        this.codAssociado = codAssociado;
    }
    
    public boolean isV1() {
        return v1;
    }

    public void setV1(boolean v1) {
        this.v1 = v1;
    }

    public boolean isV2() {
        return v2;
    }

    public void setV2(boolean v2) {
        this.v2 = v2;
    }

  
    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
