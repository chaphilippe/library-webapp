angular.module('library.controllers')

.controller('teacherDetailCtrl', function($scope, $routeParams, $location, $cookies, teacherService, messages) {

  var id = $routeParams.teacherId;

  if (id !== undefined) {
    $scope.teacher = teacherService.get({ teacherId : id });
  } else {
    $scope.teacher = {};
  }

  $scope.save = function(teacher) {
    teacherService.save(teacher, function() {
      $location.path('/teachers');
    });
  };

  $scope.remove = function(id) {
    teacherService.remove({ teacherId : id }, function() {
      $location.path('/teachers');
    });
  };
 
  $('#input-title').focus();
  
});
