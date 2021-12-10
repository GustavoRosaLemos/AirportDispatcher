package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Package {
    private int id;
    private String packageType;
    private String packageCategory;
    private String owner;
    private int weight;
    private String weightType;
}
