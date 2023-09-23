package it.cascella.chat.events;

public interface AuthenticationEventListner {
    void loginSuccessfull(int id);
    void loginFailed(String reason);
}
