<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Calculadora</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Estilos da aplicação. -->
<link href="css/style.css" rel="stylesheet">
</head>
<body>
  <div class="container" style="margin-top: 30px">
    <div class="col-md-12">
      <div class="modal-dialog" style="margin-bottom: 0">
        <div class="modal-content">
          <div class="panel-heading">
            <h3 class="panel-title">Calculadora</h3>
          </div>
          <div class="panel-body">
            <form role="form">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="Operador 1" name="operador1"
                    type="text" value="${param.operador1}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Operação" name="operacao"
                    type="text" value="${param.operacao}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Operador 2" name="operador2"
                    type="text" value="${param.operador2}">
                </div>
                <input type="submit" class="btn btn-sm btn-success" value="Calcular">
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/bootbox.min.js"></script>
  <!-- Script da aplicação. -->
  <script src="js/script.js"></script>
</body>
</html>