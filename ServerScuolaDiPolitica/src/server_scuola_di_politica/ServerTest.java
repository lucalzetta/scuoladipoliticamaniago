/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server_scuola_di_politica;

/**
 *
 * @author luca
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Formatter;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class ServerTest 
{
    
public ServerTest()throws IOException
{
//int port = server.getLocalPort();
//InetAddress indirizzo = server.getInetAddress();
 //System.out.printf("%nIl server di scuoladipoliticamaniago è stato avviato sulla porta:%d%n"
  //      + "all'indirizzo %s%n", port, indirizzo.toString());

    try(ServerSocket server = new ServerSocket(2206);)
        {
            while(true)
                {
                    try(Socket connection = server.accept())
                        {
                            Writer OUt = new OutputStreamWriter(connection.getOutputStream());
                            Date data = new Date();
                            StringBuilder sb = new StringBuilder();
                            Formatter formatter = new Formatter();
                            sb.append("Buongiorno, sono le: ");
                            formatter.format("%1$th e %1$tM minuti e %1$tS secondi di %1$tA %1$te %1$tB %1$tY%n", data);
                            sb.append(formatter.toString());
                            System.out.printf("%n%s%n", sb.toString());
                            OUt.write(sb.toString() + "\r\n");
                            OUt.flush();
                            connection.close();
                        }
                    catch(IOException ioe)
                        {
                            
                        }
                }
        }
    catch(IOException ioe_ex)
        {
            System.err.printf("%n%s%n", ioe_ex);
        }
        
}
}
