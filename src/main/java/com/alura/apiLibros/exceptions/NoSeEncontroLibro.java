package com.alura.apiLibros.exceptions;

public class NoSeEncontroLibro extends RuntimeException{
    private String mensaje;

    //constructor
    public NoSeEncontroLibro(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMessage(){
        return mensaje;
    }
}
