package com.example.chatWebsocket.model.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InviteeVm {
    private List<String> inviteePhones;
    private String invitorPhone;
}
