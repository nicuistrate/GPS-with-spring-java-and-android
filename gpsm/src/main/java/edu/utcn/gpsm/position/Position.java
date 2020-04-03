package edu.utcn.gpsm.position;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Vig Marian
 * @since 16.10.2019
 */
@Entity
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @ApiModelProperty(hidden = true)
    private Date creationTime;

    private String terminalId;
    private String latitude;
    private String longitude;
}
