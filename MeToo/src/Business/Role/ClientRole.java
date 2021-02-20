/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ClientOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.ClientRole.ClientWorkAreaJPanel;


/**
 
 */
public class ClientRole extends Role{
    public ClientRole() {
        super(Role.RoleType.Client.getValue());
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        return new ClientWorkAreaJPanel(userProcessContainer, account, (ClientOrganization)organization, enterprise, network, system);
    }
}
