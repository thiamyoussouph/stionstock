package com.udemy.courudemy.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.courudemy.Enteties.Adresse;
import com.udemy.courudemy.Enteties.Client;
import com.udemy.courudemy.Enteties.CommandeClients;
import com.udemy.courudemy.Enum.EtatsCommande;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class ClientDTO {
    private long id;
    private String name;
    private String prenom;
    private String email;
    private String photo;

    private AdresseDTO adresse;
    private String tel;
    private int identreprise;
    @JsonIgnore
    private List<CommandeClientDTO> commandeClients;
    public static ClientDTO fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .photo(client.getPhoto())
                .adresse(AdresseDTO.fromEntity(client.getAdresse()))
                .tel(client.getTel())
                .identreprise(client.getIdentreprise())
                .build();
    }
    public static Client toEntity(ClientDTO clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setPhoto(clientDTO.getPhoto());
        client.setAdresse(AdresseDTO.toEntity(clientDTO.getAdresse()));
        client.setTel(clientDTO.getTel());
        client.setIdentreprise(clientDTO.getIdentreprise());
        return client;
    }
}
