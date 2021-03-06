<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>COMPRAS</title>
    </head>
    <body>
        
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/generales/botonRegresarInicio.jsp"/>
        <jsp:include page="/WEB-INF/compra/encabezado.jsp"/>
        
        <jsp:include page="/WEB-INF/compra/registro.jsp"/>
        
        <!--pie de página-->
        <jsp:include page="/WEB-INF/generales/piePagina.jsp"/>
        
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
