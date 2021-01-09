package br.com.greatsoft.greaterp.view;

import br.com.greatsoft.greaterp.common.FileUtil;
import br.com.greatsoft.greaterp.controller.ConfigController;
import br.com.greatsoft.greaterp.model.ConfigModel;
import br.com.greatsoft.greaterp.model.entity.sales.SaleHeader;
import br.com.greatsoft.greaterp.model.entity.sales.SaleItem;
import br.com.greatsoft.greaterp.model.util.H2Server;
import br.com.greatsoft.greaterp.view.config.ConfigView;
import br.com.greatsoft.greaterp.view.customer.CustomerListView;
import br.com.greatsoft.greaterp.view.product.ProductListView;
import br.com.greatsoft.greaterp.view.sales.SalesAgentView;
import br.com.greatsoft.greaterp.view.sales.SalesListView;
import br.com.greatsoft.greaterp.view.sales.SalesmanView;
import br.com.greatsoft.greaterp.view.sales.relatorio.RelatorioVendasMaster;
import br.com.greatsoft.greaterp.view.util.ProgressBarView;
import br.com.greatsoft.greaterp.view.vendor.VendorListView;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainView extends JFrame {
    private JMenu VendaJMI;
    private JMenu cadastroJM;
    private JMenuItem cleanSaleItems;
    private JMenuItem clienteJMI;
    private JMenuItem configJMI;
    private JMenuItem consultarVendaJMI;
    private JMenuItem fornecedorJMI;
    private JMenuItem iniciarVendaJMI;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem produtoJMI;
    private JMenuItem putSaleHeaders;
    private JMenuItem relatorio;
    private JMenuItem representanteJMI;
    private JMenuItem sobreJMI;

    public MainView() {
        MainView.Progress progress = new MainView.Progress();
        progress.start();
        this.initComponents();

        try {
            FileUtil.exportH2Service();
            FileUtil.exportH2Lib();
            FileUtil.exportH2Server();
            FileUtil.exportReadme();
            progress.parar();
        } catch (Exception var9) {
            FileUtil.log(var9);
        }

        try {
            String cfgPath = FileUtil.getHome() + "cfg/config.xml";
            File cfgFile = new File(cfgPath);
            if (cfgFile.exists()) {
                Properties prop = (new ConfigModel()).carregar(cfgPath);
                String port = prop.getProperty("port");
                String mode = prop.getProperty("mode");
                if (mode.equals("client")) {
                    H2Server.start(port);
                }
            }

            if (!cfgFile.exists()) {
                int option = JOptionPane.showConfirmDialog((Component)null, "Atenção\nArquivo config.xml não encontrado!\nDeseja configurá-lo agora?!");
                if (option == 0) {
                    ConfigView cfgView = new ConfigView(this, true);
                    ConfigModel cfgModel = new ConfigModel();
                    new ConfigController(cfgView, cfgModel);
                    cfgView.setVisible(true);
                } else {
                    System.exit(0);
                }
            }
        } catch (HeadlessException var8) {
            FileUtil.log(var8);
        }

        progress.parar();
        this.setExtendedState(6);
    }

    private void initComponents() {
        this.jMenuBar1 = new JMenuBar();
        this.jMenu2 = new JMenu();
        this.configJMI = new JMenuItem();
        this.putSaleHeaders = new JMenuItem();
        this.cleanSaleItems = new JMenuItem();
        this.cadastroJM = new JMenu();
        this.clienteJMI = new JMenuItem();
        this.fornecedorJMI = new JMenuItem();
        this.produtoJMI = new JMenuItem();
        this.representanteJMI = new JMenuItem();
        this.VendaJMI = new JMenu();
        this.iniciarVendaJMI = new JMenuItem();
        this.consultarVendaJMI = new JMenuItem();
        this.relatorio = new JMenuItem();
        this.jMenu1 = new JMenu();
        this.sobreJMI = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.setTitle("GreatSales 1.0");
        this.jMenu2.setText("Sistema");
        this.configJMI.setText("Configurações");
        this.configJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.configJMIActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.configJMI);
        this.putSaleHeaders.setText("Put SaleHeaders in SaleItems");
        this.putSaleHeaders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.putSaleHeadersActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.putSaleHeaders);
        this.cleanSaleItems.setText("Clean Orphans SaleItems");
        this.cleanSaleItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.cleanSaleItemsActionPerformed(evt);
            }
        });
        this.jMenu2.add(this.cleanSaleItems);
        this.jMenuBar1.add(this.jMenu2);
        this.cadastroJM.setText("Cadastro");
        this.clienteJMI.setText("Cliente");
        this.clienteJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.clienteJMIActionPerformed(evt);
            }
        });
        this.cadastroJM.add(this.clienteJMI);
        this.fornecedorJMI.setText("Fornecedor");
        this.fornecedorJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.fornecedorJMIActionPerformed(evt);
            }
        });
        this.cadastroJM.add(this.fornecedorJMI);
        this.produtoJMI.setText("Produto");
        this.produtoJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.produtoJMIActionPerformed(evt);
            }
        });
        this.cadastroJM.add(this.produtoJMI);
        this.representanteJMI.setText("Representante");
        this.representanteJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.representanteJMIActionPerformed(evt);
            }
        });
        this.cadastroJM.add(this.representanteJMI);
        this.jMenuBar1.add(this.cadastroJM);
        this.VendaJMI.setText("Venda");
        this.iniciarVendaJMI.setText("Iniciar Venda");
        this.iniciarVendaJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.iniciarVendaJMIActionPerformed(evt);
            }
        });
        this.VendaJMI.add(this.iniciarVendaJMI);
        this.consultarVendaJMI.setText("Consultar Venda");
        this.consultarVendaJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.consultarVendaJMIActionPerformed(evt);
            }
        });
        this.VendaJMI.add(this.consultarVendaJMI);
        this.relatorio.setText("Relatório");
        this.relatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.relatorioActionPerformed(evt);
            }
        });
        this.VendaJMI.add(this.relatorio);
        this.jMenuBar1.add(this.VendaJMI);
        this.jMenu1.setText("Ajuda");
        this.sobreJMI.setText("Sobre...");
        this.sobreJMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainView.this.sobreJMIActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.sobreJMI);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 864, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGap(0, 387, 32767));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void clienteJMIActionPerformed(ActionEvent evt) {
        CustomerListView listDlg = new CustomerListView(new JFrame(), false);
        listDlg.setVisible(true);
    }

    private void fornecedorJMIActionPerformed(ActionEvent evt) {
        VendorListView listDlg = new VendorListView(new JFrame(), false);
        listDlg.setVisible(true);
    }

    private void produtoJMIActionPerformed(ActionEvent evt) {
        ProductListView listDlg = new ProductListView(new JFrame(), false);
        listDlg.setVisible(true);
    }

    private void iniciarVendaJMIActionPerformed(ActionEvent evt) {
        SalesAgentView sale = new SalesAgentView(new JFrame(), false, (SaleHeader)null);
        sale.setVisible(true);
    }

    private void consultarVendaJMIActionPerformed(ActionEvent evt) {
        SalesListView listDlg = new SalesListView(new JFrame(), false);
        listDlg.setVisible(true);
    }

    private void sobreJMIActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this.rootPane, "GreatSales\nSoftware Produzido por\nGreatSoft\nwww.greatsoft.com.br\nNo momento damos suporte somente ao Gmail.\nSugestões, elogios ou reclamações para: \nJosé Esteves\nestevesdeveloper@gmail.com\n(44) 8425-1993");
    }

    private void representanteJMIActionPerformed(ActionEvent evt) {
        SalesmanView salesmanDlg = new SalesmanView(new JFrame(), true);
        salesmanDlg.setVisible(true);
    }

    private void configJMIActionPerformed(ActionEvent evt) {
        int option = JOptionPane.showConfirmDialog(this, "Atenção\nNão altere nada nesta tela!\nA não ser que você saiba o que está fazendo!\nSeu sistema pode parar de funcionar!\nDeseja continuar mesmo assim?");
        if (option == 0) {
            ConfigView cfgView = new ConfigView(this, true);
            ConfigModel cfgModel = new ConfigModel();
            new ConfigController(cfgView, cfgModel);
            cfgView.setVisible(true);
        }

    }

    private void relatorioActionPerformed(ActionEvent evt) {
        RelatorioVendasMaster rel = new RelatorioVendasMaster();
        rel.setVisible(true);
    }

    private void putSaleHeadersActionPerformed(ActionEvent evt) {
        String password = JOptionPane.showInputDialog("Senha:");
        System.out.println(password);
        if (password != null) {
            if (password.equals("Wort12")) {
                //FIXME: Review this code
                List<SaleHeader> headers = null;
                        //(new SaleRn()).listar();
                Iterator var4 = headers.iterator();

                while(var4.hasNext()) {
                    SaleHeader s = (SaleHeader)var4.next();
                    Iterator var6 = s.getItems().iterator();

                    while(var6.hasNext()) {
                        SaleItem i = (SaleItem)var6.next();

                        try {
                            i.setSaleHeader(s);
                            System.out.println("Novo Cabecalho: " + i.getSaleHeader());
                            //FIXME: Review this code
                            //(new SaleItemRn()).salvar(i);
                        } catch (Exception var9) {
                            System.out.println(i.getId() + "Nao contem SaleHeader");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this.rootPane, "Somente O Administrador do Sistemapode utilizar esta funcionalidade!");
            }
        } else {
            System.out.println("Usuario clicou em cancelar...");
        }

    }

    private void cleanSaleItemsActionPerformed(ActionEvent evt) {
        String password = JOptionPane.showInputDialog("Senha:");
        System.out.println(password);
        if (password != null) {
            if (password.equals("Wort12")) {
                //FIXME: Review this code
                List<SaleItem> itens = null;
                        //(new SaleItemRn()).listar();
                Iterator var4 = itens.iterator();

                while(var4.hasNext()) {
                    SaleItem i = (SaleItem)var4.next();
                    System.out.println("Header: " + i.getSaleHeader() + " Id Item: " + i.getId() + " Data Entrega: " + i.getDataEntrega());
                    if (i.getSaleHeader() == null) {
                        //FIXME: Review this code
                        //(new SaleItemRn()).excluir(i);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this.rootPane, "Somente O Administrador do Sistemapode utilizar esta funcionalidade!");
            }
        } else {
            System.out.println("Usuario clicou em cancelar...");
        }

    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var6) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, (String)null, var6);
        }

        String port = "9801";

        try {
            Properties prop = (new ConfigModel()).carregar(FileUtil.getHome() + "cfg/config.xml");
            port = prop.getProperty("port");
        } catch (Exception var5) {
            FileUtil.log(var5);
        }

        if (args.length == 1) {
            String argument = args[0];
            if (argument.equals("-s")) {
                H2Server.start(port);
            }
        } else {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    (new MainView()).setVisible(true);
                }
            });
        }

    }

    class Progress extends Thread {
        private ProgressBarView progressBar;

        Progress() {
        }

        public void run() {
            this.progressBar = new ProgressBarView((Frame)null, true, "Inicializando...");
            this.progressBar.setVisible(true);
        }

        public void parar() {
            this.progressBar.close();
        }
    }
}
