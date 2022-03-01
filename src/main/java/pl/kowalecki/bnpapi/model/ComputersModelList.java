package pl.kowalecki.bnpapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class ComputersModelList {

    public List<ComputersModel> computersModelsList;

    public ComputersModelList() {
    }

    public ComputersModelList(List<ComputersModel> computersModelsList) {
        this.computersModelsList = computersModelsList;
    }

    public List<ComputersModel> getComputersModelsList() {
        return computersModelsList;
    }

    public void setComputersModelsList(List<ComputersModel> computersModelsList) {
        this.computersModelsList = computersModelsList;
    }

    @Override
    public String toString() {
        return "ComputersModelList{" +
                "computersModelsList=" + computersModelsList +
                '}';
    }
}
