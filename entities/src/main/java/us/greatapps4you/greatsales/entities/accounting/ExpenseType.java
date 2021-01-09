package us.greatapps4you.greatsales.entities.accounting;

/**
 * Fixed expenses are consistent expenses, like rent or salaries. These expenses aren't typically affected by company sales or market trends.
 * Variable expenses fluctuate with company performance and production, like utilities and raw materials.
 * Accrued expenses are single expenses that have been recorded or reported but not yet paid. (These would fall under accounts payable.)
 * Operating expenses are necessary for a company to do business and generate revenue, like rent, utilities, payroll, and utilities.
 */
public enum ExpenseType {
    FIXED, VARIABLE, ACCRUED, OPERATING
}
