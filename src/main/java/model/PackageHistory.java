package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class PackageHistory implements DatabaseModels {
    private int id;
    private String author;
    private int packageId;
    private String action;
    private String createdAt;
}
