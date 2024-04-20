package it.gend.teamdashboardback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Daniele Asteggiante
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "environment_state")
public class EnvironmentState {
    @Id
    private long id;
    private String environmentName;
    @OneToOne
    private TableRow tableRowState;
}
