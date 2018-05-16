package com.jersey.friends.service;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.jersey.friends.dao.FriendDAO;
import com.jersey.friends.pojo.Friend;

public class FriendCollectionService {

	
	FriendDAO dao=new FriendDAO();
	static HashMap<Integer, Friend> friendsmap = new HashMap<Integer, Friend>();

	public FriendCollectionService() {
		super();

		Friend frnd1 = new Friend("kathir", 1, "chennai");
		Friend frnd2 = new Friend("arun", 2, "kkl");
		Friend frnd3 = new Friend("kathir", 3, "inmaa");

		friendsmap.put(1, frnd1);
		friendsmap.put(2, frnd2);
		friendsmap.put(3, frnd3);

	}

	

	public List getAllFriends() {
		List friends = new ArrayList(friendsmap.values());
		return friends;
	}

	public Friend getFriendById(int idToSearch) {
		// TODO Auto-generated method stub
		Friend searchedfrnd=friendsmap.get(idToSearch);
		return searchedfrnd;
		
	}

	public Friend updateFrnd(Friend frnd) {
		// TODO Auto-generated method stub
		System.out.println("hai 2");
		System.out.println("before update ==>"+frnd.getLocation());

		Friend f= friendsmap.put(frnd.getId(), frnd);	
		System.out.println("after update ==>"+frnd.getLocation());

		return f;
		}

	public Friend delFriendById(int idToDelete) {
		// TODO Auto-generated method stub
		Friend f= friendsmap.remove(idToDelete);		
		return f;
	}
}
