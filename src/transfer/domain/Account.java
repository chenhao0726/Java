package transfer.domain;

import java.math.BigDecimal;

public class Account {
	private Long id;
	private String name;
	private BigDecimal money;
	
	public Account() {
	}
	public Account(Long id, String name, BigDecimal money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	
}
