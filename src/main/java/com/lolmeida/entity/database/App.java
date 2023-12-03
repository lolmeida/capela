package com.lolmeida.entity.database;


import com.lolmeida.Utils;
import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tApps") //, schema = "sql7509759")
public class App extends BaseEntity {

    @Id
    private String id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, nullable = true, length = 255)
    private String appName;
    private String appLogo;


}
