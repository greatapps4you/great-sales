package br.com.greatsoft.greaterp.model.util;

import br.com.greatsoft.greaterp.common.FileUtil;
import java.sql.SQLException;
import org.h2.tools.Server;

public class H2Server {
    public H2Server() {
    }

    public static void start(String port) {
        try {
            Server server = Server.createTcpServer(new String[]{"-tcp", "-tcpAllowOthers", "-tcpPort", port});
            server.start();
            System.out.println("H2 Server Started");
        } catch (SQLException var2) {
            FileUtil.log(var2);
            System.out.println("Erro ao tentar se conectar.");
        }

    }
}
