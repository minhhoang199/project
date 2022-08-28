package com.example.chatWebsocket.model.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestConnectionVM {
    private String followingPhone;
    private String followedPhone;
}
