package com.example.keycloak.login.status.authenticator;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.Collections;
import java.util.List;

public class StatusAuthenticatorFactory implements AuthenticatorFactory {

    public static final String ID = "status-authenticator";

    @Override
    public Authenticator create(KeycloakSession session) {
        return new StatusAuthenticator();
    }

    @Override
    public void init(Config.Scope scope) {}
    @Override public void postInit(KeycloakSessionFactory keycloakSessionFactory) {}
    @Override public void close() {}
    @Override public String getId() { return ID; }

    @Override public String getDisplayType() { return "Status Authenticator"    ; }
    @Override public String getHelpText() { return "Blocks login if user status is 'ban' or 'graduated'"; }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return Collections.emptyList();
    }

    @Override public boolean isConfigurable() { return false; }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[] {
                AuthenticationExecutionModel.Requirement.DISABLED,
                AuthenticationExecutionModel.Requirement.REQUIRED
        };
    }

    @Override
    public <C> C getConfig() {
        return AuthenticatorFactory.super.getConfig();
    }

    @Override public boolean isUserSetupAllowed() { return false; }
    @Override public String getReferenceCategory() { return null; }
}
