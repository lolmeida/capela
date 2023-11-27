package com.lolmeida.entity.database;


import com.lolmeida.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tArmazem") //, schema = "sql7509759")
public class Armazem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, nullable = true, length = 255)
    private String Armazem;
    private String Morada;
    private String Teletofe;
    private boolean YN;
    //private String Descriçao;
    //private String Anexo;
}
