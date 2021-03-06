/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Royal.itinerario.logic.api;

import java.util.List;
import Royal.itinerario.logic.dto.ItinerarioDTO;
import Royal.itinerario.logic.dto.ItinerarioPageDTO;

/**
 *
 * @author estudiante
 */
public interface IItinerarioLogic 
{
    public ItinerarioDTO createItinerario(ItinerarioDTO detail);

    public List<ItinerarioDTO> getItinerarios();
    
    public ItinerarioPageDTO getItinerarios(Integer page, Integer maxRecords);

    public ItinerarioDTO getItinerario(Long id);

    public void deleteItinerario(Long id);

    public void updateItinerario(ItinerarioDTO detail);  
}
