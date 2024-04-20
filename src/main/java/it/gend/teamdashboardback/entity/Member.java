package it.gend.teamdashboardback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Daniele Asteggiante
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "member")
public class Member implements Serializable {
    @Id
    private long id;
    private String name;
    private String surname;
    private String role;
    @ManyToOne
    @JsonBackReference
    private Team team;
    private String email;
    @ManyToOne
    @JsonManagedReference
    private JobDescription jobDescription;
}
