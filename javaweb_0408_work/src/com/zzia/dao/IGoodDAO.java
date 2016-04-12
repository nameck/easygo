package com.zzia.dao;

import java.util.List;

import com.zzia.model.Good;


public interface IGoodDAO {
	//获取所有物品信息
	public abstract List<Good>getAllGood();
	public abstract void updateGood(String name,int count,double price,String updataName);
	public abstract void deleteGood(String name);
}
