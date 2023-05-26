package com.faunaval.api.rest.mapper;

import com.faunaval.api.persistencia.modelo.Foto;
import com.faunaval.api.rest.dto.FotoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FotoMapper {

    public static FotoDTO toDTO(Foto foto) {
        FotoDTO fotoDTO = new FotoDTO();
        fotoDTO.setId(foto.getId());
        fotoDTO.setUrl(foto.getUrl());

        return fotoDTO;
    }

    public static FotoDTO toDTO(Optional<Foto> fotoOptional) {
        if (fotoOptional.isEmpty()) {
            return null;
        }
        return FotoMapper.toDTO(fotoOptional.get());
    }

    public static List<FotoDTO> toDTO(List<Foto> fotos) {
        List<FotoDTO> fotoDTOS = new ArrayList<>();

        if (fotos == null) {
            return fotoDTOS;
        }
        for (Foto foto : fotos) {
            fotoDTOS.add(FotoMapper.toDTO(foto));
        }
        return fotoDTOS;
    }

    public static Foto toBD(FotoDTO fotoDTO) {
        Foto foto = new Foto();
        foto.setId(fotoDTO.getId());
        foto.setUrl(fotoDTO.getUrl());

        return foto;
    }

    public static List<Foto> toBD(List<FotoDTO> fotoDTOS) {
        List<Foto> fotos = new ArrayList<>();
        if (fotoDTOS == null) {
            return fotos;
        }
        for (FotoDTO fotoDTO : fotoDTOS) {
            fotos.add(FotoMapper.toBD(fotoDTO));
        }
        return fotos;
    }
}
