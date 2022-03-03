package pl.kowalecki.bnpapi.service;

import pl.kowalecki.bnpapi.model.ComputersModel;
import pl.kowalecki.bnpapi.model.ComputersModels;


import java.util.List;

public interface ComputersService {

    List<ComputersModel> getAllComputers();

    void addComputer(ComputersModel computersModel);

    ComputersModel getComputerById(int id);

    List<ComputersModel> getComputerByName(String name);

    void deleteById(int id);

    ComputersModels getAllComputersList();
}
