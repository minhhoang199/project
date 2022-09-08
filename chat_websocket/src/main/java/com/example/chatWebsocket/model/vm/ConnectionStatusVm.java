package com.example.chatWebsocket.model.vm;

import com.example.chatWebsocket.model.enums.ConnectionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionStatusVm {
    private String followingPhone;
    private String followedPhone;
    private ConnectionStatus connectionStatus;
}
