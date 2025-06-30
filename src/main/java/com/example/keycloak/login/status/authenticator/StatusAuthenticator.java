package com.example.keycloak.login.status.authenticator;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.authentication.AuthenticationFlowError;

import java.util.List;

public class StatusAuthenticator implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        UserModel user = context.getUser();
        String status = user.getFirstAttribute("status");
        if ("BAN".equalsIgnoreCase(status)) {
            Response response = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"400\", \"error_description\": \"User is banned\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();

            context.failureChallenge(AuthenticationFlowError.INVALID_USER, response);
        } else if ("GRADUATED".equalsIgnoreCase(status)) {
            Response response = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"400\", \"error_description\": \"User is graduate\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build();

            context.failureChallenge(AuthenticationFlowError.INVALID_USER, response);
        } else {
            context.success();
        }

    }

    @Override public void action(AuthenticationFlowContext context) {}
    @Override public boolean requiresUser() { return true; }
    @Override public boolean configuredFor(org.keycloak.models.KeycloakSession session, org.keycloak.models.RealmModel realm, UserModel user) {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {

    }

    @Override
    public List<RequiredActionFactory> getRequiredActions(KeycloakSession session) {
        return Authenticator.super.getRequiredActions(session);
    }

    @Override
    public boolean areRequiredActionsEnabled(KeycloakSession session, RealmModel realm) {
        return Authenticator.super.areRequiredActionsEnabled(session, realm);
    }

    @Override public void close() {}
}
