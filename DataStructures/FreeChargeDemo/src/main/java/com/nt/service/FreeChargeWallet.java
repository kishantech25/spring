package com.nt.service;

import com.mysql.cj.exceptions.StreamingNotifiable;
import com.nt.config.Accounts;
import com.nt.model.AccountDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Path("/freecharge")
public class FreeChargeWallet {
    private static Map<String, Accounts> accountmap =null;
    private AccountDTO accountDto=null;

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput register(InputStream io) throws ParserConfigurationException, SAXException, IOException
    {
        Accounts accounts =buildRegister(io);
        OutputStreamRegisterHandler osh =new OutputStreamRegisterHandler(accounts.getAccountNumber(),accounts.getMobileNo());
        return osh;
    }
    public Accounts buildRegister(InputStream io) throws ParserConfigurationException,SAXException,IOException
    {
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =factory.newDocumentBuilder();
        Document accountDoc =builder.parse(io);
        Node firstNode =null;
        NodeList list =null;
        Node node =null;

        if(accountDoc!=null){
            firstNode=accountDoc.getFirstChild();
            list=firstNode.getChildNodes();
            accountDto=new AccountDTO();
            accountmap =new ConcurrentHashMap<String,Accounts>();

            for(int i=0;i<list.getLength();i++){
                node=list.item(i);

                for(int i=0;i<list.getLength();i++){
                    node=list.item(i);

                    if(node.getNodeType() ==Node.ELEMENT_NODE){
                        String name =node.getNodeName();
                        String value=node.getFirstChild().getTextContent();
                        if(name.equals("accountId")){
                            accountDto.setAccountId(value);
                        }
                        if(name.equals("customerId")){
                            accountDto.setCustomerId(value);
                        }
                        if(name.equals("accountNumber")){
                            accountDto.setAccountNumber(value);
                        }
                        if(name.equals("accountType")){
                            accountDto.setAccountType(value);
                        }
                        if(name.equals("currency")){
                            accountDto.setCurrency(value);
                        }
                        if(name.equals("balance")){
                            accountDto.setBalance(value);
                        }
                        if(name.equals("interestRate")){
                            accountDto.setInterestRate(value);
                        }
                        if(name.equals("openingBalance")){
                           accountDto.setOpeningBalance(value);
                        }
                        if(name.equals("openingDate")){
                          accountDto.setOpeningBalance(value);
                        }
                        if(name.equals("closingDate")){
                         accountDto.setClosingDate(value);
                        }
                        if(name.equals("accountStatus")){
                         accountDto.setAccountStatus(value);
                        }
                        if(name.equals("minimumBalance")){
                          accountDto.setMinimumBalance(value);
                        }
                    }
                }

            }
        }
        accountDto.setAccountNumber(UUID.randomUUID().toString());
        accountmap.put(accountDto.getMinimumBalance(),accountDto);
        return accountDto;
    }

    private class OutputStreamingRegisterHandler implements StreamingOutput{

        private String accountNo=null;
        private String mobileNo=null;

        public outputStreamingRegisterHandler(String accountNo,String mobileNo){
            this.accountNo =accountNo;
            this.mobileNo=mobileNo;
        }
        @Override
        public void write(OutputStream os) throws IOException, WebApplicationException{

            StringBuffer bufffer =new StringBuffer();
            bufffer.append("<account-info>").append("<account-no>")
                    .append("account-no").append("</account-no>")
                    .append("<mobile-no>").append("</mobile-no>");
            os.write(bufffer.toString().getBytes());
            os.close();
        }
    }
}
