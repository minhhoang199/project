package com.example.chatWebsocket.controller;

import com.example.chatWebsocket.model.vm.ConnectionStatusVM;
import com.example.chatWebsocket.model.vm.RequestConnectionVM;
import com.example.chatWebsocket.service.ConnectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/connections")
public class ConnectionController {
    private ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping
    public ResponseEntity<String> addNewConnection(@RequestBody RequestConnectionVM requestConnectionVM){
        this.connectionService.createConnection(requestConnectionVM);
        return ResponseEntity.ok("Create Connection success");
    }

    @PatchMapping
    public ResponseEntity<String> changeStatus(
            @RequestBody ConnectionStatusVM connectionStatusVm){
        this.connectionService.changeConnectionStatus(connectionStatusVm);
        return ResponseEntity.ok("Create Connection success");
    }
}
