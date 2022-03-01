package pl.kowalecki.bnpapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import pl.kowalecki.bnpapi.model.ComputersModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComputersService {

    @Autowired
    private DatabaseRepository databaseRepository;

    public List<ComputersModel> getAllComputers() {

        List<ComputersModel> computers = databaseRepository.findAll();

        if (computers.size() > 0){
            return computers;
        }else{
            return new ArrayList<>();
        }
    }
}
