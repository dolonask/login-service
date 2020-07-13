package kg.easy.loginservice.services;


import kg.easy.loginservice.models.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto);
}
