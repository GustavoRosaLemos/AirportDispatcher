package model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Airport implements DatabaseModels {
    private int id;
    private String name;
    private String code;
}
