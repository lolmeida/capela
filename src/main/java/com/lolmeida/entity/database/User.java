package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tUtilizadores") //, schema = "sql7509759")
public class User extends BaseEntity {
    @Id
    private String id;

    private String email;

    private String name;

    private String phoneNumber;

    private String address;

    private String signature;

    private String privilege;

    private String permission;



    private List<String> cargoList;
    private List<String> receiptList;
    private List<String> clientList;
    private List<String> recipientList;
    private List<String> sizeList;

}
