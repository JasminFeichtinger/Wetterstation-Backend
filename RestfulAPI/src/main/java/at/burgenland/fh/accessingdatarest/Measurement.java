package at.burgenland.fh.accessingdatarest;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter@Table(name = "Measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //to get relationship between sensor and measurement
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    private LocalDateTime timeStamp;

    private double temperature;

    private double humidity;

}
