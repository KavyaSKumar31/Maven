package com.mycompany.hibernate_inheritance;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("International CD")
public class InternationalCD extends CD {
	private String languages;
	private int region;

	public InternationalCD() {
	}

	public InternationalCD(String title, String artist, Date purchaseDate, double cost, String language, int region) {
		super(title, artist, purchaseDate, cost);
		languages = language;
		this.region = region;
	}
}