package com.mycompany.hibernate_inheritance;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Special Edition CD")
public class SpecialEditionCD extends CD {
	private String newfeatures;

	public SpecialEditionCD() {
		super();
	}

	public SpecialEditionCD(String title, String artist, Date purchaseDate, double cost, String features) {
		super(title, artist, purchaseDate, cost);
		newfeatures = features;
	}
}