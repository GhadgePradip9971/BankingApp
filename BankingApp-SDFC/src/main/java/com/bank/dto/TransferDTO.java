package com.bank.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransferDTO {

    @NotBlank(message = "From Account Number is required")
    private String fromAccountNumber;

    @NotBlank(message = "To Account Number is required")
    private String toAccountNumber;

    @NotBlank(message = "Aadhaar Number is required")
    private String aadharNumber;

    @NotNull(message = "Transfer Amount is required")
    @DecimalMin(value = "1.0", message = "Transfer amount must be greater than 0")
    private Double transferAmount;

    @Size(max = 100, message = "Description can contain at most 100 characters")
    private String description;
}