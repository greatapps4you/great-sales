/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.controllers;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import us.greatapps4you.greatsales.services.OS;
import us.greatapps4you.greatsales.services.OSService;

import javax.enterprise.event.Observes;
import java.io.IOException;

@Controller
public class StartupController {
    @ConfigProperty(name = "quarkus.http.open-in-browser", defaultValue = "true")
    boolean startupOpenBrowser;
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    int httpPort;
    @Autowired
    private OSService osService;

    public void setup(@Observes StartupEvent startupEvent) {
        if (startupOpenBrowser) {
            openInBrowser(httpPort);
        }
    }

    private void openInBrowser(int port) {
        String url = "http://localhost:" + port;
        Runtime rt = Runtime.getRuntime();
        try {
            if (osService.which() == OS.MAC) {
                rt.exec("open " + url);
            } else if (osService.which() == OS.RUINDOWS) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osService.which() == OS.LINUX) {
                String[] browsers = {"firefox", "epiphany", "mozilla", "konqueror",
                        "netscape", "opera", "links", "lynx"};

                StringBuffer cmd = new StringBuffer();
                for (int i = 0; i < browsers.length; i++)
                    if (i == 0) {
                        cmd.append(String.format("%s \"%s\"", browsers[i], url));
                    } else {
                        cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
                        // If the first didn't work, try the next browser and so on
                    }
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
