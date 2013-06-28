package edu.sdkd.domain;

import edu.sdkd.utils.Constant;

import java.util.Date;

import com.mysql.jdbc.Blob;

public class CircleCard {
	private int circle;
	private int cards;

	public int getCircleId() {
		return circle;
	}

	public void setCircleId(int circle) {
		this.circle = circle;
	}

	public int getCardId() {
		return cards;
	}

	public void setCardId(int cards) {
		this.cards = cards;
	}
}
