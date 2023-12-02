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
    private String id;

    @NotEmpty(message = "this is a field is mandatory.")
    @Column(unique = true, nullable = false, length = 25)
    private String Armazem;
    private String Morada;
    private String Teletofe;
    private boolean YN;
}
