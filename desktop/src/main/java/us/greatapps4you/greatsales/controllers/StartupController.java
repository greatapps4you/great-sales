package us.greatapps4you.greatsales.controllers;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.stereotype.Controller;

import javax.enterprise.event.Observes;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class StartupController {
    @ConfigProperty(name = "quarkus.http.open-in-browser", defaultValue = "true")
    boolean startupOpenBrowser;
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    int httpPort;

    public void setup(@Observes StartupEvent startupEvent) {
        if (startupOpenBrowser) {
            openInBrowser(httpPort);
        }
    }

    private void openInBrowser(int port) {
        String url = "http://localhost:" + port;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop == null || !desktop.isSupported(Desktop.Action.BROWSE)) {
            // There is no default browser
            return;
        }
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Failed opening the default browser to show the URL (" + url + ").", e);
        }
    }
}
