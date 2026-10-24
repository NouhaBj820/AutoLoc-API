package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agence")
    private Set<Vehicule> vehicules;

    @OneToMany(mappedBy = "agence")
    @JsonIgnoreProperties("agence")
    private Set<Employe> employes;


}