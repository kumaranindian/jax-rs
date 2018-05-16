package com.jersey.friends.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.friends.pojo.Friend;
import com.jersey.friends.service.FriendCollectionService;


@Path("/friends")
public class FriendsController {
	FriendCollectionService fcs = new FriendCollectionService();

	// CRUD FOR FRIENDS

	// get the list of all friends

	@GET
	@Path("/getallfriends")
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllFriends() {
		List allfrnds = fcs.getAllFriends();

		// for (int i = 0; i < allfrnds.size(); i++) {
		// Friend f=(Friend)allfrnds.get(i);
		// System.out.println(f.id+"===>"+f.name);
		// }

		return allfrnds;
	}

	// get the name of friend by id
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Friend getFriendById(@PathParam("id") int idToSearch) {
		Friend searchedfrnd=	fcs.getFriendById(idToSearch);
		return searchedfrnd;

	}

	// update the friend
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public List updateFriend(Friend frnd) {
		System.out.println("hai 1");
		Friend updatedfrnd=fcs.updateFrnd(frnd);	
		System.out.println("hai 3");
		List<Friend> updatedlist=fcs.getAllFriends();
		return updatedlist;
	}

	// delete the friend
	
	@DELETE
	@Path("/delete/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	public List deleteFriend(@PathParam("id") int idToDelete) {
			Friend remainingfrnd=	fcs.delFriendById(idToDelete);
			List<Friend> remaininglist=fcs.getAllFriends();
			return remaininglist;

		}

}
