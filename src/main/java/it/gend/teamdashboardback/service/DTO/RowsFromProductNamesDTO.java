package it.gend.teamdashboardback.service.DTO;

import it.gend.teamdashboardback.entity.TableRow;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 * @author Daniele Asteggiante
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RowsFromProductNamesDTO {
    TableRow tableRow;
    Set<ProductVersionDTO> rowsFromProductNames;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ProductVersionDTO {
        private String productName;
        private String version;
        private String notes;
    }
}
