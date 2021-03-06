/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Royal.itinerario.logic.converter;

import Royal.itinerario.logic.dto.ItinerarioDTO;
import Royal.itinerario.logic.entity.ItinerarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class ItinerarioConverter 
{
    public static ItinerarioDTO entity2PersistenceDTO(ItinerarioEntity entity) {
        if (entity != null) {
            ItinerarioDTO dto = new ItinerarioDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setInicio(entity.getInicio());
            dto.setFin(entity.getFin());
            if (entity.getUsuario() != null) {
                dto.setUsuario(entity.getUsuario().getId());
            }
            return dto;
        } else {
            return null;
        }
    }

    public static ItinerarioEntity persistenceDTO2Entity(ItinerarioDTO dto) {
        if (dto != null) {
            ItinerarioEntity entity = new ItinerarioEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setInicio(dto.getInicio());
            entity.setFin(dto.getFin());
            return entity;
        } else {
            return null;
        }
    }

    public static List<ItinerarioDTO> entity2PersistenceDTOList(List<ItinerarioEntity> entities) {
        List<ItinerarioDTO> dtos = new ArrayList<ItinerarioDTO>();
        for (ItinerarioEntity entity : entities) {
            dtos.add(entity2PersistenceDTO(entity));
        }
        return dtos;
    }

    public static List<ItinerarioEntity> persistenceDTO2EntityList(List<ItinerarioDTO> dtos) {
        List<ItinerarioEntity> entities = new ArrayList<ItinerarioEntity>();
        for (ItinerarioDTO dto : dtos) {
            entities.add(persistenceDTO2Entity(dto));
        }
        return entities;
    }
}
