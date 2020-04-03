package edu.utcn.gpsm.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author Vig Marian
 * @since 16.10.2019
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(value="/send")
    public PositionDTO create(@RequestBody PositionDTO positionDTO){
        return positionService.create(positionDTO);
    }

    @GetMapping(value="/{id}")
    public  PositionDTO getPosition(@PathVariable Integer id) { return positionService.getByID(id); }

    @GetMapping(value="/getAll")
    public List<PositionDTO> getAllPosition(@RequestParam(name = "terminal_id") String terminal_id,
                                            @RequestParam(name = "startDate") String startDate,
                                            @RequestParam(name = "endDate") String endDate
    ) throws ParseException {

        return positionService.getAll(startDate, endDate,terminal_id);
    }

    @PutMapping
    public  PositionDTO update(@RequestBody PositionDTO positionDTO) { return positionService.update(positionDTO); }

    @DeleteMapping(value="/delete/{id}")
    public  void delete(@PathVariable Integer id) {  positionService.delete(id);  }

}
