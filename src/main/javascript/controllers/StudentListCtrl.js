angular.module('library.controllers')

.controller('studentListCtrl', function($scope, studentService, authService) {
  $scope.students = studentService.query();
  $scope.query = '';

  $scope.search = function(query) {
    $scope.books = studentService.query({ q : query }, function() {
      $scope.showClear = query.length > 0;
    });
  };

  $scope.searchIcon = function() {
    if ($scope.showClear) {
      $scope.query = '';
    }
    $scope.search($scope.query);
  };

  $scope.canEdit = authService.isAdmin();
  
});


