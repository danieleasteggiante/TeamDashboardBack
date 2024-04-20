package it.gend.teamdashboardback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Daniele Asteggiante
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "job_description")
public class JobDescription implements Serializable {
    @Id
    private long id;
    private String description;
    @OneToMany(mappedBy = "jobDescription")
    @JsonBackReference
    private Set<Member> members;
}
