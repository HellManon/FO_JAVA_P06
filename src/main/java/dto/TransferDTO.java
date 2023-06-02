package dto;

import lombok.Data;

@Data
public class TransferDTO {

    private String name;
    private String description;

    private float amount;

    public TransferDTO (String name, String description, Float amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public TransferDTO () {

    }
}
