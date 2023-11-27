package com.lolmeida.entity.database;


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
    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, nullable = false, length = 255)

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String appName;
    private String appLogo;
    //private String Descriçao;
}
