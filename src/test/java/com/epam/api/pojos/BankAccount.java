package com.epam.api.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class BankAccount {
    private Integer id;
    private String name;
    private Double balance;
    private Map<String,Object> user;
    private Object[] operations;
}
