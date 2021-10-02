package de.itshack.service.entity;

import de.itshack.service.model.Disruption;
import de.itshack.service.model.NewDisruption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Table(name = "disruptions")
public class DisruptionEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    public DisruptionEntity(NewDisruption newDisruption) {
    }

    public Disruption toModel() {
        Disruption disruption = new Disruption();
        disruption.setId(this.getId());

        return disruption;
    }
}
