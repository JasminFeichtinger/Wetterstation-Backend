package at.burgenland.fh.accessingdatarest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sensors")
public class Sensor {
    //to get relationship between sensor and measurements, cascade => delete connected measurements too
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "sensor")
    private List<Measurement> measurements;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String location;

    private boolean active;

    private SensorType sensorType;

}
