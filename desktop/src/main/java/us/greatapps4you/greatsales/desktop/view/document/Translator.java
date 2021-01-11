/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.document;

import us.greatapps4you.greatsales.desktop.common.DateUtil;
import us.greatapps4you.greatsales.desktop.common.FileUtil;
import us.greatapps4you.greatsales.desktop.common.FinnancialMath;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import us.greatapps4you.greatsales.entities.registration.Address;
import us.greatapps4you.greatsales.entities.registration.Identification;
import us.greatapps4you.greatsales.entities.sale.Customer;
import us.greatapps4you.greatsales.entities.sale.Sale;
import us.greatapps4you.greatsales.entities.sale.SaleItem;

public class Translator {
    public Translator() {
        FileUtil.exportLogo();
    }

    public String translateSaleHeader(Sale saleHeader) throws IllegalArgumentException, IllegalAccessException {
        String html = this.getSaleHeaderHtml();
        Map dictionary = this.initDictionary(saleHeader);

        label113:
        for(Iterator it = dictionary.entrySet().iterator(); it.hasNext(); it.remove()) {
            Entry pairs = (Entry)it.next();
            String fieldName = "";
            Object fieldValue = "";

            try {
                fieldName = pairs.getKey().toString();
                fieldValue = pairs.getValue();
            } catch (Exception var27) {
            }

            if (!fieldName.equals("id")) {
                byte var9 = -1;
                switch(fieldName.hashCode()) {
                    case 100526016:
                        if (fieldName.equals("items")) {
                            var9 = 1;
                        }
                        break;
                    case 110549828:
                        if (fieldName.equals("total")) {
                            var9 = 3;
                        }
                        break;
                    case 606175198:
                        if (fieldName.equals("customer")) {
                            var9 = 0;
                        }
                        break;
                    case 1176832911:
                        if (fieldName.equals("dataPedido")) {
                            var9 = 2;
                        }
                }

                String addressField;
                switch(var9) {
                    case 0:
                        Customer c = (Customer)fieldValue;
                        html = html.replaceAll(fieldName, fieldValue.toString());
                        Identification i = c.getIdentification();
                        Address a = c.getAddress();
                        Map ideDic = this.initDictionary(i);

                        for(Iterator ideIt = ideDic.entrySet().iterator(); ideIt.hasNext(); ideIt.remove()) {
                            Entry idePairs = (Entry)ideIt.next();
                            String ideField = "";
                            String ideValue = "";

                            try {
                                ideField = idePairs.getKey().toString();
                                ideValue = idePairs.getValue().toString();
                            } catch (Exception var26) {
                            }

                            if (!ideField.equals("id")) {
                                html = html.replaceAll(ideField + "Cli", ideValue);
                                System.out.println(ideField + " = " + ideValue);
                            }
                        }

                        Map addressDic = this.initDictionary(a);
                        Iterator addressIt = addressDic.entrySet().iterator();

                        while(true) {
                            if (!addressIt.hasNext()) {
                                continue label113;
                            }

                            Entry addressPairs = (Entry)addressIt.next();
                            addressField = "";
                            String addressValue = "";

                            try {
                                addressField = addressPairs.getKey().toString();
                                addressValue = addressPairs.getValue().toString();
                            } catch (Exception var25) {
                            }

                            if (!addressField.equals("id")) {
                                html = html.replaceAll(addressField + "Cli", addressValue);
                                System.out.println(addressField + " = " + addressValue);
                            }

                            addressIt.remove();
                        }
                    case 1:
                        addressField = "";
                        int rows = 0;
                        int maxRows = 10;
                        String blancTableRow = "<tr style=\"height: 18px;\"><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
                        if (fieldValue != null) {
                            List saleItems = (List)fieldValue;

                            for(Iterator var33 = saleItems.iterator(); var33.hasNext(); ++rows) {
                                Object o = var33.next();
                                SaleItem sl = (SaleItem)o;
                                //FIXME: DELIVERY DATE FIELD MISSING
                                addressField = addressField + "<tr><td>" + sl.getInventory().getProduct().getDescription() + "</td>" + "<td>" + FinnancialMath.formatarMoeda(sl.getQuantity().doubleValue(), 0) + "</td>" + "<td>" + sl.getInventory().getProduct().getDescription() + "</td>" + "<td>" + "DELIVERY DATE FIELD MISSING" + "</td>" + "<td>"
                                        //+ FinnancialMath.formatarMoeda(sl.getUnPrice(), 2)
                                        + "</td>" + "<td>"
                                        //+ FinnancialMath.formatarMoeda(sl.getTotalPrice(), 2)
                                        + "</td>" + "</tr>";
                            }

                            int numRowsToAdd = maxRows - rows;
                            if (numRowsToAdd > 0) {
                                for(int k = 0; k <= numRowsToAdd; ++k) {
                                    addressField = addressField + blancTableRow;
                                }
                            }

                            html = html.replaceAll("items", addressField);
                        } else {
                            html = html.replaceAll("items", addressField);
                        }
                        break;
                    case 2:
                        Date dataPedido = (Date)fieldValue;
                        html = html.replaceAll(fieldName, DateUtil.toStringDDmmYYYY(dataPedido));
                        break;
                    case 3:
                        double totalPedido = (Double)fieldValue;
                        html = html.replaceAll(fieldName, FinnancialMath.formatarMoeda(totalPedido, 2));
                        break;
                    default:
                        if (fieldValue != null) {
                            html = html.replaceAll(fieldName, fieldValue.toString());
                            System.out.println(fieldName + " = " + fieldValue);
                        }
                }
            }
        }

        return html;
    }

