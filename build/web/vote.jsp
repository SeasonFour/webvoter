<%-- 
    Document   : vote
    Created on : Dec 7, 2015, 1:21:17 PM
    Author     : kimaiga
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>E-Voter|Vote</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <link href="css/styles.css" rel="stylesheet">
  <!-- font-awsome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- fonts -->
  <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <!-- JavaScript  -->
  <script src="js/jquery-1.11.3.min.js"></script>
  <script src="js/modernizr.js"></script>
  
  <!--Session initializer-->
<body>
<!-- container div -->
<div id="wrapper">
  <div class="container">
<p>Verify Your Voter ID details in order to proceed</p>
    <!-- Verification form -->
<div class="row">
 <div class=".col-md-6">
  <form class="form-inline" action="VerifyVoter" method="POST">
   <div class="form-group">
    <label for="idNumber">ID NO:</label>
     <input type="text" name="id_number" class="form-control" id="idNo" placeholder="ID Number">
    </div>
   <!--<button type="submit" class="btn-default">Verify</button>-->
   <input type="submit" value="Verify" />
  </form>
 </div>
</div>

<br>

<div class="container">
<!-- image place-holders  -->
<div class="row">
  <!-- applying the four-column grid system -->
  <!-- grid 1 -->
  <div class="col-xs-6 col-sm-3">
      <h3>President</h3>
      <img src="" id="president" class="img-rounded">
      
<!--  Calling my Drop-down populating function    -->

      <!-- drop-down menu populates with presidential candidates from the database-->
  <form action="SavePresident" method="POST">   
      <select class="form-control" name="president">
        <option value="Uhuru_kenyatta">Uhuru Kenyatta</option>
        <option></option>
        <option></option>
        <option></option>
        <option></option>
     </select>
      <button type="submit" class="btn btn-primary">Vote</button>
  </form>   
       </div>

  <!-- grid 2 -->
   <div class="col-xs-6 col-sm-3">
      <h3>Governor</h3>
      <img src="" id="governor" class="img-rounded">
      <!-- drop-down menu populates with gubernatorial candidates-->
      <select class="form-control">
        <option>Evans Kidero</option>
        <option></option>
        <option></option>
        <option></option>
        <option></option>
     </select>
  </div>
  <!-- grid 3 -->
   <div class="col-xs-6 col-sm-3">
      <h3>Member of Parliament</h3>
      <img src="" id="mp" class="img-rounded">
      <!-- drop-down menu populates with parliamentary candidates-->
      <select class="form-control">
        <option>Nelson Kimaiga</option>
        <option></option>
        <option></option>
        <option></option>
        <option></option>
     </select>
  </div>
  <!-- grid 4 -->
   <div class="col-xs-6 col-sm-3">
      <h3>Councillor</h3>
      <img src="" id="mca" class="img-rounded">
      <!-- drop-down menu populates with county-rep candidates-->
      <select class="form-control">
        <option>Mbuvi Sonko</option>
        <option></option>
        <option></option>
        <option></option>
        <option></option>
     </select>
  </div>
<!-- end of grids -->
</div>
<!-- end of row -->
</div>

<br>
<!-- Vote serial id textbox -->
<div class="row">
 <div class=".col-md-6">
  <form class="form-inline">
  <div class="form-group">
    <label for="VoteSerial">Vote Serial Number:</label>
    <input type="text" class="form-control" id="voteserial">
  </div>
</form>
</div>
</div>

<!--<button type="button" class="btn btn-primary">Vote</button>-->

  </div>
</div>
<!--</div>-->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>


