package us.greatapps4you.greatsales.entities.accounting;

/**
 * The Chart of Accounts
 * A Chart of Accounts is a list of all the names of the accounts found
 * in the General Ledger with an account code allocated to it.
 * Chart of Accounts is sometimes abbreviated to COA.
 * The Chart of Accounts simply sets out the structure
 * of your accounts so that all similar accounts are grouped together.
 * For example, balance sheet fixed asset accounts
 * might have codes from 10-50, income accounts might have codes from 4000-4999.
 * The Chart of Accounts should be split into balance sheet
 * and income statement sections, each of which is then
 * subdivided into groups (e.g. fixed assets, accounts receivable, sales etc).
 * Generally the most used accounts should be kept near the top of each group.
 */

public class Account {

    private String name;
    private FinancialStatement financialStatement;
    private AccountGroup group;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinancialStatement getFinancialStatement() {
        return financialStatement;
    }

    public void setFinancialStatement(FinancialStatement financialStatement) {
        this.financialStatement = financialStatement;
    }

    public AccountGroup getGroup() {
        return group;
    }

    public void setGroup(AccountGroup group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
