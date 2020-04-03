package edu.utcn.gpsm.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Vig Marian
 * @since 16.10.2019
 */
@Service
public class PositionService {

    private PositionRepository positionRepository;
    private MapperPosition mapperPosition;

    @Autowired
    public PositionService(PositionRepository positionRepository, MapperPosition mapperPosition) {
        this.positionRepository=positionRepository;
        this.mapperPosition=mapperPosition;
    }

    public PositionDTO create(PositionDTO positionDTO) {
        Position position =  mapperPosition.mapDTOToEntity(positionDTO);
        positionRepository.save(position);
        return mapperPosition.mapEntityToDTO(position);
    }

    public PositionDTO getByID(Integer id){
        Optional<Position> position =positionRepository.findById(id);
        if(position.isPresent()){
           return mapperPosition.mapEntityToDTO(position.get());
        }
        else{
            System.out.println("Position is not present");
            return  null;
        }
    }

    public List<PositionDTO> getAll(String startDate, String endDate, String terminal_id) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = formatter.parse(startDate.replaceAll("Z$", "+0000"));
        Date enddate = formatter.parse(endDate.replaceAll("Z$", "+0000"));

        List<Position> positions = (List<Position>) positionRepository.findAll();
        List<PositionDTO> positionDTOS = new ArrayList<>();

        for (Position p:positions) {

            if(p.getCreationTime().compareTo(startdate)>0 && p.getCreationTime().compareTo(enddate)<0 && p.getTerminalId().equals(terminal_id)) {
                positionDTOS.add(mapperPosition.mapEntityToDTO(p));
            }
        }
        return positionDTOS;
    }

    public PositionDTO update(PositionDTO positionDTO){
        Position position = mapperPosition.mapDTOToEntity(positionDTO);
        return mapperPosition.mapEntityToDTO(positionRepository.save(position));
    }

    public void delete(Integer id){
        positionRepository.deleteById(id);
    }

    //public List<PositionDTO>


}
