package pl.kowalecki.bnpapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalecki.bnpapi.database.DatabaseRepository;
import pl.kowalecki.bnpapi.model.ComputersModel;
import pl.kowalecki.bnpapi.model.ComputersModels;

import java.util.List;
import java.util.Optional;

@Service
public class ComputersServiceImpl implements ComputersService {

    @Autowired
    private DatabaseRepository databaseRepository;

    @Override
    public List<ComputersModel> getAllComputers() {
        return databaseRepository.findAll();
    }


    @Override
    public void addComputer(ComputersModel computersModel) {
        this.databaseRepository.save(computersModel);
    }

    @Override
    public ComputersModel getComputerById(int id) {
        Optional<ComputersModel> optional = databaseRepository.findById(id);
        ComputersModel computersModel = null;
        if (optional.isPresent()) {
            computersModel = optional.get();
        } else
            throw new RuntimeException("Computer not found for id: " + id);
        return computersModel;
    }

    @Override
    public List<ComputersModel> getComputerByName(String name) {
        if (name != null) {
            return databaseRepository.search(name);
        } else {
            return databaseRepository.findAll();
        }
    }


    @Override
    public void deleteById(int id) {
        this.databaseRepository.deleteById(id);
    }

    @Override
    public ComputersModels getAllComputersList() {
        ComputersModels computersModels = new ComputersModels();
        computersModels.setComputersModels(databaseRepository.findAll());
        return computersModels;
    }

}
