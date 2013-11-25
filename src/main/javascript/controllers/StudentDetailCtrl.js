angular.module('library.controllers')

.controller('studentDetailCtrl', function($scope, $routeParams, $location, $cookies, studentService, messages) {

  var id = $routeParams.studentId;

  if (id !== undefined) {
    $scope.student = studentService.get({ studentId : id });
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


