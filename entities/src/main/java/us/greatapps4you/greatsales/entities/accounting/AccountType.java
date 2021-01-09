package us.greatapps4you.greatsales.entities.accounting;

/**
 * Account types:
 * Income designates any account used to track money coming into your business.
 * Expense designates any account used to track money leaving your business.
 * Cost of Sale (COS) and Cost of Goods Sold (COGS) are unique.
 * These accounts track the money you have to spend
 * to create the product you sell your customers or clients.
 * They're often used interchangeably—COS by retailers,
 * and COGS by manufacturers.
 */
public enum AccountType {
    INCOME, EXPENSE, COS, COGS
}
