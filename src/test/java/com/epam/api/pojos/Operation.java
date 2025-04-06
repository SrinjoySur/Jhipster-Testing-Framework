package com.epam.api.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Operation {
    private Integer id;
    private String date;
    private String description;
    private Double amount;
    private String bankAccount;
    private Object[] labels;
}
