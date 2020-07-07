/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author AM BLANCO
 */
public interface UsuarioInterface {

    public Usuario list(String doc, String pass);

    public List list();

    public boolean add(Usuario per);

}
