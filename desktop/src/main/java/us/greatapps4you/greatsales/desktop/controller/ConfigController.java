package us.greatapps4you.greatsales.desktop.controller;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
import us.greatapps4you.greatsales.desktop.model.ConfigModel;
import us.greatapps4you.greatsales.desktop.view.config.ConfigView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ConfigController {
    private final ConfigView view;
    private final ConfigModel model;

    public ConfigController(ConfigView view, ConfigModel model) {
        this.view = view;
        this.model = model;
        this.view.addSalvarListener(new ConfigController.SalvarListener());
        this.initFields();
    }

    private void initFields() {
        this.view.setHost(this.model.getCfg().getProperty("host"));
        this.view.setPort(this.model.getCfg().getProperty("port"));
        this.view.setDatabase(this.model.getCfg().getProperty("database"));
        this.view.setMode(this.model.getCfg().getProperty("mode"));
    }

    class SalvarListener implements ActionListener {
        SalvarListener() {
        }

        public void actionPerformed(ActionEvent e) {
            Map<String, String> cfg = new HashMap();
            String mode = ConfigController.this.view.getMode();
            cfg.put("host", ConfigController.this.view.getHost());
            cfg.put("port", ConfigController.this.view.getPort());
            cfg.put("database", ConfigController.this.view.getDatabase());
            cfg.put("mode", mode);
            cfg.put("db-path", "db/greatsales/");
            String comment = "Hibernate DB Connection Data";
            String cfgPath = FileUtil.getHome() + "cfg/";
            ConfigController.this.model.salvar(cfg, cfgPath, comment);
            ConfigController.this.view.dispose();
        }
    }
}
