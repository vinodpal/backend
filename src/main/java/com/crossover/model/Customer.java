package com.crossover.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 4864421714712250707L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String phone1;
	@Column
	private String phone2;
	@Column(name="credit_limit")
	private Double creditLimit;
	@Column(name="current_credit")
	private Double currentCredit;
	
	public Customer(){}

	public Customer(Integer code, String name, String address, String phone1,
			String phone2, Double creditLimit, Double currentCredit) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.creditLimit = creditLimit;
		this.currentCredit = currentCredit;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(Double currentCredit) {
		this.currentCredit = currentCredit;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((creditLimit == null) ? 0 : creditLimit.hashCode());
		result = prime * result
				+ ((currentCredit == null) ? 0 : currentCredit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (creditLimit == null) {
			if (other.creditLimit != null)
				return false;
		} else if (!creditLimit.equals(other.creditLimit))
			return false;
		if (currentCredit == null) {
			if (other.currentCredit != null)
				return false;
		} else if (!currentCredit.equals(other.currentCredit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder()
		.append("Customer [code= ").append(code)
		.append(", name= ").append(name)
		.append(", address= ").append(address)
		.append(", phone1= ").append(phone1)
		.append(", phone2= ").append(phone2)
		.append(", creditLimit= ").append(creditLimit)
		.append(", currentCredit= ").append(currentCredit)
		.append("]");
		return sb.toString();
	}
	
	

}
