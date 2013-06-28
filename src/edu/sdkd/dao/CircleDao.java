package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;

public interface CircleDao {
	public void addCircle(Circle circle);	
	public Circle getCircle(int id);
	public void update(Circle circle);
	public void delete(Circle circle);
	public List<Circle> list();
	
}

