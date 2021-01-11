/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.model.util;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
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
