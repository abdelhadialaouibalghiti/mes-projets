/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.client;

import modele.client.Client;

/**
 *
 * @author maithili
 */
public interface ClientDao {

 // public List<Client> getAllClient();

  public boolean addClient(Client client) throws ClassNotFoundException;
  public boolean searchClient(Client client) throws ClassNotFoundException;

  //public Client getClient( int clientId );

  //public void updateClient( Client client );

  //public void deleteClient( int clientId );


}
