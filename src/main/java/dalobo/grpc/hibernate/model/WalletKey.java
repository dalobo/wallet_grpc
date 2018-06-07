package dalobo.grpc.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import dalobo.grpc.currency.Currency;

@Embeddable
public class WalletKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 231931339570005126L;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "CURRENCY")
	@Enumerated(EnumType.STRING)
	private Currency currency;

	public WalletKey() {
	}

	public WalletKey(long userId, Currency currency) {
		this.userId = userId;
		this.currency = currency;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
