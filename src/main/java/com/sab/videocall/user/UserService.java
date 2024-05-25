package com.sab.videocall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//this user service will hold all the implementation of our user service aka dealing with all the methods that the user have
@Service
public class UserService {
    private static final List<user> USER_LIST = new ArrayList<>();

    public void register(user User){
        //when we register a user this means that the user by default should be online
        User.setStatus("online");
        USER_LIST.add(User);
    }

    public user login(user User){
        //This line creates an IntStream of integers from 0 to one less than the size of the USER_LIST collection.
        // This stream represents the indices of elements in the list.
        var userIndex = IntStream.range(0, USER_LIST.size())
                //It checks for a match between the email of the User and the email of the user in the list at the current index.
                .filter(i-> USER_LIST.get(i).getEmail().equals(User.getEmail()))
                //This method tries to find any element that matches the filter criteria
                .findAny()
                // If a user with the specified email is found, this line returns the index of that user as an integer.
                // If no user is found, it throws a RuntimeException with the message "User not found."
                .orElseThrow(()-> new RuntimeException("User not found"));
        //once i get my user now i need to fetch it
        //This line retrieves the user object at the userIndex from the USER_LIST.
        var connectedUser = USER_LIST.get(userIndex);
        //This line compares the password of the user obtained from USER_LIST
        if (!connectedUser.getPassword().equals(User.getPassword())){
            throw new RuntimeException("Password incorrect");
        }
        // Assuming the password check was successful, this line sets the status of the connectedUser to "online."
        connectedUser.setStatus("online");
        //returns the connectedUser object, which represents the user who has successfully logged in
        return connectedUser;
    }
    public void logout(String email){
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i-> USER_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User not found"));
        USER_LIST.get(userIndex).setStatus("offline");
    }

    public List<user> findAll(){
        return USER_LIST;

    }
}
