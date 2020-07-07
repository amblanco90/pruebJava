
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <title>Prueba</title>
    </head>
    <body>

        <div class="container">

            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Inicio de sesión</h5>
                            <form action="UsuarioControlador" class="form-signin">
                                <div class="form-label-group">
                                    <input  id="inputEmail" name="Documento" class="form-control" placeholder=" Documento" required autofocus>
                                    <label for="inputEmail">Documento</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Contraseña" required>
                                    <label for="inputPassword">Contraseña</label>
                                </div>


                                <input class="btn btn-primary" type="submit" name="accion" value="login">


                                <a href="UsuarioControlador?accion=add">Registro</a>


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
