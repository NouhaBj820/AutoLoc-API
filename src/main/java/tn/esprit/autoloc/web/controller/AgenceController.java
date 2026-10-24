package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Agences", description = "Gestion des agences de location")
@RestController
@RequestMapping("agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    // Q11 : liste
    @Operation(summary = "Lister les agences",
            description = "Retourne la liste complète des agences")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping
    public List<Agence> findAll() {
        return agenceService.findAll();
    }

    // Q19 : consultation
    @Operation(summary = "Consulter une agence",
            description = "Retourne l'agence dont l'identifiant est passé dans l'URL")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @GetMapping("/{id}")
    public Agence findById(
            @Parameter(description = "Identifiant de l'agence", example = "6")
            @PathVariable Long id) {
        return agenceService.findById(id);
    }

    // Q21 : ajout
    @Operation(summary = "Ajouter une agence",
            description = "Crée une nouvelle agence à partir du JSON envoyé")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agence créée"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agence save(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    // Q24 : modification
    @Operation(summary = "Modifier une agence",
            description = "Met à jour l'agence dont l'identifiant est passé dans l'URL")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @PutMapping("/{id}")
    public Agence update(
            @Parameter(description = "Identifiant de l'agence", example = "6")
            @PathVariable Long id,
            @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }

    // Q25 : suppression
    @Operation(summary = "Supprimer une agence",
            description = "Supprime l'agence dont l'identifiant est passé dans l'URL")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Agence supprimée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @Parameter(description = "Identifiant de l'agence", example = "6")
            @PathVariable Long id) {
        agenceService.deleteById(id);
    }
}