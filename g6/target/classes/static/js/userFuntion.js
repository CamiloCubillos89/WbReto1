<script>
    $(document).ready(function() {
      // FUNCIÓN PARA ADICIONAR
      $('#formulario').on('submit', function(event) {
        event.preventDefault();
        
        var nombre = $('#nombre').val();
        var email = $('#email').val();
        var password = $('#password').val();
        
        $.ajax({
          url: '/api/adicionar',
          method: 'POST',
          data: { nombre: nombre, email: email, password: password },
          success: function(response) {
            // Dejar limpios los campos después de ADICIONAR
            $('#nombre').val('');
            $('#email').val('');
            $('#password').val('');
          }
        });
      });
      
      //FUNCIÓN PARA MODIFICAR
      $('#modificar').on('click', function() {
        
        var nombre = $('#nombre').val();
        var email = $('#email').val();
        var password = $('#password').val();
        
        $.ajax({
          url: '/api/modificar',
          method: 'PUT',
          data: { nombre: nombre, email: email, password: password },
          success: function(response) {
          }
        });
      });
      
      //FUNCIÓN PARA ELIMINAR
      $('#eliminar').on('click', function() {
        var email = $('#email').val();

        $.ajax({
          url: '/api/eliminar',
          method: 'DELETE',
          data: { email: email },
          success: function(response) {
          }
        });
      });
      
      //FUNCIÓN PARA LISTAR
      $('#listar').on('click', function() {

        $.ajax({
          url: '/api/listar',
          method: 'GET',
          success: function(response) {
            // Limpiar tabla
            $('#tabla-body').empty();
            // Construir filas de la tabla
            for (var i = 0; i < response.length; i++) {
              var usuario = response[i];
              
              var fila ='<tr>' +
                        '<td>' + usuario.nombre + '</td>' +
                        '<td>' + usuario.email + '</td>' +
                        '<td> Acciones </td>' +
                        '</tr>';
              $('#tabla-body').append(fila);
            }
          }
        });
      });
      
    });
  </script>
