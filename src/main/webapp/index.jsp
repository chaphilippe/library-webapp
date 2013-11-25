<%@page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html data-ng-app="library.app">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/bootstrap-glyphicons.css" rel="stylesheet">
  <link href="css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet">
  <link href="css/app.css" rel="stylesheet" media="screen">
  
  <style>
    [data-ng-cloak] { display: none !important; }
  </style>
  
  <title>Library</title>

</head>

<body data-ng-cloak>
  <div class="container" data-ng-view></div>
  
  <div id="error-dialog" class="modal hide fade">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal">&times;</button>
      <h3>System Error</h3>
    </div>
    <div class="modal-body">
      <p>Whoops! An unexpected error has occurred.</p>
    </div>
    <div class="modal-footer">
      <button class="btn" data-dismiss="modal">Close</button>
    </div>
  </div>

  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="js/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
  <script type="text/javascript" src="js/jquery.iframe-transport.js"></script>
  <script type="text/javascript" src="js/jquery.fileupload.js"></script>
  <script type="text/javascript" src="js/angular-1.1.5.min.js"></script>
  <script type="text/javascript" src="js/angular-resource-1.1.5.min.js"></script>
  <script type="text/javascript" src="js/angular-cookies-1.1.5.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.file-input.js"></script>

  <script type="text/javascript" src="http://code.angularjs.org/1.1.5/i18n/angular-locale_${locale}.js"></script>
  <script type="text/javascript" src="i18n.js"></script>

  <script type="text/javascript" src="js/app.js"></script>


</body>

</html>

