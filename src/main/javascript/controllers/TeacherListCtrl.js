angular.module('library.controllers')

.controller('teacherListCtrl', function($scope, teacherService, authService) {
  $scope.teachers = teacherService.query();
  $scope.title = 'Teachers';
  $scope.query = '';

  $scope.search = function(query) {
    $scope.teachers = teacherService.query({ q : query }, function() {
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


