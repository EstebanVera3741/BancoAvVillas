package BancoAvVillas.commons.exception.Advice;

import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.commons.exception.BankAvVillasGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BankAvVillasControllerAdvice {

    @ExceptionHandler(BankAvVillasGeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericResponseDTO> bankAvVillasGeneralException (
            BankAvVillasGeneralException bankAvVillasGeneralException){

        return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                .message(GeneralResponse.OPERATION_FAIL)
                .objectResponse(bankAvVillasGeneralException.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}