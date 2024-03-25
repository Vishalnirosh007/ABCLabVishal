<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Lab</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <div class="container-fluid" >
    <img style="border-radius:50%;width: 70px;height: 70px; margin:0 10px 0 50px " alt="" src="img/abc.jpeg">
    <p class="fw-bold fs-4 mt-3" style="color: black;">ABC Lab</p>
    <button style="margin:0 30px;" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup" style="margin:0 50px;">
      <div class="navbar-nav" style="#ffff">
        <a class="nav-link active mx-0 mx-md-3 fs-6" aria-current="page" href="HospitlHome.jsp">Home</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="DoctorLogin.jsp">Doctor</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="AdminLogin.jsp">Admin</a>
        <a class="nav-link mx-0 mx-md-3 fs-6" href="LabWorkerLodgin.jsp">LabWorker</a>
        
      </div>
    </div>
  </div>
</nav>






<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" style="height: 450px">
      <img src="img/home 1.jpg" class="d-block w-100" alt="..." style="height: 100%; object-fit:cover; filter: brightness(0.5);">
      <div class="carousel-caption d-none d-md-block top-0 mt-4">
        <h5 class="display-1 fw-bolder text-capitalize">Doctor Portal</h5>
        
      </div>
    </div>
    <div class="carousel-item" style="height: 450px">
      <img src="img/home 2.jpg" class="d-block w-100" alt="..." style="height: 100%; object-fit:cover; filter: brightness(0.6);">
      <div class="carousel-caption d-none d-md-block top-0 mt-4">
        <h5 class="display-1 fw-bolder text-capitalize">Admin Portal</h5>
        
      </div>
    </div>
    <div class="carousel-item" style="height: 450px">
      <img src="img/home 2.jpg" class="d-block w-100" alt="..." style="height: 100%; object-fit:cover; filter: brightness(0.6);">
      <div class="carousel-caption d-none d-md-block top-0 mt-4">
        <h5 class="display-1 fw-bolder text-capitalize">LabWorker Portal</h5>
        
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>













<div class="row align-items-center"  style="padding: 50px">
    <div class="col" style="margin:10px;">
		<div class="card text-center" style="width: 18rem;">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<a href="#" class="card-link">Card link</a>
    			<a href="#" class="card-link">Another link</a>
  			</div>
		</div>
    </div>
    
    <div class="col" style="margin:10px;">
		<div class="card text-center" style="width: 18rem;">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<a href="#" class="card-link">Card link</a>
    			<a href="#" class="card-link">Another link</a>
  			</div>
		</div>
    </div>
    
    <div class="col" style="margin:10px;">
		<div class="card text-center" style="width: 18rem;">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<a href="#" class="card-link">Card link</a>
    			<a href="#" class="card-link">Another link</a>
  			</div>
		</div>
    </div>
    
  </div>
 

</body>
</html>