package com.lolmeida.api.entity.database;


import com.lolmeida.api.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "tApps") //, schema = "sql7509759")
public class App extends BaseEntity {



    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, length = 255)
    private String appName;
    private String appLogo;


}
