package com.example.emailsenderapp.helper;

import org.springframework.http.HttpStatus;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomResponse {

  private String message;
  private HttpStatus httpStatus;
  private boolean success = false;

}
