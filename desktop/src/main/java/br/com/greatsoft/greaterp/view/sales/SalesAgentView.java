package br.com.greatsoft.greaterp.view.sales;

import br.com.greatsoft.greaterp.common.DateUtil;
import br.com.greatsoft.greaterp.common.FileUtil;
import br.com.greatsoft.greaterp.common.FinnancialMath;
import br.com.greatsoft.greaterp.common.MailSender;
import br.com.greatsoft.greaterp.common.TextUtil;
import br.com.greatsoft.greaterp.common.wait.MailWait;
import br.com.greatsoft.greaterp.controller.bean.SaleBean;
import br.com.greatsoft.greaterp.view.document.PdfCreator;
import br.com.greatsoft.greaterp.view.document.Translator;
import com.lowagie.text.DocumentException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import us.greatapps4you.greatsales.entities.inventory.Product;
import us.greatapps4you.greatsales.entities.sale.Customer;
import us.greatapps4you.greatsales.entities.sale.Sale;
import us.greatapps4you.greatsales.entities.sale.SaleItem;
import us.greatapps4you.greatsales.entities.sale.Salesman;

public class SalesAgentView extends JDialog {
    private SaleItemsTM itemsTM;
    private SaleBean saleBean;
    private Sale saleHeader;
    private List<SaleItem> items;
    private final DefaultComboBoxModel customersComboModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel productsComboModel;
    private double totalPedido = 0.0D;
    private boolean editando = false;
    private boolean manterData = false;
    private String numeroPedido;
    private SalesAgentView.Progress prog;
    private boolean modificado = false;
    private JButton addItemJB;
    private JButton alterarPedido;
    private JTextField comissaoDinheiroJTF;
    private JTextField comissaoPercentJTF;
    private JFormattedTextField compradorJTF;
    private JComboBox customersCombo;
    private JFormattedTextField dataEntregaJTF;
    private JFormattedTextField emailDanfeJTF;
    private JFormattedTextField emailPedidoJTF;
    private JFormattedTextField endCobrancaJTF;
    private JTextField endEntregaJTF;
    private JButton enviarJB;
    private JTextField freteJTF;
    private JTextField icmsJTF;
    private JTable itemsJT;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JButton limparItens;
    private JFormattedTextField mensagemJTF;
    private JTextField numPedidoJTF;
    private JFormattedTextField observacoesJTF;
    private JTextField pedidoCliJTF;
    private JTextField prazoJTF;
    private JComboBox productsCombo;
    private JTextField quantityJTF;
    private JButton sair;
    private JButton salvarJB;
    private JTextField totalJTF;
    private JTextField transportadoraJTF;
    private JTextField unValueJTF;

    public SalesAgentView(Frame parent, boolean modal, Sale saleHeader) {
        super(parent, modal);
        this.initCustomersCombo();
        this.productsComboModel = new DefaultComboBoxModel();
        this.initProductsCombo();
        this.inicializarModelo();
        this.initComponents();
        this.formatDataEntrega();
        this.saleBean = new SaleBean();
        if (saleHeader != null) {
            this.editando = true;
            //this.saleHeader = saleHeader;
            this.initFields();
            //this.numeroPedido = saleHeader.getNumeroPedido();
            this.numPedidoJTF.setText(this.numeroPedido);
            //this.saleHeader.setId(Long.parseLong(this.numeroPedido));
            this.checarBotoes(saleHeader);
            this.alterarPedido.setEnabled(this.editando);
        } else {
            this.editando = false;
            this.saleHeader = new Sale();
            this.numeroPedido = this.gerarNumeroPedido();
            this.numPedidoJTF.setText(this.numeroPedido);
            //this.saleHeader.setId(Long.parseLong(this.numeroPedido));
            this.items = new ArrayList();
            this.alterarPedido.setEnabled(this.editando);
        }

        this.addDuploClickTabela();
    }

    private void checarBotoes(Sale saleHeader) {
        //this.salvarJB.setEnabled(saleHeader.isEditavel());
        this.alterarPedido.setEnabled(this.editando);
    }

