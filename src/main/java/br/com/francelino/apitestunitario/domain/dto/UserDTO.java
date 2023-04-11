package br.com.francelino.apitestunitario.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String nome;
    private String email;
    private String password;
}
