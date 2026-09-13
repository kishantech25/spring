package com.nt.service;

import com.nt.config.Accounts;
import com.nt.dao.AccountsDAO;
import com.nt.model.AccountDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/accounts")
public class AccountsService {

 private AccountsDAO accountDAO;

    Function<AccountDTO,Accounts> mapper = new Function<AccountDTO, Accounts>() {
        @Override
        public Accounts apply(AccountDTO accountDTO) {
            return Mapper.map(accountDTO);
        }
    };

   public AccountsService(){

       accountDAO =new AccountsDAO();
   }

   //get Account By Id
   @GET
   @Path("/{accountId}")
   @Produces(MediaType.APPLICATION_JSON)
   public AccountDTO getAccountById(@PathParam("accountId") String accountId) {
        Accounts account= accountDAO.getAccountById(Integer.parseInt(accountId));
        //map into Model Object
       AccountDTO dto=new AccountDTO();
       dto.setAccountId(String.valueOf(account.getAccountId()));
       dto.setCustomerId(String.valueOf(account.getCustomerId()));
       dto.setAccountNumber(account.getAccountNumber());
       dto.setAccountType(account.getAccountType());
       dto.setCurrency(account.getCurrency());
       dto.setBalance(String.valueOf(account.getBalance()));
       dto.setOpeningDate(String.valueOf(account.getOpeningDate()));
       dto.setClosingDate(String.valueOf(account.getClosingDate()));
       dto.setAccountStatus(account.getAccountStatus());
       dto.setOpeningBalance(String.valueOf(account.getOpeningBalance()));

        return dto;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountDTO> getAccounts()
    {
       List<Accounts> accounts=accountDAO.getAllAccounts();
       //map into AccountDto
       List<AccountDTO> accountDtos= accounts.stream().map(account ->{
           AccountDTO dto=new AccountDTO();
           dto.setAccountId(String.valueOf(account.getAccountId()));
           dto.setCustomerId(String.valueOf(account.getCustomerId()));
           dto.setAccountNumber(account.getAccountNumber());
           dto.setAccountType(account.getAccountType());
           dto.setCurrency(account.getCurrency());
           dto.setBalance(String.valueOf(account.getBalance()));
           dto.setOpeningDate(String.valueOf(account.getOpeningDate()));
           dto.setClosingDate(String.valueOf(account.getClosingDate()));
           dto.setAccountStatus(account.getAccountStatus());
           dto.setOpeningBalance(String.valueOf(account.getOpeningBalance()));
           return dto;
        }).collect(Collectors.toList());
            return accountDtos;
    }

//    @GET
//    @Path("/{accountNumber}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public AccountDTO getAccountByAccountNumber(@PathParam("accountNumber") String accountNumber){
//       //get the Accounts details by using AccountNUmber
//        Accounts  account =accountDAO.getAccountByAccountNumber(accountNumber);
//        AccountDTO dto=new AccountDTO();
//        dto.setAccountId(String.valueOf(account.getAccountId()));
//        dto.setCustomerId(String.valueOf(account.getCustomerId()));
//        dto.setAccountNumber(account.getAccountNumber());
//        dto.setAccountType(account.getAccountType());
//        dto.setCurrency(account.getCurrency());
//        dto.setBalance(String.valueOf(account.getBalance()));
//        dto.setOpeningDate(String.valueOf(account.getOpeningDate()));
//        dto.setClosingDate(String.valueOf(account.getClosingDate()));
//        dto.setAccountStatus(account.getAccountStatus());
//        dto.setOpeningBalance(String.valueOf(account.getOpeningBalance()));
//        return dto;
//   }

    //create a new account
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(AccountDTO accountDto){
       try {
           Accounts accounts = Mapper.map(accountDto);

           Integer id =accountDAO.createAccount(accounts);

           return Response.status(Response.Status.CREATED).entity("Account Created Successfully .Id"+ id)
                   .build();
       }
       catch (IllegalArgumentException e){
           return Response.status(Response.Status.BAD_REQUEST)
                   .entity(e.getMessage())
                   .build();
       }catch (Exception e){
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   .entity(e.getMessage())
                   .build();
       }
    }
}