    private void addKeyListener() {
        this.emailPedidoJTF.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });
    }

    private void salvarEnviados() {
        List<String> enviados = TextUtil.csvToList(this.emailPedidoJTF.getText());
        if (!enviados.isEmpty()) {
            Iterator var2 = enviados.iterator();

            while(var2.hasNext()) {
                String email = (String)var2.next();
               /* Enviado enviado = new Enviado();
                enviado.setEmail(email);*/

                try {
                    /*Enviado tmp = (Enviado)(new EnviadoRn()).carregar("email", email);
                    if (tmp.getEmail().length() <= 0) {
                        (new EnviadoRn()).salvar(enviado);
                    }*/
                } catch (Exception var6) {
                    /*(new EnviadoRn()).salvar(enviado);*/
                }
            }
        }

    }

    private String autoCompletarEnviados(String query) {
        String full = this.emailPedidoJTF.getText();
        String resultado = "";

        //FIXME: fetching here
        /*List<Enviado> enviados = new ArrayList<>();
        if (!query.contains(";") || !query.contains("@")) {
            Iterator var5 = enviados.iterator();

            while(var5.hasNext()) {
                Enviado env = (Enviado)var5.next();
                if (env.getEmail().startsWith(query)) {
                    resultado = env.toString();
                    resultado = resultado.replaceFirst(query, "");
                    this.emailPedidoJTF.setText(full + resultado + ";");
                }
            }
        }*/

        return resultado;
    }

    private void formatDataEntrega() {
        try {
            MaskFormatter dataEnt = new MaskFormatter("##/##/####");
            dataEnt.install(this.dataEntregaJTF);
        } catch (ParseException var3) {
            FileUtil.log(var3);
        }

    }

    private void salvarPedido() {
        if (!this.areEmptyFields()) {
            if (!this.salvar()) {
                JOptionPane.showMessageDialog((Component)null, "Erro ao tentar salvar o pedido");
            } else {
                JOptionPane.showMessageDialog(this.rootPane, "Pedido Salvo com Sucesso!");
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "Todos os campos são obrigatórios");
        }

    }

    private void enviarPedido() {
        this.prog = new SalesAgentView.Progress();
        this.prog.start();
        if (!this.enviarEmail()) {
            this.prog.parar();
            JOptionPane.showMessageDialog((Component)null, "Erro ao tentar enviar email");
        } else {
            this.prog.parar();
            JOptionPane.showMessageDialog((Component)null, "Pedido enviado com sucesso!");
            this.resetMembers();
            this.dispose();
        }

    }

    private void resetMembers() {
        this.saleHeader = new Sale();
        this.saleBean = new SaleBean();
        this.editando = false;
        this.items = new ArrayList();
        this.numeroPedido = "";
        this.totalPedido = 0.0D;
    }

    private boolean salvar() {
        try {
            this.initBean();
            //this.saleBean.setSaleHeader(this.saleHeader);
            this.saleBean.salvar();

            try {
                this.salvarEnviados();
            } catch (Exception var2) {
                var2.printStackTrace();
            }

            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    private String gerarNumeroPedido() {
        Date data = new Date();
        Locale locale = Locale.getDefault();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM", locale);
        //FIXME: Compare code
        String numPedido = sdf.format(data);
        return numPedido;
    }

    private boolean enviarEmail() {
        try {
            Salesman salesman = null;

            try {
                salesman = null;
            } catch (Exception var16) {
                var16.printStackTrace();
            }

            if (salesman == null) {
                JOptionPane.showMessageDialog(this.rootPane, "Cadastre o email e a senha do representante");
                return false;
            } else {
                //String sender = salesman.getEmail();
                String password = salesman.getPassword();
                //String subject = "Pedido Para " + this.saleHeader.getCustomer().getIdentification().getRazaoSocial();
                String messageText = this.mensagemJTF.getText();
                PdfCreator creator = new PdfCreator();
                Translator translator = new Translator();
                String pedidoPdf = "";

                try {
                    pedidoPdf = creator.createFromHtml(translator.translateSaleHeader(this.saleHeader), "pedido");
                } catch (IllegalAccessException | ParserConfigurationException | SAXException | DocumentException | IOException | IllegalArgumentException var15) {
                    FileUtil.log(var15);
                    var15.printStackTrace();
                }

                List<String> recipients = TextUtil.csvToList(this.emailPedidoJTF.getText());
                if (recipients.isEmpty()) {
                    String recipient = this.emailPedidoJTF.getText();

                    try {
                        /*MailSender.send(sender, password, recipient, subject, messageText, pedidoPdf);
                        this.saleHeader.setEditavel(false);
                        this.saleBean.setSaleHeader(this.saleHeader);
                */        this.saleBean.salvar();
                        return true;
                    } catch (Exception var13) {
                        JOptionPane.showMessageDialog(this.rootPane, "Falha ao tentar enviar email para: " + recipient);
                        return true;
                    }
                } else {
                    Iterator var10 = recipients.iterator();

                    while(var10.hasNext()) {
                        String r = (String)var10.next();

                        try {
                           // MailSender.send(sender, password, r, subject, messageText, pedidoPdf);
                        } catch (Exception var14) {
                            var14.printStackTrace();
                            JOptionPane.showMessageDialog(this.rootPane, "Falha ao tentar enviar email para: " + r);
                        }
                    }

                   /* this.saleHeader.setEditavel(false);
                    this.saleBean.setSaleHeader(this.saleHeader);
                */    this.saleBean.salvar();
                    return true;
                }
            }
        } catch (HeadlessException var17) {
            var17.printStackTrace();
            return false;
        }
    }

    private void initFields() {
        this.customersComboModel.setSelectedItem(this.saleHeader.getCustomer());

        try {
            this.items = this.saleHeader.getItems();
            this.atualizarTabela();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        /*this.endEntregaJTF.setText(this.saleHeader.getEndEntrega());
        this.endCobrancaJTF.setText(this.saleHeader.getEndFatura());
        this.totalPedido = this.saleHeader.getTotal();
        this.totalJTF.setText(Double.toString(this.totalPedido));
        this.freteJTF.setText(this.saleHeader.getFrete());
        this.transportadoraJTF.setText(this.saleHeader.getTransportadora());
        this.icmsJTF.setText(this.saleHeader.getIcms());
        this.prazoJTF.setText(this.saleHeader.getPrazoPgto());
        this.pedidoCliJTF.setText(this.saleHeader.getPedidoCliente());
        this.mensagemJTF.setText(this.saleHeader.getMessage());
        this.observacoesJTF.setText(this.saleHeader.getObservacoes());
        this.compradorJTF.setText(this.saleHeader.getComprador());
        this.emailPedidoJTF.setText(this.saleHeader.getEmailPedido());
        this.emailDanfeJTF.setText(this.saleHeader.getEmailDanfe());
        this.comissaoPercentJTF.setText(Double.toString(this.saleHeader.getComissaoPercent()));
        this.comissaoDinheiroJTF.setText(Double.toString(this.saleHeader.getComissaoDinheiro()));
*/    }

    private void initBean() {
        try {
            Iterator var1 = this.items.iterator();

            while(var1.hasNext()) {
                SaleItem it = (SaleItem)var1.next();
                //it.setSaleHeader(this.saleHeader);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        this.saleHeader.setItems(this.items);
       /* this.saleHeader.setEditavel(false);
        this.saleHeader.setNumeroPedido(this.numeroPedido);
        this.saleHeader.setCustomer((Customer)this.customersComboModel.getSelectedItem());
        if (!this.manterData) {
            this.saleHeader.setDataPedido(new Date());
        }

        this.saleHeader.setTotal(Double.parseDouble(this.totalJTF.getText()));
        this.saleHeader.setComissaoDinheiro(Double.parseDouble(this.comissaoDinheiroJTF.getText()));
        this.saleHeader.setComissaoPercent(Double.parseDouble(this.comissaoPercentJTF.getText()));
        this.saleHeader.setDataEntrega(this.dataEntregaJTF.getText());
        this.saleHeader.setEndFatura(this.endCobrancaJTF.getText());
        this.saleHeader.setEmailDanfe(this.emailDanfeJTF.getText());
        this.saleHeader.setEmailPedido(this.emailPedidoJTF.getText());
        this.saleHeader.setMessage(this.mensagemJTF.getText());
        this.saleHeader.setObservacoes(this.observacoesJTF.getText());
        this.saleHeader.setComprador(this.compradorJTF.getText());
        this.saleHeader.setEndEntrega(this.endEntregaJTF.getText());
        this.saleHeader.setIcms(this.icmsJTF.getText());
        this.saleHeader.setPrazoPgto(this.prazoJTF.getText());
        this.saleHeader.setPedidoCliente(this.pedidoCliJTF.getText());
        this.saleHeader.setFrete(this.freteJTF.getText());
        this.saleHeader.setTransportadora(this.transportadoraJTF.getText());
*/
        try {
            //this.saleHeader.setRepresentante((Salesman)(new SalesmanRn()).carregar("id", 1L));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        this.checarBotoes(this.saleHeader);
    }

    private void addItem() {
        if (!this.unValueJTF.getText().isEmpty() && !this.quantityJTF.getText().isEmpty() && !this.dataEntregaJTF.getText().replaceAll("/", "").trim().isEmpty() && this.dataEntregaJTF.getText().replaceAll("/", "").trim().length() == 8) {
            try {
                SaleItem item = new SaleItem();
                double unPrice = Double.parseDouble(this.unValueJTF.getText().replaceAll(",", "."));
                double quantity = Double.parseDouble(this.quantityJTF.getText().replaceAll(",", "."));
              /*  item.setProduct((Product)this.productsComboModel.getSelectedItem());
                item.setQuantity(quantity);
                item.setUnPrice(unPrice);
                double totalPrice = FinnancialMath.roundDecimal(unPrice * quantity, 2);
                item.setTotalPrice(totalPrice);
                item.setDataEntrega(DateUtil.toDateDDmmYYYY(this.dataEntregaJTF.getText()));
 */               //this.totalPedido += totalPrice;
                this.totalJTF.setText(Double.toString(FinnancialMath.roundDecimal(this.totalPedido, 2)));
                this.items.add(item);
                this.atualizarTabela();
            } catch (NumberFormatException var8) {
                var8.printStackTrace();
                JOptionPane.showMessageDialog(this.rootPane, "Informe corretamente valor, quantidade e data de entrega.");
            }
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "Informe corretamente valor, quantidade e data de entrega.");
        }

    }

    private boolean areEmptyFields() {
        return this.endCobrancaJTF.getText().isEmpty() || this.endEntregaJTF.getText().isEmpty() || this.freteJTF.getText().isEmpty() || this.emailPedidoJTF.getText().isEmpty() || this.mensagemJTF.getText().isEmpty() || this.prazoJTF.getText().isEmpty();
    }

    private void limparItens() {
        this.items = new ArrayList();
        this.totalPedido = 0.0D;
        this.totalJTF.setText(Double.toString(FinnancialMath.roundDecimal(this.totalPedido, 2)));
        this.atualizarTabela();
    }

    private void initCustomersCombo() {
        try {
            this.customersComboModel.removeAllElements();
            //FIXME: Review this code
            List<Customer> customers = null;
            Iterator var2 = customers.iterator();

            while(var2.hasNext()) {
                Customer c = (Customer)var2.next();
                this.customersComboModel.addElement(c);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    private void initProductsCombo() {
        try {
            this.productsComboModel.removeAllElements();
            //FIXME: Review this code
            List<Product> products = null;
            Iterator var2 = products.iterator();

            while(var2.hasNext()) {
                Product p = (Product)var2.next();
                this.productsComboModel.addElement(p);
            }
        } catch (Exception var4) {
            System.out.println("Erro em SalesAgentView.initProductsCombo()");
            var4.printStackTrace();
        }

    }

    private void atualizarTabela() {
        this.inicializarModelo();
        this.itemsTM.fireTableDataChanged();
        this.itemsJT.setModel(this.itemsTM);
    }

    private void addDuploClickTabela() {
        this.itemsJT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JOptionPane.showMessageDialog(SalesAgentView.this.rootPane, "Para limpar os itens clique em limpar");
                }

            }
        });
    }

    private void inicializarModelo() {
        if (this.items != null) {
            this.itemsTM = new SaleItemsTM(this.items);
        } else {
            this.itemsTM = new SaleItemsTM(new ArrayList());
        }

    }

    private void initComponents() {
        this.jLabel6 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.itemsJT = new JTable();
        this.jLabel1 = new JLabel();
        this.customersCombo = new JComboBox();
        this.productsCombo = new JComboBox();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.quantityJTF = new JTextField();
        this.salvarJB = new JButton();
        this.unValueJTF = new JTextField();
        this.jLabel4 = new JLabel();
        this.comissaoPercentJTF = new JTextField();
        this.jLabel7 = new JLabel();
        this.totalJTF = new JTextField();
        this.jLabel5 = new JLabel();
        this.endEntregaJTF = new JTextField();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.comissaoDinheiroJTF = new JTextField();
        this.icmsJTF = new JTextField();
        this.jLabel10 = new JLabel();
        this.dataEntregaJTF = new JFormattedTextField();
        this.prazoJTF = new JTextField();
        this.jLabel12 = new JLabel();
        this.numPedidoJTF = new JTextField();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.emailPedidoJTF = new JFormattedTextField();
        this.emailDanfeJTF = new JFormattedTextField();
        this.jLabel15 = new JLabel();
        this.addItemJB = new JButton();
        this.jLabel16 = new JLabel();
        this.mensagemJTF = new JFormattedTextField();
        this.jLabel17 = new JLabel();
        this.observacoesJTF = new JFormattedTextField();
        this.jLabel18 = new JLabel();
        this.freteJTF = new JTextField();
        this.endCobrancaJTF = new JFormattedTextField();
        this.jLabel20 = new JLabel();
        this.jLabel19 = new JLabel();
        this.compradorJTF = new JFormattedTextField();
        this.pedidoCliJTF = new JTextField();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.transportadoraJTF = new JTextField();
        this.jLabel23 = new JLabel();
        this.enviarJB = new JButton();
        this.alterarPedido = new JButton();
        this.limparItens = new JButton();
        this.sair = new JButton();
        this.jLabel6.setText("Comissão %");
        this.setDefaultCloseOperation(0);
        this.setTitle("Enviar Pedido");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                SalesAgentView.this.formWindowClosing(evt);
            }

            public void windowClosed(WindowEvent evt) {
                SalesAgentView.this.formWindowClosed(evt);
            }
        });
        this.itemsJT.setModel(this.itemsTM);
        this.jScrollPane1.setViewportView(this.itemsJT);
        this.jLabel1.setText("Cliente");
        this.customersCombo.setModel(this.customersComboModel);
        this.customersCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                SalesAgentView.this.customersComboItemStateChanged(evt);
            }
        });
        this.customersCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.customersComboActionPerformed(evt);
            }
        });
        this.customersCombo.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                SalesAgentView.this.customersComboPropertyChange(evt);
            }
        });
        this.productsCombo.setModel(this.productsComboModel);
        this.jLabel2.setText("Produto");
        this.jLabel3.setText("Qtde. ");
        this.quantityJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.quantityJTFKeyReleased(evt);
            }
        });
        this.salvarJB.setText("Salvar");
        this.salvarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.salvarJBActionPerformed(evt);
            }
        });
        this.unValueJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.unValueJTFKeyReleased(evt);
            }
        });
        this.jLabel4.setText("Vlr. Un.");
        this.comissaoPercentJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.comissaoPercentJTFKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                SalesAgentView.this.comissaoPercentJTFKeyTyped(evt);
            }
        });
        this.jLabel7.setText("Frete");
        this.totalJTF.setEditable(false);
        this.totalJTF.setText("0.00");
        this.jLabel5.setText("Total");
        this.jLabel8.setText("End. Entrega");
        this.jLabel9.setText("Comissão R$");
        this.comissaoDinheiroJTF.setEditable(false);
        this.comissaoDinheiroJTF.setText("0.00");
        this.icmsJTF.setText("12");
        this.icmsJTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.icmsJTFActionPerformed(evt);
            }
        });
        this.jLabel10.setText("ICMS %");
        this.dataEntregaJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.dataEntregaJTFKeyReleased(evt);
            }
        });
        this.jLabel12.setText("Prazo");
        this.numPedidoJTF.setEditable(false);
        this.jLabel13.setText("Pedido N.");
        this.jLabel14.setText("Email Pedido");
        this.emailPedidoJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.emailPedidoJTFKeyReleased(evt);
            }
        });
        this.jLabel15.setText("Email DANFE");
        this.addItemJB.setBackground(new Color(173, 236, 161));
        this.addItemJB.setText("Adicionar");
        this.addItemJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.addItemJBActionPerformed(evt);
            }
        });
        this.jLabel16.setText("Comissão %");
        this.jLabel17.setText("Mensagem");
        this.observacoesJTF.setText("Fazer constar na nota fiscal numero numero do pedido do cliente.");
        this.jLabel18.setText("Observações");
        this.endCobrancaJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.endCobrancaJTFKeyReleased(evt);
            }
        });
        this.jLabel20.setText("End. Cobrança");
        this.jLabel19.setText("Comprador");
        this.jLabel21.setText("Pedido Cliente");
        this.jLabel22.setText("Transportadora");
        this.transportadoraJTF.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                SalesAgentView.this.transportadoraJTFKeyReleased(evt);
            }
        });
        this.jLabel23.setText("Entrega");
        this.enviarJB.setBackground(new Color(154, 219, 144));
        this.enviarJB.setFont(new Font("Ubuntu", 1, 15));
        this.enviarJB.setText("Enviar");
        this.enviarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.enviarJBActionPerformed(evt);
            }
        });
        this.alterarPedido.setForeground(new Color(255, 51, 51));
        this.alterarPedido.setText("Alterar");
        this.alterarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.alterarPedidoActionPerformed(evt);
            }
        });
        this.limparItens.setBackground(new Color(253, 174, 179));
        this.limparItens.setText("Limpar");
        this.limparItens.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.limparItensActionPerformed(evt);
            }
        });
        this.sair.setBackground(new Color(255, 0, 29));
        this.sair.setFont(new Font("Ubuntu", 1, 17));
        this.sair.setForeground(new Color(254, 254, 254));
        this.sair.setText("X");
        this.sair.setToolTipText("Fechar a Janela");
        this.sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesAgentView.this.sairActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane1, Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel22).addComponent(this.jLabel21).addComponent(this.jLabel18).addComponent(this.jLabel14).addComponent(this.jLabel20).addComponent(this.jLabel17).addComponent(this.jLabel8).addComponent(this.jLabel7).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.alterarPedido).addComponent(this.jLabel19))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel16).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.comissaoPercentJTF, -2, 55, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel9).addGap(2, 2, 2).addComponent(this.comissaoDinheiroJTF, -2, 132, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.salvarJB).addGap(18, 18, 18).addComponent(this.enviarJB)).addComponent(this.compradorJTF).addComponent(this.observacoesJTF).addGroup(layout.createSequentialGroup().addComponent(this.emailPedidoJTF, -2, 303, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel15).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.emailDanfeJTF)).addComponent(this.mensagemJTF).addComponent(this.endEntregaJTF).addComponent(this.endCobrancaJTF).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.pedidoCliJTF, -2, 130, -2).addPreferredGap(ComponentPlacement.RELATED, 102, 32767).addComponent(this.jLabel12).addGap(3, 3, 3).addComponent(this.prazoJTF, -2, 130, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel10).addGap(2, 2, 2).addComponent(this.icmsJTF, -2, 81, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel5).addGap(4, 4, 4).addComponent(this.totalJTF, -2, 214, -2)).addComponent(this.transportadoraJTF).addComponent(this.freteJTF, Alignment.TRAILING))).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.customersCombo, -2, 551, -2).addGroup(layout.createSequentialGroup().addComponent(this.productsCombo, -2, 251, -2).addGap(1, 1, 1).addComponent(this.jLabel3).addGap(2, 2, 2).addComponent(this.quantityJTF, -2, 96, -2).addGap(1, 1, 1).addComponent(this.jLabel4).addGap(2, 2, 2).addComponent(this.unValueJTF, -2, 95, -2).addGap(4, 4, 4).addComponent(this.jLabel23))).addGap(251, 251, 251)).addGroup(layout.createSequentialGroup().addGap(117, 117, 117).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(556, 556, 556).addComponent(this.dataEntregaJTF, -2, 89, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.addItemJB).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.limparItens)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.numPedidoJTF, -2, 104, -2)))))).addGroup(layout.createSequentialGroup().addComponent(this.sair, -2, 41, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.sair).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.customersCombo, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.numPedidoJTF, -2, -1, -2)).addGap(8, 8, 8).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.productsCombo, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.quantityJTF, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.unValueJTF, -2, -1, -2).addComponent(this.addItemJB).addComponent(this.jLabel23).addComponent(this.dataEntregaJTF, -2, -1, -2).addComponent(this.limparItens)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 163, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.totalJTF, -2, -1, -2).addComponent(this.jLabel12).addComponent(this.jLabel10).addComponent(this.icmsJTF, -2, -1, -2).addComponent(this.prazoJTF, -2, -1, -2).addComponent(this.jLabel21).addComponent(this.pedidoCliJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel20).addComponent(this.endCobrancaJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.freteJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.transportadoraJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.endEntregaJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.emailPedidoJTF, -2, -1, -2).addComponent(this.jLabel15).addComponent(this.emailDanfeJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.mensagemJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.observacoesJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.compradorJTF, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.salvarJB).addComponent(this.comissaoDinheiroJTF, -2, -1, -2).addComponent(this.comissaoPercentJTF, -2, -1, -2).addComponent(this.jLabel9).addComponent(this.jLabel16).addComponent(this.enviarJB).addComponent(this.alterarPedido)).addContainerGap()));
        layout.linkSize(1, new Component[]{this.customersCombo, this.productsCombo, this.quantityJTF});
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void addItemJBActionPerformed(ActionEvent evt) {
        this.addItem();
    }

    private void salvarJBActionPerformed(ActionEvent evt) {
        this.salvarPedido();
        this.modificado = false;
    }

    private void comissaoPercentJTFKeyReleased(KeyEvent evt) {
        String valorInformado = this.comissaoPercentJTF.getText();
        if (valorInformado.length() > 0) {
            if (FinnancialMath.isNumber(valorInformado)) {
                try {
                    double comissaoPercent = Double.parseDouble(valorInformado) / 100.0D;
                    double comissaoDinheiro = comissaoPercent * this.totalPedido;
                    this.comissaoDinheiroJTF.setText(Double.toString(FinnancialMath.roundDecimal(comissaoDinheiro, 2)));
                } catch (NumberFormatException var7) {
                    var7.printStackTrace();
                    JOptionPane.showMessageDialog((Component)null, "Valor informado incorreto! \nUtilize apenas números e ponto para casas decimais.\nExemplo: 3.25");
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "Valor informado incorreto! \nUtilize apenas números e ponto para casas decimais.\nExemplo: 3.25");
            }
        } else {
            this.comissaoDinheiroJTF.setText("");
        }

    }

    private void comissaoPercentJTFKeyTyped(KeyEvent evt) {
    }

    private void customersComboItemStateChanged(ItemEvent evt) {
    }

    private void customersComboPropertyChange(PropertyChangeEvent evt) {
    }

    private void customersComboActionPerformed(ActionEvent evt) {
        try {
            Customer comboCustomer = (Customer)this.customersComboModel.getSelectedItem();
            this.saleHeader.setCustomer(comboCustomer);
            //this.endCobrancaJTF.setText(this.saleHeader.getCustomer().getEndCobranca());
            this.emailDanfeJTF.setText(comboCustomer.getAddress().getEmail());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private void emailPedidoJTFKeyReleased(KeyEvent evt) {
        String full = this.emailPedidoJTF.getText();
        if (full.length() >= 4) {
            String query = full.substring(full.length() - 4);
            this.autoCompletarEnviados(query);
        }

        this.modificado = true;
    }

    private void enviarJBActionPerformed(ActionEvent evt) {
        this.prog = new SalesAgentView.Progress();
        this.prog.start();
        SalesAgentView.EnvioPedidoThread envio = new SalesAgentView.EnvioPedidoThread();
        envio.start();
    }

    private void alterarPedidoActionPerformed(ActionEvent evt) {
       //int option = JOptionPane.showConfirmDialog(this.rootPane, "Deseja manter a data original do pedido: " + DateUtil.toStringDDmmYYYY(this.saleHeader.getDataPedido()));
        /*if (option == 0) {
            this.manterData = true;
            this.salvarJB.setEnabled(true);
        } else if (option == 1) {
            this.manterData = false;
            this.salvarJB.setEnabled(true);
        }*/

    }

    private void limparItensActionPerformed(ActionEvent evt) {
        this.limparItens();
    }

    private void icmsJTFActionPerformed(ActionEvent evt) {
    }

    private void formWindowClosing(WindowEvent evt) {
    }

    private void quantityJTFKeyReleased(KeyEvent evt) {
        this.modificado = true;
    }

    private void unValueJTFKeyReleased(KeyEvent evt) {
        this.modificado = true;
    }

    private void dataEntregaJTFKeyReleased(KeyEvent evt) {
        this.modificado = true;
    }

    private void endCobrancaJTFKeyReleased(KeyEvent evt) {
        this.modificado = true;
    }

    private void transportadoraJTFKeyReleased(KeyEvent evt) {
        this.modificado = true;
    }

    private void formWindowClosed(WindowEvent evt) {
    }

    private void sairActionPerformed(ActionEvent evt) {
        if (this.modificado) {
            int option = JOptionPane.showConfirmDialog(this.rootPane, "Deseja Salvar antes de fechar?");
            if (option == 0) {
                this.salvarPedido();
            } else if (option == 1) {
                this.dispose();
            }
        } else {
            this.dispose();
        }

    }

    public static void main(String[] args) {
        //FIXME: Review this code
        List<Customer> customers = null;
        Iterator var2 = customers.iterator();

        while(var2.hasNext()) {
            Customer c = (Customer)var2.next();
            //System.out.println(c.getIdentification().getRazaoSocial());
        }

    }

    class EnvioPedidoThread extends Thread {
        EnvioPedidoThread() {
        }

        public void run() {
            if (!SalesAgentView.this.enviarEmail()) {
                SalesAgentView.this.prog.parar();
                JOptionPane.showMessageDialog((Component)null, "Erro ao tentar enviar email");
            } else {
                SalesAgentView.this.prog.parar();
                JOptionPane.showMessageDialog((Component)null, "Pedido enviado com sucesso!");
                SalesAgentView.this.resetMembers();
                SalesAgentView.this.dispose();
            }

        }
    }

    class Progress extends Thread {
        private JDialog wait;

        Progress() {
        }

        public void run() {
            this.wait = new MailWait((JDialog)null, true);
            this.wait.setVisible(true);
        }

        public void parar() {
            this.wait.dispose();
        }
    }
}
