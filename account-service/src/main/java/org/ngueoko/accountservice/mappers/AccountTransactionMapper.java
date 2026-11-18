package org.ngueoko.accountservice.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.ngueoko.accountservice.dto.AccountRequestDTO;
import org.ngueoko.accountservice.dto.AccountResponseDTO;
import org.ngueoko.accountservice.domain.Account;
import org.ngueoko.accountservice.exceptions.NegativeAmountException;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
     Account sourceToDestination(AccountRequestDTO AccountRequestDTO);
     AccountResponseDTO destinationToSource(Account Account);
     List<AccountResponseDTO>  fromAccountList(List<Account> Accounts);

     //Test de sur cette Methode
     @AfterMapping
    default void setUpdatedDate(@MappingTarget Account Account){
         Account.setUpdatedAt(LocalDateTime.now());
     }
    //Test de sur cette Methode
    @AfterMapping
    default void setcreatedDate(@MappingTarget Account Account){
        Account.setCreatedAt(LocalDateTime.now());
    }

    //Test de sur cette Methode
    @AfterMapping
    default void checkbalance(@MappingTarget Account Account) {
        if (Account.getBalance() < 0)
            throw new NegativeAmountException(String.format("Balance negative : %s)", Account.getBalance()));

    }
}
