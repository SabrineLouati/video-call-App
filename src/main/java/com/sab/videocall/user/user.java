package com.sab.videocall.user;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class user {
    private String username;
    private String email;
    private String password;
    private String status; //for knowing if the user is online or offline

}
