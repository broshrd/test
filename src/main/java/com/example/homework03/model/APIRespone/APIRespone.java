package com.example.homework03.model.APIRespone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIRespone<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime time;

}
