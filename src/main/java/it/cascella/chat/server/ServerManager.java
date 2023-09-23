package it.cascella.chat.server;

import it.cascella.chat.events.AuthenticationEventListner;

import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    private static ServerManager instance = null;
    private List<AuthenticationEventListner> authListners = new ArrayList<>();
    private ServerManager() {
    }

    public static ServerManager getInstance() {
        if (instance == null) {
            instance = new ServerManager();
        }
        return instance;
    }

    public void addAuthListner(AuthenticationEventListner authenticationEventListner){
        this.authListners.add(authenticationEventListner);
    }
    public void removeAuthListner(AuthenticationEventListner authenticationEventListner){
        this.authListners.remove(authenticationEventListner);
    }
    public void login(String username, String password){
        //TODO agganciare MQTTù
        if (username.equals("test") && password.equals("test")) {
            loginSuccesfull(123);
        }
        else{
            loginFailed("test Message");
        }
    }
    private void loginSuccesfull(int id){
        for (AuthenticationEventListner authListner : authListners) {
            authListner.loginSuccessfull(id);
        }
    }
    private void loginFailed(String errorMessage){
        for (AuthenticationEventListner authListner : authListners) {
            authListner.loginFailed(errorMessage);
        }
    }
}
