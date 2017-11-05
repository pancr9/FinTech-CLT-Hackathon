package herapheri.com.fintech.Model;

/*
 * Copyright (c) 2015 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc.
 * Use is subject to license terms.
 */
public class Account {
    private String CONTAINER;
    private String accountName;
    private String accountNumber;
    private String isAsset;
    private Money balance;
    private String currency;
    private String errorCode;
    private String id;
    private String lastUpdated;
    private String nickname;
    private String status;
    private Money availableBalance;
    private Money currentBalance;
    private String type;
    private String classification;
    private String routingNumber;
    private Money amountDue;
    private String apr;
    private Money availableCash;
    private Money availableCredit;
    private String dueDate;
    private String lastPaymentDate;
    private String lastPaymentAmount;
    private Money minimumAmountDue;
    private String runningBalance;
    private String availableLoan;
    private String annuityBalance;
    private Money cash;
    private Money marginBalance;
    private Money totalInvestedAmount;
    private Money totalUnvestedBalance;
    private Money totalVestedBalance;
    private String expirationDate;
    private String maturityDate;
    private String term;
    private Money originalLoanAmount;
    private String interestRate;
    private String enrollmentDate;
    private String primaryRewardUnit;
    private RefreshInfo refreshInfo;


    public String getCONTAINER() {
        return CONTAINER;
    }

    public void setCONTAINER(String cONTAINER) {
        CONTAINER = cONTAINER;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIsAsset() {
        return isAsset;
    }

    public void setIsAsset(String isAsset) {
        this.isAsset = isAsset;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Money getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Money availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Money getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Money currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Money getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Money amountDue) {
        this.amountDue = amountDue;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public Money getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(Money availableCash) {
        this.availableCash = availableCash;
    }

    public Money getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Money availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getLastPaymentAmount() {
        return lastPaymentAmount;
    }

    public void setLastPaymentAmount(String lastPaymentAmount) {
        this.lastPaymentAmount = lastPaymentAmount;
    }

    public Money getMinimumAmountDue() {
        return minimumAmountDue;
    }

    public void setMinimumAmountDue(Money minimumAmountDue) {
        this.minimumAmountDue = minimumAmountDue;
    }

    public String getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(String runningBalance) {
        this.runningBalance = runningBalance;
    }

    public String getAvailableLoan() {
        return availableLoan;
    }

    public void setAvailableLoan(String availableLoan) {
        this.availableLoan = availableLoan;
    }


    public String getAnnuityBalance() {
        return annuityBalance;
    }

    public void setAnnuityBalance(String annuityBalance) {
        this.annuityBalance = annuityBalance;
    }

    public Money getCash() {
        return cash;
    }

    public void setCash(Money cash) {
        this.cash = cash;
    }

    public Money getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(Money marginBalance) {
        this.marginBalance = marginBalance;
    }

    public Money getTotalInvestedAmount() {
        return totalInvestedAmount;
    }

    public void setTotalInvestedAmount(Money totalInvestedAmount) {
        this.totalInvestedAmount = totalInvestedAmount;
    }

    public Money getTotalUnvestedBalance() {
        return totalUnvestedBalance;
    }

    public void setTotalUnvestedBalance(Money totalUnvestedBalance) {
        this.totalUnvestedBalance = totalUnvestedBalance;
    }

    public Money getTotalVestedBalance() {
        return totalVestedBalance;
    }

    public void setTotalVestedBalance(Money totalVestedBalance) {
        this.totalVestedBalance = totalVestedBalance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Money getOriginalLoanAmount() {
        return originalLoanAmount;
    }

    public void setOriginalLoanAmount(Money originalLoanAmount) {
        this.originalLoanAmount = originalLoanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getPrimaryRewardUnit() {
        return primaryRewardUnit;
    }

    public void setPrimaryRewardUnit(String primaryRewardUnit) {
        this.primaryRewardUnit = primaryRewardUnit;
    }

    public RefreshInfo getRefreshInfo() {
        return refreshInfo;
    }

    public void setRefreshInfo(RefreshInfo refreshInfo) {
        this.refreshInfo = refreshInfo;
    }

}