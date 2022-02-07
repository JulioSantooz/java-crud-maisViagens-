<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.css">
<title>+Viagens - Atualizar feedback</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="destino.html">Destino <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="promocao.html">Promoções <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="feedback.html">Feedbacks <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <form action="CreateAndFind" method="GET" class="form-inline my-2 my-lg-0">
      <span class="mr-4">Procurar por feedback:</span>
      <input name="pesquisa" class="form-control mr-sm-2" type="search" placeholder="Digíte a data ou palavras chave" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
      <button class="btn btn-outline-success my-2 my-sm-0 ml-1" type="submit">Feedbacks</button>
    </form>
  </div>
</nav>

<main class="container text-center mt-3">
	<div class="row">
		<div class="col-12">
			<h1 class="display-4 my-3 border-bottom">Feedbacks</h1>
			<div class="row">
				<div class="col-2 mt-2">
					<h1>Atualizar Feedback:</h1>
				</div>
			</div>
			<form action="FeedbackUpdate" method="POST">
				<input value="${feedback.id_feedback}" name="id" type="number" style="visibility: hidden;">
                <div class="form-row mt-2 d-flex flex-column">
                    <div class="form-group col-4">
                        <label for="" class="float-left">Data:</label>
                        <input value="${feedback.data}" name="data" type="date" class="form-control" id="">
                    </div>
                    <div class="form-group col-12 col-sm-12 col-md-12 col-lg-8">
                        <label for="" class="float-left">Descrição:</label>
                        <input value="${feedback.descricao}" name="descricao" type="text" class="form-control" id="">
                    </div>
                </div>
                <button type="submit" class="btn btn-lg btn-info my-4 float-left">Atualizar Feedback</button>
                <button type="reset" class="btn btn-lg btn-info ml-3 my-4 float-left">Limpar Campos</button>
            </form>
		</div>
	</div>
</main>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.js"></script>

</body>
</html>