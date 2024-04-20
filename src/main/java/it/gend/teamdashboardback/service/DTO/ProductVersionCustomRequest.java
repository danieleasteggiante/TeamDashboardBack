package it.gend.teamdashboardback.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductVersionCustomRequest {
    List<String> productNames;
}
