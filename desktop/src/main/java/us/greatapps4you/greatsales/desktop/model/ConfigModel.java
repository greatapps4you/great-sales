/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.model;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

public class ConfigModel {
    private Properties cfg = new Properties();

    public ConfigModel() {
        try {
            this.cfg = this.carregar(FileUtil.getHome() + "cfg/config.xml");
        } catch (Exception var2) {
            FileUtil.log(var2);
        }

    }

    public void salvar(Map<String, String> cfg, String cfgPath, String comment) {
        File file = new File(cfgPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        Properties properties = new Properties();
        Iterator var6 = cfg.entrySet().iterator();

        while(var6.hasNext()) {
            Entry<String, String> entry = (Entry)var6.next();
            properties.setProperty((String)entry.getKey(), (String)entry.getValue());
        }

        try {
            properties.storeToXML(new FileOutputStream(cfgPath + "config.xml"), comment);
            JOptionPane.showMessageDialog((Component)null, "Configurações efetuadas com sucesso!\nPor favor, reinicie o sistema!");
            System.exit(0);
        } catch (IOException var8) {
            FileUtil.log(var8);
            JOptionPane.showMessageDialog((Component)null, "Erro ao tentar salvar configurações.");
            System.exit(0);
        }

    }

    public final Properties carregar(String xmlProp) {
        Properties properties = new Properties();

        try {
            InputStream input = new FileInputStream(xmlProp);
            Throwable var4 = null;

            try {
                properties.loadFromXML(input);
            } catch (Throwable var15) {
                var4 = var15;
                throw var15;
            } finally {
                if (input != null) {
                    if (var4 != null) {
                        try {
                            input.close();
                        } catch (Throwable var14) {
                            var4.addSuppressed(var14);
                        }
                    } else {
                        input.close();
                    }
                }

            }
        } catch (FileNotFoundException var17) {
            FileUtil.log(var17);
        } catch (IOException var18) {
            FileUtil.log(var18);
        }

        return properties;
    }

    public Properties getCfg() {
        return this.cfg;
    }
}
