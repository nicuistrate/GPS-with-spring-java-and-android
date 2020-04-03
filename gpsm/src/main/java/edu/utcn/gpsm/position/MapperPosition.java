package edu.utcn.gpsm.position;

import org.springframework.stereotype.Component;

@Component
public class MapperPosition {

    public PositionDTO mapEntityToDTO(Position position){

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setTerminalId(position.getTerminalId());
        positionDTO.setCreationTime(position.getCreationTime());
        positionDTO.setLatitude(position.getLatitude());
        positionDTO.setLongitude(position.getLongitude());
        return  positionDTO;
    }


    public Position mapDTOToEntity(PositionDTO positionDTO){

        Position position= new Position();
        position.setId(positionDTO.getId());
        position.setTerminalId(positionDTO.getTerminalId());
        position.setCreationTime(positionDTO.getCreationTime());
        position.setLatitude(positionDTO.getLatitude());
        position.setLongitude(positionDTO.getLongitude());
        return position;

    }
}