    private Map initDictionary(Object object) throws IllegalArgumentException, IllegalAccessException {
        if (object == null) {
            return new HashMap();
        } else {
            Class cla = object.getClass();
            Map dictionary = new HashMap();
            Field[] fields = cla.getDeclaredFields();
            Field[] var5 = fields;
            int var6 = fields.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Field f = var5[var7];
                String field = f.getName();
                f.setAccessible(true);
                Object value = f.get(object);
                dictionary.put(field, value);
            }

            return dictionary;
        }
    }

    private String getSaleHeaderHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title></title><style>table.centralizado{width:100%;}table.detalhes{border-collapse:collapse; border:1px solid black; width:100%;font-size:13px; margin-left:auto; margin-right:auto;}table.detalhes th, table.detalhes tr, table.detalhes td{border-collapse:collapse; border:1px solid black;}table.detalhes td{text-align:center;}table.dadosCliente{border-collapse:collapse; border:1px solid black; width:100%;font-size:13px; margin-left:auto; margin-right:auto;}table.dadosCliente th, table.dadosCliente tr, table.dadosCliente td{border-collapse:collapse; border:1px solid black;}table.dadosCliente td{text-align:left;}</style></head><body><table border=\"0\" style=\"margin-left:auto; margin-right:auto; width:100%;\"><tbody><tr><td><table class=\"centralizado\" border=\"0\" style=\"margin-left:auto; margin-right:auto;\"><tbody><tr style=\"font-size:8px;\"><td align=\"left\"><img src='" + FileUtil.getHome() + "img/logo-vof.jpg' style=\"width: 150px; height: 75px;\"/>" + "</td>" + "<td colspan=\"9\" align=\"center\">" + "<strong>Matriz : V.O.F. BORRACHAS INDUSTRIAIS EIRELI.</strong>" + "<br/>" + "ENDERECO: RUA MAJOR CARLOS DEL FRETE, 497 BAIRRO: SANTO ANTONIO" + "<br/>" + "CEP: 09530-001 CIDADE: SÃO CAETANO DO SUL ESTADO : SP" + "<br/>" + "CNPJ: 12.924.521/0001-14 INSCR.EST: 636.222.791.118" + "<br/>" + "TELEFONES: (11)3895-2200 (11) 2843-0944" + "<br/>" + "E-mail : vof@vofborrachas.com.br / faturamento@vofborrachas.com.br" + "</td>" + "<td colspan=\"9\" align=\"center\">" + "<strong>Filial : V.O.F. BORRACHAS INDUSTRIAIS EIRELI.</strong>" + "<br/>" + "ENDERECO: Rua Pedro Picussa,920 BAIRRO: Umbara" + "<br/>" + "CEP: 81930-610 CIDADE: Curitiba ESTADO : PR" + "<br/>" + "CNPJ: 12.924.521/0002-03 INSCR.EST: 90646935-97" + "<br/>" + "TELEFONES: (41)3348-0526" + "<br/>" + "E-mail : vof@vofborrachas.com.br / faturamento@vofborrachas.com.br" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<table class=\"centralizado\" style=\"font-size:13px; margin-left:auto; margin-right:auto;\">" + "<tbody>" + "<tr>" + "<td colspan=\"9\" align=\"left\">" + "<strong>PEDIDO N.: </strong>" + "numeroPedido" + "</td>" + "<td align=\"right\">" + "<strong>DATA:</strong> dataPedido" + "</td>" + "</tr>" + "<tr>" + "<td colspan=\"9\" align=\"left\">" + "<strong>PEDIDO CLIENTE: </strong>" + "pedidoCliente" + "</td>" + "<td>" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<br/>" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "<table class=\"dadosCliente\">" + "<tbody>" + "<tr>" + "<td colspan=\"9\">" + "<strong>CLIENTE: </strong>" + "razaoSocialCli" + "</td>" + "</tr>" + "<tr>" + "<td style=\"width: 48%\">" + "<strong>CNPJ: </strong>" + "cnpjCli" + "</td>" + "<td style=\"width: 25%\">" + "<strong> INSC. EST.: </strong>" + "inscEstCli" + "</td>" + "<td style=\"width: 27%\">" + "<strong> INSC. MUN.: </strong>" + "inscMunCli" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<strong>ENDERECO: </strong>" + "streetCli, numberCli" + " - " + "neighborhoodCli" + "</td>" + "<td>" + "<strong> CEP: </strong>" + "zipCli" + "</td>" + "<td>" + "<strong> CIDADE: </strong>" + "cityCli" + " - " + "countryStateCli" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<strong>COMPRADOR: </strong>" + "comprador" + "</td>" + "<td>" + "<strong>PRAZO: </strong>" + "prazoPgto" + "</td>" + "<td>" + "<strong> ICMS: </strong>" + "icms %" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<strong>DANFE: </strong>" + "emailCli" + "</td>" + "<td>" + "<strong>TRANSP.: </strong>" + "transportadora" + "</td>" + "<td>" + "<strong> FRETE: </strong>" + "frete " + "</td>" + "</tr>" + "<tr>" + "<td colspan=\"4\">" + "<strong>END. ENTREGA.: </strong>" + "endEntrega" + "</td>" + "</tr>" + "<tr>" + "<td colspan=\"4\">" + "<strong>END. COBRANÇA: </strong>" + "endFatura" + "</td>" + "</tr>" + "<tr>" + "<td colspan=\"4\">" + "<strong>REPRESENTANTE: </strong>" + "representante" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<br/>" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<table class=\"detalhes\">" + "<tbody>" + "<tr>" + "<td>" + "<strong>TIPO</strong>" + "</td>" + "<td>" + "<strong>QUANT. KG</strong>" + "</td>" + "<td>" + "<strong>ESPECIF.</strong>" + "</td>" + "<td>" + "<strong>ENTREGA</strong>" + "</td>" + "<td>" + "<strong>PREÇO R$</strong>" + "</td>" + "<td>" + "<strong>TOTAL</strong>" + "</td>" + "</tr>" + "items" + "</tbody>" + "</table>" + "<table align=\"right\" style=\"font-size:13px; border-collapse:collapse; border:1px solid black;\">" + "<tbody>" + "<tr>" + "<td colspan=\"9\" align=\"center\" style=\"width: 123px;\">" + "<strong>TOTAL </strong>" + "</td>" + "<td align=\"center\" style=\"width: 100px;\">" + "total" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "</td>" + "</tr>" + "<tr>" + "<td>" + "<strong> OBS.: </strong>" + "observacoes" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "</body>" + "</html>");
        return sb.toString();
    }

    public static void main(String[] args) throws SAXException, DocumentException, ParserConfigurationException, IOException, IllegalArgumentException, IllegalAccessException, SAXException {
        Sale saleHeader = new Sale();
        Customer customer = new Customer();
        Identification ide = new Identification();
        /*ide.setNomeFantasia("José Esteves de Souza Neto");
        ide.setCnpj("02966076909");
        ide.setInscEst("789987");
        ide.setInscMun("123321");*/
        Address add = new Address();
        add.setStreet("Rua Pereira Passos");
        add.setNumber("838");
        add.setZip("87711-030");
        add.setNeighborhood("Jardim São Jorge");
        add.setCity("Paranavaí");
        add.setCountryState("PR");
        add.setCountry("Brasil");
        customer.setIdentification(ide);
        customer.setAddress(add);
        saleHeader.setCustomer(customer);
        List items = new ArrayList();
        SaleItem item = new SaleItem();
       /* item.setQuantity(14000.0D);
        item.setUnPrice(6.5D);
        item.setDataEntrega(new Date());
        double subTotal = item.getQuantity() * item.getUnPrice();
        item.setTotalPrice(subTotal);
        Product product = new Product();
        product.setDescription("GEB");
        product.setCharacteristics("GEB 1");
        item.setProduct(product);
        items.add(item);
        saleHeader.setItems(items);
        saleHeader.setTransportadora("Excellence");
        saleHeader.setFrete("CIF");
        saleHeader.setPrazoPgto("30, 60, 90");
        saleHeader.setIcms("12");
        saleHeader.setObservacoes("Incluir número do pedido do Cliente na fatura");
        saleHeader.setComprador("Gislaine");
        saleHeader.setDataPedido(new Date());
        saleHeader.setNumeroPedido("140510");
        saleHeader.setEmailDanfe("estiveste@gmail.com");
        saleHeader.setPedidoCliente("1423567");
        saleHeader.setTotal(subTotal);
        String defaulAddress = saleHeader.getCustomer().getAddress().getStreet() + ", " + saleHeader.getCustomer().getAddress().getNumber() + " - Bairro " + saleHeader.getCustomer().getAddress().getNeighborhood() + " - CEP " + saleHeader.getCustomer().getAddress().getZip() + " - " + saleHeader.getCustomer().getAddress().getCity() + "-" + saleHeader.getCustomer().getAddress().getCountryState();
        saleHeader.setEndEntrega(defaulAddress);
        saleHeader.setEndFatura(defaulAddress);
        */PdfCreator creator = new PdfCreator();
        Translator trans = new Translator();
        String html = trans.translateSaleHeader(saleHeader);
        creator.createFromHtml(html, "pedido");
    }
}
