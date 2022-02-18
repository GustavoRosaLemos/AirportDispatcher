package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransportData implements DatabaseModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int packageId;
    private int flightId;
    private String cargo;
    public TransportData() {
        super();
    }
}
