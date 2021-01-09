package us.greatapps4you.greatsales.entities.accounting;

/**
 * Cash Method
 * The cash method recognizes revenue and expenses on the day they're actually received or paid. This method is the simplest for small businesses because it doesn't require you to track payables or receivables and reflects whether or not your money is actually in your account.
 * Accrual Method
 * The accrual method recognizes revenue and expenses on the day the transaction takes place, regardless of whether or not it's been received or paid. This method is more commonly used as it more accurately depicts the performance of a business over time.
 * The only thing it doesn't show, is cash flow — a business can look profitable but have zero dollars in the bank. If a business's annual revenue exceeds $5 million, it's required to use the accrual method.
 */
public enum BookkeepingMethod {
    CASH, ACCRUAL
}
