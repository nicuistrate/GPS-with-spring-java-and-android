package edu.utcn.gpsm.position;

import lombok.Data;

import java.util.Date;

@Data
public class PositionDTO {

    private Integer id;
    private Date creationTime;
    private String terminalId;
    private String latitude;
    private String longitude;


}
