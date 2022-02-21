package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String packageType;
    private String packageCategory;
    private String owner;
    private int weight;
    private String weightType;

    public Package() {
        super();
    }
}
