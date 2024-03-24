<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Patient Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    .logo {
        border-radius: 50%;
        width: 50px;
        height: 50px;
        margin: 0 10px 0 50px;
    }
    .brand-name {
        color: black;
    }
    .footer {
        background-color: #f8f9fa;
        padding: 20px 0;
        text-align: center;
    }
    .carousel-item img {
        max-height: 400px;
        object-fit: cover;
    }
    .light-effect {
        position: relative;
        display: flex;
        align-items: center;
    }
    .light {
        position: absolute;
        width: 0;
        height: 4px;
        background-color: yellow;
        bottom: 0;
        transition: width 0.3s ease;
    }
    .light-effect:hover .light {
        width: 100%;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <img class="logo" alt="Logo" src="img/abc.jpeg">
    <p class="brand-name fw-bold fs-4 mt-3">ABC LAB</p>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav ms-auto">
        <a class="nav-link mx-0 mx-md-3 fs-6" href="AppointmentDashboard.jsp">Make Appointment</a>
      </div>
    </div>
  </div>
</nav>

<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/patient.jpg" class="d-block w-100" alt="Slide 1">
    </div>
    <div class="carousel-item">
      <img src="img/home 1.jpg" class="d-block w-100" alt="Slide 2">
    </div>
    <div class="carousel-item">
      <img src="img/home 2.jpg" class="d-block w-100" alt="Slide 3">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <div class="light-effect">
                <div>
                    <h2>Welcome to ABC Lab</h2>
                    <p>We provide high-quality medical services with advanced technology and experienced professionals.</p>
                </div>
                <div class="light"></div>
            </div>
        </div>
    </div>
</div>

<footer class="footer mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h5>About Us</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet justo sed sem feugiat tristique.</p>
            </div>
            <div class="col-md-6">
                <h5>Contact Us</h5>
                <p>123 Main Street, City, Country</p>
                <p>Email: info@abclab.com</p>
                <p>Phone: +1234567890</p>
                <div class="social-icons">
                    <a href="#"><i class="bi bi-facebook"></i></a>
                    <a href="#"><i class="bi bi-twitter"></i></a>
                    <a href="#"><i class="bi bi-instagram"></i></a>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
