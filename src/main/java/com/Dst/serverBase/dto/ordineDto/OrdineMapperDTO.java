package com.Dst.serverBase.dto.ordineDto;

import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.UtenteRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class OrdineMapperDTO {

    static UtenteRepo statiCutenteRepo;

   OrdineMapperDTO(UtenteRepo utenteRepo){
       statiCutenteRepo = utenteRepo;
   }

   public static CarrelloDTO fromOrderListToCarrelloDTO(List<Ordine> orders, Long user_id){
       double totaleSpesa = orders.stream().mapToDouble(Ordine::getTotale).sum();;
       return CarrelloDTO.builder()
               .totale(totaleSpesa)
               .nomeUtente(statiCutenteRepo.findById(user_id).get().getNome())
               .emailUtente(statiCutenteRepo.findById(user_id).get().getEmail())
               .build();

   }
    public static Ordine fromDtoToEntity(Long utente_id){
        return Ordine.builder()
                .utente(statiCutenteRepo.findById(utente_id).get())
                .data(LocalDate.now())
                .stato("IN ATTESA")
                .build();
    }
    public static Ordine fromUpdateDtoToEntity(OrdineUpdateDTO dto){
      return Ordine.builder()
               .utente(statiCutenteRepo.findById(dto.getUser_id()).get())
               .stato(dto.getStato())
               .data(dto.getData())
               .build();
    }

    public static OrdineResponseDTO fromEntityToDto(Ordine ordine){
        return OrdineResponseDTO.builder()
                .data(ordine.getData())
                .dettagli(ordine.getDettagli())
                .utente(ordine.getUtente())
                .stato(ordine.getStato())
                .totale(ordine.getTotale())
                .build();
    }

    public static List<OrdineResponseDTO> fromEntitiesToDtoList(List<Ordine> orders){
        return orders.stream().map(OrdineMapperDTO::fromEntityToDto).toList();
    }

}
