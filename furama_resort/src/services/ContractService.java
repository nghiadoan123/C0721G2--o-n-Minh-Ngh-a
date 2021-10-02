package services;

public interface ContractService extends Service {
    void createContract() throws Exception;
    void displayContractList();
    void editContract();
    void searchContractId();
}
