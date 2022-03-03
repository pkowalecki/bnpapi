package pl.kowalecki.bnpapi.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "faktura")
public class ComputersModels {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "komputer")
    private List<ComputersModel> computersModels;
}
