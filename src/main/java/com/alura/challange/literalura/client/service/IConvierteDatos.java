package com.alura.challange.literalura.client.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}