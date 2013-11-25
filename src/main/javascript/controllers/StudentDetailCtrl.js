angular.module('library.controllers')

.controller('studentDetailCtrl', function($scope, $routeParams, $location, $cookies, studentService, messages) {

  var id = $routeParams.bookId;

  if (id !== undefined) {
    $scope.student = studentService.get({ bookId : id });
  } else {
    $scope.student = {};
  }

  $scope.save = function(student) {
    studentService.save(student, function() {
      $location.path('/students');
    });
  };

  $scope.remove = function(id) {
    studentService.remove({ studentId : id }, function() {
      $location.path('/students');
    });
  };
 
  $('#input-title').focus();
  
});


