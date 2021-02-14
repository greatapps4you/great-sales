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

package us.greatapps4you.greatsales.entities.accounting;

/**
 * 1. Assets
 * An asset is something that the company owns. An asset can be physical, like cash, bank accounts, inventory, or equipment. Alternatively, an asset can be part of an agreement with someone that agrees to pay the business something in the future, like accounts receivables or loans (if the company is the one loaning the money). Finally, an asset can be something intangible, like intellectual property.
 *
 * 2. Liabilities
 * It’s common for businesses to take out loans to purchase goods or pay for services. These loans are called liabilities, which simply refers to the fact that money that has to be paid to someone in the future. One particularly common type of liability is accounts payable. This account refers to money that is owed to a vendor when they provide a business with a product or service up front and ask for payment later, for example, after 30 days of delivery.
 *
 * 3. Equity
 * Equity is money that comes from the owners of the company. The key distinction between equity and liability is that there’s usually no expectation that this money will be paid back.
 * A few common accounts of this type are:
 * Share Capital: the amount of money that the owners have given to the company as startup or growth funding.
 * Retained Earnings: the profit that the company has earned (i.e. total revenue minus total expense, since the company was founded).
 * Dividends: the amount of money that the company has paid to the owners (shareholders) from its profits. This is counted as a negative number, since as profit is paid back to owners, the amount of profit remaining within the company decreases. Equity decreases as dividends are paid.
 *
 * 4. Revenue
 * Revenue is money that the company has collected from customers for sales, or as payment for services.
 *
 * 5. Expense
 * An expense is money that is paid out by the company to keep the business running. Expense must be differentiated from investment. With an expense, the company gets a one-time benefit from the money spent. With an investment, the company will get a lasting benefit from the money spent. Investments get categorized as assets, not expenses.
 */
public enum AccountGroup {
    ASSETS,
    LIABILITIES,
    EQUITY,
    REVENUE,
    EXPENSE
}
